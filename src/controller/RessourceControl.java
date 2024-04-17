package controller;

import vue.Boutton;
import vue.RessourceVue;

import javax.swing.*;
import java.awt.*;

public class RessourceControl extends JPanel {
    private final RessourceVue ressourceVue;
    String nom; // Nom de la ressource
    private final JLabel etatLabel;
    private final JProgressBar progressBar;

    // Constructeur prenant une instance de RessourceVue, un nom de ressource et un Boutton
    public RessourceControl(RessourceVue rv, String nom, Boutton boutton) {
        this.ressourceVue = rv;
        this.nom = nom;

        etatLabel = new JLabel(getNom() + ressourceVue.getetat());
        this.add(etatLabel);

        // Initialiser la barre de progression
        progressBar = new JProgressBar(0, 10); // Les états vont de 0 à 10
        progressBar.setValue(ressourceVue.getetat());
        progressBar.setStringPainted(true); // Pour afficher le texte sur la barre
        this.add(progressBar);

        // Ajouter un écouteur de changement pour la barre de progression
        progressBar.addChangeListener(e -> {
            // Si l'état est entre 0 et 2, afficher "Pas encore plantée" en blanc
            if (progressBar.getValue() > 0 && progressBar.getValue() < 2) {
                progressBar.setString("Pas encore plantée");
                progressBar.setForeground(Color.WHITE);
            }
            // Si l'état est entre 2 et 5, afficher "Jeune" en gris
            else if (progressBar.getValue() >= 2 && progressBar.getValue() < 5) {
                progressBar.setString("Jeune");
                progressBar.setForeground(Color.GRAY);
            }
            // Si l'état est égal à 5, afficher "Mûr" en orange
            else if (progressBar.getValue() == 5) {
                progressBar.setString("Mûr");
                progressBar.setForeground(Color.ORANGE);
            }
            // Si l'état est égal à 10, afficher "Pourri" en rouge
            else if (progressBar.getValue() == 10) {
                progressBar.setString("Pourri");
                progressBar.setForeground(Color.RED);
            }
        });
    }

    // Méthode pour obtenir le nom de la ressource
    private String getNom() {
        return nom; // Nom de la ressource
    }

    // Méthode pour mettre à jour l'état de la ressource et actualiser l'affichage
    public void updateressourceetat() {
        ressourceVue.updateetat();
        etatLabel.setText(getNom() + ressourceVue.getetat());
        progressBar.setValue(ressourceVue.getetat());
    }

    // Méthode pour définir la position et la taille du panneau
    public void setBounts(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
    }
}
