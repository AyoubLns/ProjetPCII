package model;

import controller.RessourceControl;
import vue.Boutton;

/**
 * Classe Fleur qui gere les fleurs de la carte et leur etat d'evolution
 * * Modèle pour les fleurs
 *
 */

public class Fleur {
    private String nom; // Nom de la fleur
    private int etat; // État de la fleur pour l'évolution
    private int etatProgress; // État de la fleur pour la progression
    private int x; // Position X de la fleur sur la CarteVue
    private int y; // Position Y de la fleur sur la CarteVue
    private int vitesse; // Vitesse de progression de l'état de la fleur


    // Constructeur pour les instanciations avec paramètres de la classe Fleur

    public Fleur(String nom, int x, int y, int etat, int vitesse) {
        this.nom = nom;
        this.x = x;
        this.y = y;
        this.etat = etat;
        this.vitesse = vitesse;
    }


    // Méthode pour faire évoluer l'état de la fleur
    public Runnable evoluer() {
        // Logique pour changer l'état de la fleur
        // Par exemple, incrémenter l'état jusqu'à un certain point
        if (this.etat <= 960) {
            this.etat++;
        } else {
            this.etat = 0;
        }
        return null;
    }

    // Méthode pour obtenir la vitesse de la fleur
    public int getVitesse() {
        return vitesse;
    }

    // Méthode pour définir la vitesse de la fleur
    public int setVitesse(int vitesse) {
        return this.vitesse -= vitesse;
    }

    // Méthode pour obtenir le nom de la fleur
    public String getNom() {
        return nom;
    }

    // Méthode pour obtenir l'état de la fleur
    public int getEtat() {
        // Logique pour déterminer l'état de la fleur pour la barre de progression
        if (this.etat < 70) {
            etatProgress = 0;
        } else if (this.etat > 70 && this.etat < 200) {
            etatProgress = 1;
        } else if (this.etat > 200 && this.etat < 850) {
            etatProgress = 2;
        } else if (this.etat > 850 && this.etat < 950) {
            etatProgress = 3;
        } else if (this.etat > 950) {
            etatProgress = 4;
        }
        return this.etatProgress;
    }

    // Méthode pour définir l'état de la fleur
    public void setEtat(int etat) {
        this.etat = etat;
    }

    // Méthode pour obtenir la position X de la fleur
    public int getX() {
        return x;
    }

    // Méthode pour obtenir la position Y de la fleur
    public int getY() {
        return y;
    }

    // Méthode pour obtenir une coordonnée aléatoire pour X entre 0 et 1000
    public int getRandomX() {
        return (int) (Math.random() * 1000);
    }

    // Méthode pour obtenir une coordonnée aléatoire pour Y entre 0 et 750
    public int getRandomY() {
        return (int) (Math.random() * 750);
    }

}
