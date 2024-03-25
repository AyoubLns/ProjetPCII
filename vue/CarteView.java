package vue;

import model.Jardinier;
import model.ListeJardiniers;

import javax.swing.*;
import java.awt.*;

/** Cette classe définit le panel principal dans lequel on dessine les jardiniers */
public class CarteView extends JPanel {
/*
    // La constante qui définit le rayon du cercle autour des jardiniers
    public static final int RAYON = 100;

    // La liste des jardiniers
    private ListeJardiniers lj;
    // L'image pour dessiner les jardiniers
    private Image jardinierImage;

    private boolean selected = false;

    // Le constructeur : charge l'image des jardiniers, note la liste pour le paint, et lance le thread de repaint
    public CarteView(ListeJardiniers jardiniers) {
        // garder la liste des jardiniers
        this.lj = jardiniers;

        // Chargement de l'image
        try {
            this.jardinierImage = new ImageIcon("jardinier.png").getImage();
        } catch (Exception e) {
            e.printStackTrace();
            // Gestion d'erreur : ne pas planter l'application si l'image ne peut pas être chargée
        }

        // à la fin on lance le thread
        (new Redessine(this)).start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Jardinier jardinier : lj.getJardiniers()) {
            int jardinierX = jardinier.getX();
            int jardinierY = jardinier.getY();

            g.setColor(new Color(173, 216, 230, 150));
            ((Graphics2D) g).setStroke(new BasicStroke(3.0f));
            g.fillOval(jardinierX - RAYON, jardinierY - RAYON, 2 * RAYON, 2 * RAYON);

            g.setColor(new Color(0, 0, 255));
            g.drawOval(jardinierX - RAYON, jardinierY - RAYON, 2 * RAYON, 2 * RAYON);

            int imageX = jardinierX - jardinierImage.getWidth(this) / 2;
            int imageY = jardinierY - jardinierImage.getHeight(this) / 2;
            g.drawImage(jardinierImage, imageX, imageY, this);



            Graphics2D g2d = (Graphics2D) g;

            // Définissez la police en gras et 2x plus grande
            Font font = new Font("Arial", Font.BOLD, 16);
            g2d.setFont(font);

            // Définissez la couleur du texte en noir
            g2d.setColor(Color.BLACK);

            // Dessinez le nom
            g2d.drawString(jardinier.getId(), jardinierX - RAYON / 2, jardinierY - RAYON + 35);

        }
    }
 */
}
