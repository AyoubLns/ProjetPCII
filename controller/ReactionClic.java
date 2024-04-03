package controller;

import model.*;
import vue.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
