package model;
import vue.*;

public class BouttonRecolter extends Thread {
    private Boutton boutton;
    private static final int DELAY = 2;

    public BouttonRecolter(Boutton b){
        this.boutton = b;
    }

    @Override
    public void run(){
        int n = 0;
        System.out.println("Action : Récolter une plante");
        while(n < DELAY) {
            boutton.removeBtnRecolter();
            n++;
            try {
                Thread.sleep(DELAY);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
