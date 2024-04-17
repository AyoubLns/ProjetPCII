package model;


/**
 * Classe EvolutionFleur qui hérite de Thread  qui gére l'évolution d'une fleur
 * Thread qui permet de faire évoluer une fleur
 *
 */
public class EvolutionFleur extends Thread{
    private Fleur fleur; // Fleur à faire évoluer
    private int DELAY = 1000; // Délai entre chaque évolution

    public EvolutionFleur(Fleur fleur){
        this.fleur = fleur;
    }

    /**
     * Méthode qui permet de faire évoluer une fleur
     */

    @Override
    public void run() {
        int n = 0;
        while (n < DELAY) {
            try {
                Thread.sleep(fleur.getVitesse());
                fleur.evoluer();
                n++;
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}
