package main;

import controller.UnitControl;
import model.ListeJardiniers;
import vue.Boutton;

import javax.swing.*;


public class MainJardinier {
    public static void main(String[] args) {

        /* la liste des jardiniers pour les tests */
        Boutton boutton = new Boutton();

        ListeJardiniers lj = new ListeJardiniers();
        //ListeFleurs lf = new ListeFleurs();

        /* la carte pour visualiser les jardiniers */
        //CarteVue carteView = new CarteVue(lj);

        // Ça serait bien que le code ci-dessous soit dans une classe "MainView", juste pour faciliter l'intégration
        JFrame frame = new JFrame("Carte avec jardiniers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.add(carteView);
        frame.setSize(500, 500);
        frame.setVisible(true);

        /* le contrôleur pour les clics jardinier */
        UnitControl controller = new UnitControl(lj);
        //carteView.addMouseListener(controller);
    }
}