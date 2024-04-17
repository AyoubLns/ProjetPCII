package model;

import controller.RessourceControl;
import vue.RessourceVue;

import javax.swing.*;

// Gestionnaire de ressources qui met à jour la ressource à intervalles réguliers
public class RessourceManager extends Thread {
    private RessourceControl ressourceControl;
    private RessourceVue ressourceVue;
    private Fleur fleur;

    public RessourceManager(RessourceControl ressourceControl, RessourceVue ressourceVue, Fleur fleurs) {
        this.ressourceControl = ressourceControl;
        this.ressourceVue = ressourceVue;
        this.fleur = fleurs;
    }

    /**
     * Exécute la logique de mise à jour de la ressource à intervalles réguliers.
     */
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