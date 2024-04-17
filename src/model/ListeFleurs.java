package model;

import java.util.ArrayList;

/**
 * Cette classe contient la liste des fleurs et la fleur sélectionnée actuellement.
 */
public class ListeFleurs {

    /* La liste des fleurs */
    private ArrayList<Fleur> fleurs = new ArrayList<Fleur>(); // Liste des fleurs

    /* La fleur courante (au début: null) */
    private Fleur courante = null;
    private Fleur fleur;
    private Fleur fleur1;
    private Fleur fleur2;
    private Fleur fleur3;
    private static final int vitesse = 2000; // Vitesse de progression de l'état de la fleur
    private int FleurPourrie = 5;

    /**
     * Le constructeur par défaut pour cette version de test construit une liste avec quelques fleurs.
     */
    public ListeFleurs() {
        // Création des fleurs avec des noms, des positions et des vitesses différentes
        fleur = new Fleur("Tulipe", 50, 75, 0, vitesse - 1000);
        fleur1 = new Fleur("Rose", 150, 115, 0, vitesse);
        fleur2 = new Fleur("Lys", 200, 200, 0, vitesse);
        fleur3 = new Fleur("Orchidée", 300, 300, 0, vitesse - 1000);

        // Ajouter les fleurs à la liste
        fleurs.add(fleur);
        fleurs.add(fleur1);
        fleurs.add(fleur2);
        fleurs.add(fleur3);
    }

    /**
     * Getter pour obtenir la liste des fleurs.
     */
    public ArrayList<Fleur> getFleurs() {
        return fleurs;
    }

    /**
     * Getter pour obtenir la fleur actuellement sélectionnée.
     */
    public Fleur getCourante() {
        return courante;
    }

    /**
     * Setter pour définir la fleur actuellement sélectionnée.
     */
    public void setCourante(Fleur fleur) {
        this.courante = fleur;
    }

    // Méthodes pour ajouter et supprimer des fleurs de la liste

    public void add(Fleur fleur) {
        fleurs.add(fleur);
    }

    public void remove(Fleur fleur) {
        fleurs.remove(fleur);
    }

    // Méthode pour créer une nouvelle fleur aléatoire et supprimer la fleur actuelle

    public void nvlFleur(Fleur fleur) {
        if (fleur.getNom() == "Tulipe") {
            this.add(new Fleur("Tulipe", fleur.getRandomX(), fleur.getRandomY(), 0, 1000));
        } else if (fleur.getNom() == "Rose") {
            this.add(new Fleur("Rose", fleur.getRandomX(), fleur.getRandomY(), 0, 2000));
        } else if (fleur.getNom() == "Orchidée") {
            this.add(new Fleur("Orchidée", fleur.getRandomX(), fleur.getRandomY(), 0, 1000));
        } else if (fleur.getNom() == "Lys") {
            this.add(new Fleur("Lys", fleur.getRandomX(), fleur.getRandomY(), 0, 2000));
        }
        this.remove(fleur);
    }

    // Mettez à jour cette méthode pour inclure la logique de détection de l'état "pourri"
    public void updateEstPourrie(Fleur fleur) {
        if (fleur.getEtat() == 4) {
            this.FleurPourrie--;
            System.out.println("Fleur pourrie : " + this.FleurPourrie);
        }
    }

    // Méthode pour obtenir le nombre de fleurs pourries

    public int getFleurPourrie(){
        return this.FleurPourrie;
    }

    // Méthode pour vérifier si toutes les fleurs sont pourries

    public boolean fini(){
        return this.FleurPourrie == 0;
    }
}
