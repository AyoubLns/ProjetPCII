package model;

/** La classe Jardinier : un jardinier est caractérisé par sa position x,y, par un identifiant (un nom).
 * On note aussi si le jardinier est le jardinier courant dans la sélection. (peut-être pas utile à la fin, on verra)
 * Les jardiniers ont un thread de déplacement qui les emène vers une cible dès qu'elle change
 */
public class Jardinier {

    /** Cette constante définit la vitesse de déplacement des jardiniers */
    public static final int VITESSE = 100;

    /* Les attributs caractéristiques */
    private int x;
    private int y;
    private String id;

    /* la cible */
    private int cible_x;
    private int cible_y;

    /* pour savoir si j'ai été sélectionné */
    private boolean aEteClique;

    /** Le constructeur par défaut */
    public Jardinier(int x, int y, String id) {
        this.x = x;
        this.y = y;
        this.cible_x = x;
        this.cible_y = y;
        this.id = id;
        this.aEteClique = false;

        // on lance le thread de déplacement
        (new DeplacementJardinier(this)).start();
    }


    /** Le getter sur la position X, qui sert à la classe CarteView */
    public int getX() {
        return x;
    }

    /** Le getter sur la position Y, qui sert à la classe CarteView */
    public int getY() {
        return y;
    }

    /** Le getter sur le nom du jardinier, qui sert à la classe CarteView */
    public String getId() {
        return id;
    }

    /** Le setter sur la sélection de jardinier, utilisée par le contrôleur UnitControl lorsqu'on clic sur un jardinier */
    public void setSelected(boolean selected) {
        this.aEteClique = selected;
    }

    /** Le getter sur la sélection, utilisée par le contrôleur UnitControl pour savoir si le jardinier était déjà sélectionné */
    public boolean isSelected() {
        return aEteClique;
    }

    /** Le setter sur la cible, utilisé par UnitControl */
    public void setCible(int x, int y) {
        this.cible_x = x;
        this.cible_y = y;
    }

    /** Cette méthode calcule le déplacement à effectuer pour atteindre la cible (si et seulement si ce n'est pas
     * déjà atteint) */
    public void deplacer() {
        // on vérifie s'il faut se déplacer
        if (x != cible_x || y != cible_y) {
            // on calcule l'écart à la cible
            int deltaX = cible_x - x;
            int deltaY = cible_y - y;
            double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
            // il faut une constante de PAS
            int PAS = VITESSE; // Utilisation de la constante de vitesse définie dans la classe

            if (distance > PAS) { // Si la distance à parcourir est supérieure au pas
                // Calcul des nouvelles coordonnées en avançant vers la cible
                double ratio = PAS / distance;
                int newX = x + (int) (deltaX * ratio);
                int newY = y + (int) (deltaY * ratio);

                // Mise à jour des coordonnées du jardinier
                x = newX;
                y = newY;
            } else { // Si la distance est inférieure ou égale au pas, on va directement à la cible
                x = cible_x;
                y = cible_y;
            }
        }
    }

}


