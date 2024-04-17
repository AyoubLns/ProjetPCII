package model;
import vue.Boutton;

/** Ce thread gère le déplacement des jardiniers */
public class DeplacementJardinier extends Thread {

    /* le jardinier sur lequel on travaille */
    private Jardinier jard;
    private Boutton boutton;

    /** Le constructeur par défaut */
    public DeplacementJardinier(Jardinier j, Boutton boutton) {
        jard = j;
        this.boutton = boutton;
    }

    /** La méthode run appelle déplacer dans la classe Jardinier */
    @Override
    public void run() {
        while (true) {
            jard.deplacer();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



