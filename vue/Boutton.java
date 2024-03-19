package vue;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Boutton extends JPanel {
    private JButton btnDeplacer;
    private JButton btnPlanter;
    private JButton btnRecolter;
    private JButton btnRester;
    private int width = 110, heigth = 20;

    public Boutton() {
        setLayout(new GridLayout(2, 1));

        btnDeplacer = new JButton("Se déplacer");
        btnPlanter = new JButton("Planter");
        btnRecolter = new JButton("Récolter");
        btnRester = new JButton("S'arrêter");

        btnDeplacer.setBounds(630, 250, width+10, heigth);
        this.add(btnDeplacer);
        btnPlanter.setBounds(575, 270, width, heigth);
        this.add(btnPlanter);
        this.add(btnRecolter);
        this.add(btnRester);
    }

    // Ajoutez des getters pour les boutons
    public JButton getBtnDeplacer() {
        return btnDeplacer;
    }
    public void removeBtnDeplacer(){
        btnDeplacer.setBounds(810, 0, width+10, heigth);
    }
    public void replaceBtnDeplacer(){
        btnDeplacer.setBounds(630, 250, width+10, heigth);
    }

    public JButton getBtnPlanter() {
        return btnPlanter;
    }
    public void removeBtnPlanter(){
        btnPlanter.setBounds(810, 0, width+10, heigth);
    }
    public void replaceBtnPlanter(){
        btnPlanter.setBounds(575, 270, width, heigth);
    }

    public JButton getBtnRecolter() {
        return btnRecolter;
    }
    public void removeBtnRecolter(){
        btnRecolter.setBounds(810, 0, width+10, heigth);
    }
    public void replaceBtnRecolter(){
        btnRecolter.setBounds(685, 270, width, heigth);
    }

    public JButton getBtnRester() {
        return btnRester;
    }
    public void removeBtnRester(){
        btnRester.setBounds(810, 0, width+10, heigth);
    }
    public void replaceBtnRester(){
        btnRester.setBounds(635, 290, width, heigth);
    }

}
