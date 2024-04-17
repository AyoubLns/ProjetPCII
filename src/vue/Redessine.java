package vue;

/** La classe Redessine a juste pour objectif d'appeler repaint toutes
 * les 50 ms sur la classe CarteView.
 */
public class Redessine extends Thread {

    private CarteView vue ;
    private int DELAY = 10;

    /** constructeur */
    public Redessine(CarteView view) {
        this.vue = view;
    }

    /** L'opération de redessin */
    @Override
    public void run() {
        int n = 0;
        while (true) {
            if (vue.getListeFleurs().fini()){
                if(n > DELAY) {
                    break;
                }
                n++;
            }
            vue.revalidate();
            vue.repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}