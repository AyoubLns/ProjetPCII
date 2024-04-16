package vue;

import javax.swing.*;
import java.awt.*;

public class Boutton extends JPanel {
    private JButton btnPlanter;
    private JButton btnRecolter;
    private boolean boolPlanter = false;
    private boolean boolRecolter = false;
    public static final int width = 110, heigth = 40;

    public Boutton() {
        setLayout(new GridLayout(2, 1));

        btnPlanter = new JButton("Planter");
        btnRecolter = new JButton("Récolter");

        btnPlanter.setBounds(1165, 600, width, heigth);
        this.add(btnPlanter);
        this.add(btnRecolter);
    }

    // Ajoutez des getters pour les boutons

    public JButton getBtnPlanter() {
        return btnPlanter;
    }
    public void removeBtnPlanter(){
        btnPlanter.setBounds(2000, 0, width+10, heigth);
    }


    public JButton getBtnRecolter() {
        return btnRecolter;
    }
    public void removeBtnRecolter(){
        btnRecolter.setBounds(2000, 0, width+10, heigth);
    }
    public void replaceBtnRecolter(){
        btnRecolter.setBounds(1290, 600, width, heigth);
    }

    public boolean isBtnPlanterClicked() {
        return boolPlanter;
    }
    public void setBtnPlanterClicked() {
        this.boolPlanter = true;
    }

}
