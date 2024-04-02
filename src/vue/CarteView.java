package vue;

import model.Jardinier;
import model.ListeJardiniers;

import javax.swing.*;
import java.awt.*;

/** Cette classe définit le panel principal dans lequel on dessine les jardiniers */
public class CarteView extends JPanel {
    private int width = 560, height = 600;

    /** La constante qui définit le rayon du cercle autour des jardiniers */
    public static final int RAYON = 57;

    /** La liste des jardiniers */
    private ListeJardiniers lj;
    /** L'image pour dessiner les jardiniers */
    private Image jardinierImage;

    private boolean selected = false;

    /** Le constructeur : charge l'image des jardiniers, note la liste pour le paint, et lance le thread de repaint */
    public CarteView(ListeJardiniers jardiniers){
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.LIGHT_GRAY);

        // garder la liste des jardiniers
        this.lj = jardiniers;

        // Chargement de l'image
        try {
            this.jardinierImage = new ImageIcon("images/jardinier.png").getImage();
        } catch (Exception e) {
            e.printStackTrace();
            // Gestion d'erreur : ne pas planter l'application si l'image ne peut pas être chargée
        }

        (new Redessine(this)).start();
    }


    /** Cette classe définit le panel principal dans lequel on dessine les jardiniers */

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        super.paintComponent(g2d);

        for (Jardinier jardinier : lj.getJardiniers()) {
            int jardinierX = jardinier.getX();
            int jardinierY = jardinier.getY();

            g2d.setColor(new Color(173, 216, 230, 150));
            ((Graphics2D) g).setStroke(new BasicStroke(3.0f));
            g2d.fillOval(jardinierX - RAYON, jardinierY - RAYON, 2 * RAYON, 2 * RAYON);

            g2d.setColor(new Color(0, 0, 255));
            g2d.drawOval(jardinierX - RAYON, jardinierY - RAYON, 2 * RAYON, 2 * RAYON);

            int imageX = jardinierX - jardinierImage.getWidth(this) / 2;
            int imageY = jardinierY - jardinierImage.getHeight(this) / 2;
            g2d.drawImage(jardinierImage, imageX, imageY, this);


            // Définissez la police en gras et 2x plus grande
            Font font = new Font("Arial", Font.BOLD, 16);
            g2d.setFont(font);

            // Définissez la couleur du texte en noir
            g2d.setColor(Color.BLACK);

            // Dessinez le nom
            g2d.drawString(jardinier.getId(), jardinierX - RAYON / 2, jardinierY - RAYON + 35);

        }

    }
}