package controller;

import model.BouttonRecolter;
import vue.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RessourcePanel extends JPanel {
    private Ressource ressource;
    String nom; // Nom de la ressource
    private JLabel etatLabel;
    private JProgressBar progressBar;
    private Boutton boutton;

    public RessourcePanel(Ressource ressource, String nom, Boutton boutton){ // Passer Boutton en paramètre
        this.ressource = ressource;
        this.nom = nom;
        this.boutton = boutton; // Initialiser l'objet boutton

        etatLabel = new JLabel(getNom() + ressource.getetat());
        this.add(etatLabel);

        // Initialiser la barre de progression
        progressBar = new JProgressBar(0, 10); // Les états vont de 0 à 10
        progressBar.setValue(ressource.getetat());
        progressBar.setStringPainted(true); // Pour afficher le texte sur la barre
        this.add(progressBar);

        // si etat = 0 afficher "jeune" sur la barre de progression
        progressBar.addChangeListener(e -> {
            if (progressBar.getValue() > 0 && progressBar.getValue() < 5) {
                progressBar.setString("Jeune");
                progressBar.setForeground(Color.GRAY);

            }
        });
        // si etat = 10 afficher "pourri" sur la barre de progression
        progressBar.addChangeListener(e -> {
            if (progressBar.getValue() == 10) {
                progressBar.setString("Pourri");
                progressBar.setForeground(java.awt.Color.RED);
            }
        });
        // SI etat = 5 afficher "mûr" sur la barre de progression
        progressBar.addChangeListener(e -> {
            if (progressBar.getValue() == 5) {
                progressBar.setString("Mûr");
                progressBar.setForeground(java.awt.Color.ORANGE);

            }
        });

        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                boutton.replaceBtnRecolter();

                boutton.getBtnRecolter().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        (new BouttonRecolter(boutton)).start();
                        etatLabel.setText(getNom() + progressBar.getValue());
                        progressBar.setValue(ressource.getetat());

                        int valeur = ressource.recolte();
                        System.out.println("Valeur : " + valeur);
                        System.out.println("État : " + progressBar.getValue());
                    }
                });
            }
        });
    }

    private String getNom() {

        return nom; // Nom de la ressource
    }

    public void updateressourceetat() {
        ressource.updateetat();
        etatLabel.setText(getNom() + ressource.getetat());
        progressBar.setValue(ressource.getetat());
    }

    public void setBounts(int x, int y, int width, int heigth) {
        this.setBounds(x, y, width, heigth);
    }
}
