package model;

import vue.Boutton;

public class BouttonPlanter extends Thread {
    private Boutton boutton;
    private static final int DELAY = 50;

    public BouttonPlanter(Boutton b){
        this.boutton = b;
    }

    @Override
    public void run(){
        int n = 0;
        System.out.println("Action : Planter des graines");
        while(n < DELAY) {
            boutton.removeBtnPlanter();
            boutton.setBtnPlanterClicked();
            n++;
            try {
                Thread.sleep(DELAY);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
