package model;

public class Fleur {
    private final String nom;
    private int etat;
    private int etatProgress; // État de la fleur pour la progression
    private final int x; // Position X de la fleur sur la CarteVue
    private final int y; // Position Y de la fleur sur la CarteVue
    private final int vitesse; // Vitesse de progression de l'état de la fleur

    // Constructeur sans RessourceControl
    public Fleur(String nom, int x, int y, int etat, int vitesse) {
        this.nom = nom;
        this.x = x;
        this.y = y;
        this.etat = etat;
        this.vitesse = vitesse;
    }

    // Méthode pour faire évoluer l'état de la fleur
    public void evoluer() {
        // Logique pour changer l'état de la fleur
        // Par exemple, incrémenter l'état jusqu'à un certain point
        if (this.etat <= 960) {
            this.etat++;
        } else {
            this.etat = 0;
        }
    }

    // Méthode pour obtenir la vitesse de la fleur
    public int getVitesse() {
        return vitesse;
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

    // Méthode pour obtenir la position X de la fleur
    public int getX() {
        return x;
    }

    // Méthode pour obtenir la position Y de la fleur
    public int getY() {
        return y;
    }

    // Méthode pour obtenir une coordonnée aléatoire pour X entre 30 et 1000
    public int getRandomX() {
        return (int) (Math.random() * 970) + 30;
    }

    // Méthode pour obtenir une coordonnée aléatoire pour Y entre 20 et 750
    public int getRandomY() { return (int) (Math.random() * 730) + 20; }

}
