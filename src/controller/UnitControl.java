package controller;

import model.Jardinier;
import model.ListeJardiniers;
import vue.CarteView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UnitControl extends MouseAdapter {
    private final ListeJardiniers liste_jardiniers;
    /**
     * Le contrôleur prend en paramèter la liste des jardiniers
     */
    public UnitControl(ListeJardiniers jardiniers) {
        this.liste_jardiniers = jardiniers;
    }

    /**
     * La réaction au clic
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        // bool pour savoir si je touche un jardinier
        boolean found = false;

        // on parcourt la liste des jardiniers
        for (Jardinier jardinier : liste_jardiniers.getJardiniers()) {
            int jardinierX = jardinier.getX();
            int jardinierY = jardinier.getY();
            // on calcule la distance entre le point de clic et les coordonnées du jardinier
            double distance = Math.sqrt(Math.pow(mouseX - jardinierX, 2) + Math.pow(mouseY - jardinierY, 2));
            // pareil : double distance = Point.distance(mouseX,mouseY,jardinierX,jardinierY);

            // si je suis dans la zone d'action du jardinier
            if (distance <= CarteView.RAYON) {

                Jardinier selectedJardinier = liste_jardiniers.getSelected();

                // Si aucun jardinier n'est sélectionné ou si le jardinier sélectionné est différent du jardinier cliqué
                if (selectedJardinier == null || !selectedJardinier.equals(jardinier)) {
                    // Désélectionner le jardinier précédemment sélectionné
                    if (selectedJardinier != null) {
                        selectedJardinier.setSelected(false);
                    }
                    // Sélectionner le nouveau jardinier
                    jardinier.setSelected(true);
                    liste_jardiniers.setSelected(jardinier);
                    System.out.println("Jardinier cliqué : " + jardinier.getId());
                }
                // Si le jardinier cliqué est déjà sélectionné, on ne fait rien de plus

                found = true;
                break;
            }
        }

        // si je n'ai pas cliqué sur un jardinier...
        if (!found) {
            Jardinier j = liste_jardiniers.getSelected();
            if (j != null)
                j.setCible(mouseX, mouseY);
        }
    }


}