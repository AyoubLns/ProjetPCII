package vue;

/** La classe Redessine a juste pour objectif d'appeler repaint toutes
 * les 50 ms sur la classe CarteView.
 */
public class Redessine extends Thread {

    private CarteView vue ;

    /** constructeur */
    public Redessine(CarteView view) {
        this.vue = view;
    }

    /** L'opération de redessin */
    @Override
    public void run() {
        while (true) {
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