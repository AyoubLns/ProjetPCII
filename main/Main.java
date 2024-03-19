package main;

import model.*;
import vue.*;
import controller.*;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Jeu de jardinage");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setResizable(true);

        CarteModel carteModel = new CarteModel();
        CarteVue carteVue = new CarteVue();
        CarteController carteController = new CarteController(carteModel, carteVue);

        Boutton boutton = new Boutton();
        Ressource ressource = new Ressource(boutton);
        new ReactionClic(boutton);

        frame.setLayout(new BorderLayout());
        frame.add(boutton.getBtnDeplacer());
        frame.add(boutton.getBtnPlanter());
        frame.add(boutton.getBtnRecolter());
        frame.add(boutton.getBtnRester());

        frame.add(ressource.getBtnRessource1());
        frame.add(ressource.getBtnRessource2());
        frame.add(ressource.getBtnRessource3());
        frame.add(ressource.getBtnRessource4());
    /*
        frame.add(ressource.getFlrBleu());
        frame.add(ressource.getFlrJaune());
        frame.add(ressource.getFlrVerte());
        frame.add(ressource.getFlrRouge());
    */

        frame.add(carteVue);

        // On cree et et demarre  les RessourceManagers
        RessourceManager ressourceManager1 = new RessourceManager(ressource.getBtnRessource1(), ressource.getFlrBleu());
        RessourceManager ressourceManager2 = new RessourceManager(ressource.getBtnRessource2(), ressource.getFlrJaune());
        RessourceManager ressourceManager3 = new RessourceManager(ressource.getBtnRessource3(), ressource.getFlrVerte());
        RessourceManager ressourceManager4 = new RessourceManager(ressource.getBtnRessource4(), ressource.getFlrRouge());

        boutton.getBtnPlanter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new BouttonPlanter(boutton)).start();
                ressourceManager1.start();
                ressourceManager2.start();
                ressourceManager3.start();
                ressourceManager4.start();
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}
