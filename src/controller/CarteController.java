// CarteController.java
package controller;

import model.CarteModel;
import vue.CarteVue;

public class CarteController {
    private CarteModel carteModel;
    private CarteVue carteVue;

    public CarteController(CarteModel carteModel, CarteVue carteVue) {
        this.carteModel = carteModel;
        this.carteVue = carteVue;
    }

}
