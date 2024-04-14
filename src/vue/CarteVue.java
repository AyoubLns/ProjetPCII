// CarteVue.java
package vue;

import controller.UnitControl;
import model.BouttonPlanter;
import model.ListeJardiniers;
import model.RessourceManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CarteVue extends JFrame {
    public static final int width = 1500, height = 800;
    public CarteVue(){
        JFrame frame = new JFrame("Jeu de jardinage");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setResizable(false);


        Boutton boutton = new Boutton();

        /* la liste des jardiniers pour les tests */
        ListeJardiniers lj = new ListeJardiniers(boutton);

        RessourceVue ressourceVue = new RessourceVue(boutton);

        //création des cartes
        CarteView carteView = new CarteView(lj, boutton);
        UnitControl controller = new UnitControl(lj);


        carteView.addMouseListener(controller);

        CarteGestion carteGestion = new CarteGestion(boutton);

        frame.setLayout(new BorderLayout());
        frame.add(boutton.getBtnPlanter());
        frame.add(boutton.getBtnRecolter());

        frame.add(ressourceVue.getBtnRessource1());
        frame.add(ressourceVue.getBtnRessource2());
        frame.add(ressourceVue.getBtnRessource3());
        frame.add(ressourceVue.getBtnRessource4());

        frame.add(carteView, BorderLayout.CENTER);
        frame.add(carteGestion, BorderLayout.EAST);

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
