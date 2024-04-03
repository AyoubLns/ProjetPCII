package controller;

import model.BouttonDeplacer;
import model.BouttonRester;
import vue.Boutton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReactionClic {
    private Boutton boutton;

    public ReactionClic(Boutton b) {
        /*
        --------------------------Bouton--------------------------
        */
        this.boutton = b;

        boutton.getBtnDeplacer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new BouttonDeplacer(boutton)).start();
            }
        });

        boutton.getBtnRester().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                (new BouttonRester(boutton)).start();
            }
        });


    }
}
