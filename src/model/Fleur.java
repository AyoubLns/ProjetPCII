package model;

import controller.RessourceControl;
import vue.Boutton;
//imoprt vue.RessourceVue;


public class Fleur {
    private String nom;
    private int etat; // Par exemple, 0 = jeune, 1 = mûr, 2 = pourri
    private int x; // Position X de la fleur sur la CarteVue
    private int y; // Position Y de la fleur sur la CarteVue
    private RessourceControl ressourceControl;
    private vue.RessourceVue ressourceVue;
    private Boutton boutton;

    // Constructeur sans RessourceControl
    public Fleur(String nom, int x, int y) {
        this.nom = nom;
        this.x = x;
        this.y = y;
        this.etat = 0; // état initial
        this.ressourceControl = null; // pas de RessourceControl fourni
    }

    // Constructeurs
    public Fleur(String nom, int x, int y, RessourceControl ressourceControl) {
        this.nom = nom;
        this.x = x;
        this.y = y;
        this.etat = 0; // état initial
        this.ressourceControl = ressourceControl;
    }
    public Fleur(String nom, int x, int y, int etat) {
        super();
        this.nom = nom;
        this.x = x;
        this.y = y;
        this.etat = etat;
    }



    // Getters et Setters
    public String getNom() {
        return nom;
    }
    public int getEtat() {
        return etat;
    }

    // méthode pour renvoyer l'etat de la fleur en fonction de l'avancement de la barre de progression
    public int getEtatProgress() {
        if (ressourceControl != null) {
            return ressourceControl.getEtat();
        }
        return etat;

    }



    public void setEtat(int etat) {
        this.etat = etat;

    }





    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Méthode pour faire évoluer l'état de la fleur
    public void evoluer() {
        // Logique pour changer l'état de la fleur
        // Par exemple, incrémenter l'état jusqu'à un certain point
        if (etat < 2) {
            etat++;
        }
    }
}