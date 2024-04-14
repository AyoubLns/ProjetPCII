package vue;

import model.Fleur;
import model.Jardinier;
import model.ListeFleurs;
import model.ListeJardiniers;

import javax.swing.*;
import java.awt.*;

/** Cette classe définit le panel principal dans lequel on dessine les jardiniers */
public class CarteView extends JPanel {
    public static final Font FONT_JARD = new Font("Arial", Font.BOLD, 16);


    public static final int width = 1100, height = 800;

    /** La constante qui définit le rayon du cercle autour des jardiniers */
    public static final int RAYON = 57;

    /** La liste des jardiniers */
    private ListeJardiniers lj;
    /** L'image pour dessiner les jardiniers */
    private Image jardinierImage;

    private Image imageJeune, imageMure, imagePourrie, image;

    private Boutton boutton;

    private ListeFleurs listeFleurs;
    private Image backgroundImage;

    /** Le constructeur : charge l'image des jardiniers, note la liste pour le paint, et lance le thread de repaint */
    public CarteView(ListeJardiniers jardiniers, Boutton boutton){
        this.setPreferredSize(new Dimension(width, height));

        this.backgroundImage = new ImageIcon("images/background.png").getImage();

        listeFleurs = new ListeFleurs();

        // garder la liste des jardiniers
        this.lj = jardiniers;

        this.boutton = boutton;
        // Chargement des images de fleurs
        try {
            this.jardinierImage = new ImageIcon("images/jardinier.png").getImage();
            this.imageJeune = new ImageIcon("images/terre.png").getImage();
            imageJeune= imageJeune.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            this.imageMure = new ImageIcon("images/Fleur.png").getImage();
            imageMure= imageMure.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            this.imagePourrie = new ImageIcon("images/Fanée.png").getImage();
            imagePourrie= imagePourrie.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        } catch (Exception e) {
            e.printStackTrace();
            // Gestion d'erreur : ne pas planter l'application si l'image ne peut pas être chargée
        }

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

        g2d.drawImage(backgroundImage, 0, 0, width, height, this);

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
            g2d.setFont(FONT_JARD);

            // Définissez la couleur du texte en noir
            g2d.setColor(Color.BLACK);

            // Dessinez le nom
            g2d.drawString(jardinier.getId(), jardinierX - RAYON / 2, jardinierY - RAYON + 35);

        }
        for (Fleur fleur : listeFleurs.getFleurs()) {
            int x = fleur.getX();
            int y = fleur.getY();

//            if (fleur==listeFleurs.getFleurs().get(0)) {
//                System.out.println(fleur.getEtatProgress());
//            }

            // Sélection de l'image en fonction de l'état de la fleur
            switch (fleur.getEtatProgress()) {
                case 0 : image = imageJeune; break;
                case 1 : image = imageMure; break;
                case 2: image = imagePourrie; break;
                default: image = null;
            }


            if (image != null) {

                // Calcul des coordonnées pour centrer l'image dans le cercle
                int imageX = x - image.getWidth(this) / 2;
                int imageY = y - image.getHeight(this) / 2;
                g2d.drawImage(image, imageX, imageY, 50, 50, null);


            }
        }

        if (boutton.isBtnPlanterClicked()) {
            boolean isNearFlower = false;

            for (Jardinier jardinier : lj.getJardiniers()) {
                for (Fleur fleur : listeFleurs.getFleurs()) {
                    double distance = Math.sqrt(Math.pow(jardinier.getX() - fleur.getX(), 2) + Math.pow(jardinier.getY() - fleur.getY(), 2));
                    if (distance <= 75 && distance >= 0) {
                        isNearFlower = true;
                        break;
                    }
                }
                if (isNearFlower) {
                    break;
                }
            }

            if (isNearFlower) {
                boutton.replaceBtnRecolter();
            } else {
                boutton.removeBtnRecolter();
            }
        }


    }
}
