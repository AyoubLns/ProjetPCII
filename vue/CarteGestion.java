// CarteVue.java
package vue;

import controller.RessourceControl;
import model.Fleur;
import model.Jardinier;
import model.ListeFleurs;
import model.ListeJardiniers;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class CarteGestion extends JPanel {
    private int width = 240, height = 600;


    Boutton boutton;

    /** Le constructeur : charge l'image des jardiniers, note la liste pour le paint, et lance le thread de repaint */
    public CarteGestion(Boutton boutton){
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.DARK_GRAY);

        this.boutton = boutton;

    }


    /** Cette classe définit le panel principal dans lequel on dessine les jardiniers */

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        super.paintComponent(g2d);


        g2d.setColor(Color.GRAY);
        g2d.fillRect(560, 0, width - 560, height);

        g2d.setColor(Color.BLACK);
        g2d.drawRect(560, 0, width - 561, height - 1);

    }
}
