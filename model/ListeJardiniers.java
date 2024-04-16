package model;

import vue.Boutton;

import java.util.ArrayList;

/** Cette classe contient la liste des jardiniers et le jardinier sélectionné actuellement */
public class ListeJardiniers {

    /* la liste des jardiniers */
    private ArrayList<Jardinier> jardiniers = new ArrayList<Jardinier>();
    /* le jardinier courant (au début: null) */
    private Jardinier courant = null; // pour l'instant c'est géré au niveau du jardinier, à voir si cela reste comme ça ...

    private Boutton boutton;
    /** Le constructeur par défaut pour cette version de test construit une liste avec 2 jardiniers */
    public ListeJardiniers(Boutton boutton) {
        this.boutton = boutton;
        jardiniers.add(new Jardinier(100, 300, "Rick", boutton));
        jardiniers.add(new Jardinier(500, 100, "Daryl", boutton));
    }

    /** Il faut un getter sur la liste des jardiniers */
    public ArrayList<Jardinier> getJardiniers() {
        return jardiniers;
    }

    /** Il faut un getter sur le jardinier courant */
    public Jardinier getSelected() {
        return courant;
    }

    /** Il faut un setter sur le jardinier courant */
    public void setSelected(Jardinier j) {
        courant = j;
    }
}
