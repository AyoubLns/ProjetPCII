// CarteVue.java
package vue;

import controller.ReactionClic;
import controller.UnitControl;
import model.Jardinier;
import model.ListeJardiniers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class CarteVue extends JFrame {
    private int width = 800, height = 600;

    public CarteVue(){
        JFrame frame = new JFrame("Jeu de jardinage");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setResizable(true);

        /* la liste des jardiniers pour les tests */
        ListeJardiniers lj = new ListeJardiniers();
        //ajoute des boutons
        Boutton boutton = new Boutton();

        //création des cartes
        CarteView carteView = new CarteView(lj);
        UnitControl controller = new UnitControl(lj);

        CarteGestion carteGestion = new CarteGestion(boutton);

        boutton.getBtnDeplacer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ajouter le MouseListener à carteView lorsque le bouton est cliqué
                carteView.addMouseListener(controller);
            }
        });

        frame.add(carteView, BorderLayout.CENTER);
        frame.add(carteGestion, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
    }
}
