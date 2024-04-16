package model;

import java.util.ArrayList;

/**
 * Cette classe contient la liste des fleurs et la fleur sélectionnée actuellement.
 */
public class ListeFleurs {

    /* La liste des fleurs */
    private ArrayList<Fleur> fleurs = new ArrayList<Fleur>();

    /* La fleur courante (au début: null) */
    private Fleur courante = null;
    private Fleur fleur;
    private Fleur fleur1;
    private Fleur fleur2;
    private Fleur fleur3;

    /**
     * Le constructeur par défaut pour cette version de test construit une liste avec quelques fleurs.
     */
    public ListeFleurs() {
        // Créez les fleurs sans utiliser getValetat() dans le constructeur
        fleur = new Fleur("Tulipe", 50, 75, 0, 1000);
        fleur1 = new Fleur("Rose", 150, 115, 0, 2000);
        fleur2 = new Fleur("Lys", 200, 200, 0, 2000);
        fleur3 = new Fleur("Orchidée", 300, 300, 0, 1000);

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
}
