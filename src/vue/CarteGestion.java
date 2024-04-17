// CarteVue.java
package vue;

import javax.swing.*;
import java.awt.*;


public class CarteGestion extends JPanel {
    public static final int width = 400, height = 800;


    Boutton boutton;

    /** Le constructeur : charge l'image des jardiniers, note la liste pour le paint, et lance le thread de repaint */
    public CarteGestion(Boutton boutton){
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.decode("#4A5D23"));

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
