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
        new ReactionClic(boutton);

        CarteVue carteVue = new CarteVue(lj);
        /* le contrôleur pour les clics jardinier */
        UnitControl controller = new UnitControl(lj);
        carteVue.addMouseListener(controller);

        CarteModel carteModel = new CarteModel();
        CarteController carteController = new CarteController(carteModel, carteVue);

        frame.setLayout(new BorderLayout());
        frame.add(boutton.getBtnDeplacer());
        frame.add(boutton.getBtnPlanter());
        frame.add(boutton.getBtnRecolter());
        frame.add(boutton.getBtnRester());

        frame.add(carteVue);

        frame.pack();
        frame.setVisible(true);
    }
}
