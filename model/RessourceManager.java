package model;

import controller.*;
import vue.*;

import javax.swing.*;

// Gestionnaire de ressources qui met à jour la ressource à intervalles réguliers
public class RessourceManager extends Thread {
    private RessourcePanel ressourcePanel;
    private Ressource ressource;

    public RessourceManager(RessourcePanel ressourcePanel, Ressource ressource) {
        this.ressourcePanel = ressourcePanel;
        this.ressource = ressource;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            try {
                Thread.sleep(ressource.getvitesse()); // Utilise la vitesse de la ressource
                SwingUtilities.invokeLater(ressourcePanel::updateressourceetat);
            } catch (InterruptedException e) {
                interrupt(); // Assurez-vous de réinterrompre le thread pour propager l'interruption
            }
        }
    }
}