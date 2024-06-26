package vue;

import controller.RessourceControl;

import javax.swing.*;
public class RessourceVue extends JPanel {
    private int etat; // 0 = jeune, 1 = mûr, 2 = pourri
    private int vitesse = 1000; // vitesse de la barre de progression
    private RessourceControl btnRessource1;
    private RessourceControl btnRessource2;
    private RessourceControl btnRessource3;
    private RessourceControl btnRessource4;
    RessourceVue flrBleu;
    RessourceVue flrJaune;
    RessourceVue flrVerte;
    RessourceVue flrRouge;
    public static final int width = 150, heigth = 50;

    public RessourceVue(Boutton boutton){
        flrBleu = new RessourceVue(0, vitesse); // Etat initial 0, valeur initiale 5
        flrJaune = new RessourceVue(0, vitesse + 500); // Etat initial 1, valeur initiale 10
        flrVerte = new RessourceVue(0, vitesse + 500); // Etat initial 3, valeur initiale 15
        flrRouge = new RessourceVue(0, vitesse); // Etat initial 5, valeur initiale 20

        btnRessource1 = new RessourceControl(flrBleu, "Vie de la fleur bleu  ", boutton);
        btnRessource2 = new RessourceControl(flrJaune, "Vie de la fleur jaune ", boutton);
        btnRessource3 = new RessourceControl(flrVerte, "Vie de la fleur verte ", boutton);
        btnRessource4 = new RessourceControl(flrRouge, "Vie de la fleur rouge ", boutton);

        btnRessource1.setBounts(1210, 10, width, heigth);
        this.add(btnRessource1);

        btnRessource2.setBounts(1210, 65, width, heigth);
        this.add(btnRessource2);

        btnRessource3.setBounts(1210, 120, width, heigth);
        this.add(btnRessource3);

        btnRessource4.setBounts(1210, 175, width, heigth);
        this.add(btnRessource4);
    }

    public RessourceVue(int etatInitial, int vitesse) {
        this.etat = etatInitial;
        this.vitesse = vitesse;
    }
    public void updateetat() {
        if (etat < 10) {
            etat++;
        }
    }

    public void recolte() {
        etat = 0; // Reset l'état après la récolte
    }

    public int getetat() {
        return etat;
    }

    public int getvitesse() {
        return this.vitesse;
    }

    public RessourceControl getBtnRessource1() {
        return btnRessource1;
    }
    public RessourceControl getBtnRessource2() {
        return btnRessource2;
    }
    public RessourceControl getBtnRessource3() {
        return btnRessource3;
    }
    public RessourceControl getBtnRessource4() {
        return btnRessource4;
    }

    public RessourceVue getFlrBleu() {
        return flrBleu;
    }
    public RessourceVue getFlrJaune() {
        return flrJaune;
    }
    public RessourceVue getFlrVerte() {
        return flrVerte;
    }
    public RessourceVue getFlrRouge() {
        return flrRouge;
    }
}
