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
        frame.setResizable(false);

        /* la liste des jardiniers pour les tests */
        ListeJardiniers lj = new ListeJardiniers();

        Boutton boutton = new Boutton();
        RessourceVue ressourceVue = new RessourceVue(boutton);
        new ReactionClic(boutton);

        CarteVue carteVue = new CarteVue(lj, boutton);
        /* le contrôleur pour les clics jardinier */
        UnitControl controller = new UnitControl(lj);
        carteVue.addMouseListener(controller);

        frame.setLayout(new BorderLayout());
        frame.add(boutton.getBtnDeplacer());
        frame.add(boutton.getBtnPlanter());
        frame.add(boutton.getBtnRecolter());
        frame.add(boutton.getBtnRester());

        frame.add(ressourceVue.getBtnRessource1());
        frame.add(ressourceVue.getBtnRessource2());
        frame.add(ressourceVue.getBtnRessource3());
        frame.add(ressourceVue.getBtnRessource4());

        CarteModel carteModel = new CarteModel();
        CarteController carteController = new CarteController(carteModel, carteVue);

        frame.add(carteVue);

        // On cree et et demarre  les RessourceManagers
        RessourceManager ressourceManager1 = new RessourceManager(ressourceVue.getBtnRessource1(), ressourceVue.getFlrBleu());
        RessourceManager ressourceManager2 = new RessourceManager(ressourceVue.getBtnRessource2(), ressourceVue.getFlrJaune());
        RessourceManager ressourceManager3 = new RessourceManager(ressourceVue.getBtnRessource3(), ressourceVue.getFlrVerte());
        RessourceManager ressourceManager4 = new RessourceManager(ressourceVue.getBtnRessource4(), ressourceVue.getFlrRouge());

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