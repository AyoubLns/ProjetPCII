package vue;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/** Cette classe définit le panel principal dans lequel on dessine les jardiniers */
public class CarteView extends JPanel {
    public static final Font FONT_JARD = new Font("Arial", Font.BOLD, 16);

    public static final int width = 1100, height = 800;

    /** La constante qui définit le rayon du cercle autour des jardiniers */
    public static final int RAYON = 57;

    /** La liste des jardiniers */
    private final ListeJardiniers lj;
    /** L'image pour dessiner les jardiniers */
    private Image jardinierImage;

    private Image imageTerre, imageJeune,
            imageTulipe, imageRose, imageLys, imageOrchidee,
            imagePourrie, coeurImage, image;
    private final Boutton boutton;
    private final ListeFleurs listeFleurs;
    private final Image backgroundImage;
    private int score = 0;
    private final RessourceVue ressourceVue;

    /** Le constructeur : charge l'image des jardiniers, note la liste pour le paint, et lance le thread de repaint */
    public CarteView(ListeJardiniers jardiniers, Boutton boutton, RessourceVue ressourceVue){
        this.setPreferredSize(new Dimension(width, height));

        this.backgroundImage = new ImageIcon("images/background.png").getImage();

        // garder la liste des jardiniers
        this.lj = jardiniers;

        this.boutton = boutton;

        this.ressourceVue = ressourceVue;

        listeFleurs = new ListeFleurs();

        // Chargement des images de fleurs
        try {
            this.jardinierImage = new ImageIcon("images/jardinier2.png").getImage();
            jardinierImage = jardinierImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

            this.imageTerre = new ImageIcon("images/terre.png").getImage();
            imageTerre = imageTerre.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

            this.imageJeune = new ImageIcon("images/Bourgeonn.png").getImage();
            imageJeune= imageJeune.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

            this.imageTulipe = new ImageIcon("images/tulipe.png").getImage();
            imageTulipe= imageTulipe.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

            this.imageRose = new ImageIcon("images/rose.png").getImage();
            imageRose= imageRose.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

            this.imageLys = new ImageIcon("images/lys.png").getImage();
            imageLys= imageLys.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

            this.imageOrchidee = new ImageIcon("images/orchidée.png").getImage();
            imageOrchidee= imageOrchidee.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

            this.imagePourrie = new ImageIcon("images/Fanée.png").getImage();
            imagePourrie= imagePourrie.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

            this.coeurImage = new ImageIcon("images/coeur.png").getImage();
            coeurImage = coeurImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

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


    private void updateScore(int etatFleur) {
        if (etatFleur == 0) { // Si la fleur est à l'état Terre
            score += 1;
        } else if (etatFleur == 1) { // Si la fleur est à l'état Jeune
            score += 5;
        } else if (etatFleur == 2) { // Si la fleur est à l'état Mûr
            score += 10;
        }
    }

    /** Cette classe définit le panel principal dans lequel on dessine les jardiniers */

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        super.paintComponent(g2d);

        g2d.drawImage(backgroundImage, 0, 0, width, height, this);

        int coeurs = listeFleurs.getFleurPourrie();

        for (int i = 0; i < coeurs; i++) {
            g2d.drawImage(coeurImage, (width-15) - (i + 1) * coeurImage.getWidth(this), 0, this);
        }

        if(!listeFleurs.fini()) {
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

            Font font = new Font("Arial", Font.PLAIN, 25);
            g2d.setFont(font);
            g2d.setColor(Color.WHITE);
            g2d.drawString("Score : " + score, 6, 22);

            ArrayList<Fleur> copieFleurs = new ArrayList<>(listeFleurs.getFleurs());
            for (Fleur fleur : copieFleurs) {
                int x = fleur.getX();
                int y = fleur.getY();

                EvolutionFleur evolutionFleur = new EvolutionFleur(fleur);

                listeFleurs.updateEstPourrie(fleur);

                //evolutionFleur est lancé lorsque l'on appuie sur le boutton planter
                if (boutton.isBtnPlanterClicked()) {
                    evolutionFleur.start();
                }

                boutton.getBtnRecolter().addActionListener(e -> {
                    for (Jardinier jardinier : lj.getJardiniers()) {
                        ArrayList<Fleur> copieFleurs1 = new ArrayList<>(listeFleurs.getFleurs());
                        for (Fleur fleur1 : copieFleurs1) {
                            double distance = Math.sqrt(Math.pow(jardinier.getX() - fleur1.getX(), 2) + Math.pow(jardinier.getY() - fleur1.getY(), 2));
                            if (distance <= 75) {
                                // Réinitialisation de la barre de progression appropriée dans RessourceControl
                                switch (fleur1.getNom()) {
                                    case "Tulipe":
                                        ressourceVue.getFlrJaune().recolte(); // Réinitialiser la barre de progression de la fleur jaune
                                        break;
                                    case "Rose":
                                        ressourceVue.getFlrRouge().recolte(); // Réinitialiser la barre de progression de la fleur rouge
                                        break;
                                    case "Lys":
                                        ressourceVue.getFlrVerte().recolte(); // Réinitialiser la barre de progression de la fleur verte
                                        break;
                                    case "Orchidée":
                                        ressourceVue.getFlrBleu().recolte(); // Réinitialiser la barre de progression de la fleur bleue
                                        break;
                                    default:
                                        break;
                                }

                                listeFleurs.nvlFleur(fleur1);

                                // Mise à jour du score en fonction de l'état de la fleur
                                updateScore(fleur1.getEtat());
                            }
                        }
                    }
                });

                if (fleur.getEtat() == 0) {
                    image = imageTerre;
                } else if (fleur.getEtat() == 1) {
                    image = imageJeune;
                } else if (fleur.getEtat() == 2) {
                    switch (fleur.getNom()) {
                        case "Tulipe" -> image = imageTulipe;
                        case "Rose" -> image = imageRose;
                        case "Lys" -> image = imageLys;
                        case "Orchidée" -> image = imageOrchidee;
                    }
                } else if (fleur.getEtat() == 3) {
                    image = imagePourrie;
                } else if (fleur.getEtat() == 4) {
                    // Réinitialisation de la barre de progression appropriée dans RessourceControl
                    switch (fleur.getNom()) {
                        case "Tulipe":
                            ressourceVue.getFlrJaune().recolte(); // Réinitialiser la barre de progression de la fleur jaune
                            break;
                        case "Rose":
                            ressourceVue.getFlrRouge().recolte(); // Réinitialiser la barre de progression de la fleur rouge
                            break;
                        case "Lys":
                            ressourceVue.getFlrVerte().recolte(); // Réinitialiser la barre de progression de la fleur verte
                            break;
                        case "Orchidée":
                            ressourceVue.getFlrBleu().recolte(); // Réinitialiser la barre de progression de la fleur bleue
                            break;
                        default:
                            break;
                    }

                    listeFleurs.nvlFleur(fleur);
                }

                if (image != null) {

                    // Calcul des coordonnées pour centrer l'image dans le cercle
                    int imageX = x - image.getWidth(this) / 2;
                    int imageY = y - image.getHeight(this) / 2;
                    g2d.drawImage(image, imageX, imageY, 50, 50, null);


                }
            }

            // Lorsque le boutton Planter est cliqué la partie débute
            if (boutton.isBtnPlanterClicked()) {
                boolean isNearFlower = false;
                // Vérifier si un jardinier est à proximité d'une fleur
                for (Jardinier jardinier : lj.getJardiniers()) {
                    for (Fleur fleur : listeFleurs.getFleurs()) {
                        double distance = Math.sqrt(Math.pow(jardinier.getX() - fleur.getX(), 2) + Math.pow(jardinier.getY() - fleur.getY(), 2));
                        if (distance <= 75) {
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
        } else {
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Arial", Font.BOLD, 50));
            g2d.drawString("Vous avez perdu !", 300, 400);
            g2d.setFont(new Font("Arial", Font.BOLD, 30));
            g2d.drawString("Votre score était de : " + score, 300, 450);
        }
    }

    public ListeFleurs getListeFleurs() {
        return this.listeFleurs;
    }
}
