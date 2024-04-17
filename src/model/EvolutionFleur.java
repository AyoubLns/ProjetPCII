package model;

import javax.swing.*;

public class EvolutionFleur extends Thread{
    private Fleur fleur;
    private int DELAY = 1000;

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
