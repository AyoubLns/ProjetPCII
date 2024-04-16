package model;

import controller.RessourceControl;
import vue.Boutton;
//imoprt vue.RessourceVue;


public class Fleur {
    private String nom;
    private int etat;
    private int x; // Position X de la fleur sur la CarteVue
    private int y; // Position Y de la fleur sur la CarteVue
    private int vitesse; // vitesse de la barre de progression
    private RessourceControl ressourceControl;
    private vue.RessourceVue ressourceVue;
    private Boutton boutton;

    // Constructeur sans RessourceControl
    public Fleur(String nom, int x, int y, int etat, int vitesse) {
        this.nom = nom;
        this.x = x;
        this.y = y;
        this.etat = etat;
        this.vitesse = vitesse;
    }

    /* Constructeurs
    public Fleur(String nom, int x, int y, RessourceControl ressourceControl) {
        this.nom = nom;
        this.x = x;
        this.y = y;
        this.etat = 0; // état initial
        this.ressourceControl = ressourceControl;
    }
    */

    // Méthode pour faire évoluer l'état de la fleur
    public Runnable evoluer() {
        // Logique pour changer l'état de la fleur
        // Par exemple, incrémenter l'état jusqu'à un certain point
        if (this.etat <= 1000) {
            this.etat++;
        }
        return null;
    }

    public int getVitesse() {
        return vitesse;
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }
    public int getEtat() {
        return this.etat;
    }

    /*méthode pour renvoyer l'etat de la fleur en fonction de l'avancement de la barre de progression
    public int getEtatProgress() {
        if (ressourceControl != null) {
            return ressourceControl.getEtat();
        }
        return etat;

    }*/

    public void setEtat(int etat) {
        this.etat = etat;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    //fais une méthode pour attribuer des coordonnées aléatoires comprises entre 0 à 1500 pour x et 0 à 800 pour y
    public void setRandomPosition() {
        this.x = (int) (Math.random() * 1500);
        this.y = (int) (Math.random() * 800);
    }

}