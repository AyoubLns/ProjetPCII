package model;

import javax.swing.*;

public class EvolutionFleur extends Thread{
    private Fleur fleur;

    public EvolutionFleur(Fleur fleur){
        this.fleur = fleur;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            try {
                Thread.sleep(fleur.getVitesse());
                fleur.evoluer();
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}
