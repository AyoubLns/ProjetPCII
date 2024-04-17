package model;

import java.util.ArrayList;

/**
 * Cette classe contient la liste des fleurs et la fleur sélectionnée actuellement.
 */
public class ListeFleurs {

    /* La liste des fleurs */
    private final ArrayList<Fleur> fleurs = new ArrayList<>();

    private static final int vitesse = 2000;
    private int FleurPourrie = 5;

    /**
     * Le constructeur par défaut pour cette version de test construit une liste avec quelques fleurs.
     */
    public ListeFleurs() {
        // Créez les fleurs sans utiliser getValetat() dans le constructeur
        Fleur fleur = new Fleur("Tulipe", 50, 75, 0, vitesse - 1000);
        Fleur fleur1 = new Fleur("Rose", 150, 115, 0, vitesse);
        Fleur fleur2 = new Fleur("Lys", 200, 200, 0, vitesse);
        Fleur fleur3 = new Fleur("Orchidée", 300, 300, 0, vitesse - 1000);

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

    // Méthodes pour ajouter et supprimer des fleurs de la liste

    public void add(Fleur fleur) {
        fleurs.add(fleur);
    }

    public void remove(Fleur fleur) {
        fleurs.remove(fleur);
    }

    // Méthode pour créer une nouvelle fleur aléatoire et supprimer la fleur actuelle

    public void nvlFleur(Fleur fleur) {
        switch (fleur.getNom()) {
            case "Tulipe" -> this.add(new Fleur("Tulipe", fleur.getRandomX(), fleur.getRandomY(), 0, vitesse - 1000));
            case "Rose" -> this.add(new Fleur("Rose", fleur.getRandomX(), fleur.getRandomY(), 0, vitesse));
            case "Orchidée" -> this.add(new Fleur("Orchidée", fleur.getRandomX(), fleur.getRandomY(), 0, vitesse - 1000));
            case "Lys" -> this.add(new Fleur("Lys", fleur.getRandomX(), fleur.getRandomY(), 0, vitesse));
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
