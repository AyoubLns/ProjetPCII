// CarteVue.java
package vue;

import javax.swing.JPanel;
import java.awt.*;

public class CarteVue extends JPanel {
    private int width = 800, height = 600;

    public CarteVue(){
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.LIGHT_GRAY);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.GRAY);
        g2d.fillRect(560, 0, width - 560, height);

        g2d.setColor(Color.BLACK);
        g2d.drawRect(560, 0, width - 561, height-1);

    }
}
