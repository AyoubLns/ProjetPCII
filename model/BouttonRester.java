package model;
import vue.*;

public class BouttonRester extends Thread {
    private Boutton boutton;
    private static final int DELAY = 50;
    private static boolean interrupted = true;

    public BouttonRester(Boutton b){
        this.boutton = b;
    }

    public static boolean getInter(){
        return interrupted;
    }
    @Override
    public void run(){
        int n = 0;
        System.out.println("Action : Rester sur place");
        while (n < DELAY && interrupted) {
            interrupted = false;
            boutton.removeBtnRester();
            n++;
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        interrupted = true;
    }
}
