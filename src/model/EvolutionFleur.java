package model;

public class EvolutionFleur extends Thread{
    private final Fleur fleur;
    private static final int DELAY = 1000;

    public EvolutionFleur(Fleur fleur){
        this.fleur = fleur;
    }

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
