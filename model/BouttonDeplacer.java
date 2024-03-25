package model;
import vue.*;

public class BouttonDeplacer extends Thread {
    private Boutton boutton;
    private static final int DELAY = 50;

    public BouttonDeplacer(Boutton b){
        this.boutton = b;
    }

    @Override
    public void run(){
        int n = 0;
        System.out.println("Action : Se déplacer");
        while(n < DELAY && BouttonRester.getInter()) {
            boutton.removeBtnDeplacer();
            boutton.replaceBtnRester();
            boutton.removeBtnPlanter();
            boutton.removeBtnRecolter();
            n++;
            try {
                Thread.sleep(DELAY);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        boutton.replaceBtnDeplacer();
        boutton.removeBtnRester();
    }
}
