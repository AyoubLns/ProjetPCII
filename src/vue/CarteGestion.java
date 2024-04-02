package vue;

import controller.ReactionClic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarteGestion extends JPanel {
    private int width = 240, height = 600;
    private Boutton boutton;

    public CarteGestion(Boutton boutton) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.GRAY);

        this.boutton = boutton;

        new ReactionClic(boutton);

        this.add(boutton.getBtnDeplacer());
        this.add(boutton.getBtnPlanter());
        this.add(boutton.getBtnRecolter());
        this.add(boutton.getBtnRester());
    }

}
