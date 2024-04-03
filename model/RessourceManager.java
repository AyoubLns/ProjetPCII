package model;

import controller.*;
import vue.*;

import javax.swing.*;

// Gestionnaire de ressources qui met à jour la ressource à intervalles réguliers
public class RessourceManager extends Thread {
    private RessourceControl ressourceControl;
    private RessourceVue ressourceVue;

    public RessourceManager(RessourceControl ressourceControl, RessourceVue ressourceVue) {
        this.ressourceControl = ressourceControl;
        this.ressourceVue = ressourceVue;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            try {
                Thread.sleep(ressourceVue.getvitesse()); // Utilise la vitesse de la ressource
                SwingUtilities.invokeLater(ressourceControl::updateressourceetat);
            } catch (InterruptedException e) {
                interrupt(); // Assurez-vous de réinterrompre le thread pour propager l'interruption
            }
        }
    }
}