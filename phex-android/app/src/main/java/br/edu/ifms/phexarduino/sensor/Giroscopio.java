package br.edu.ifms.phexarduino.sensor;

import br.edu.ifms.phexarduino.Controller;

public class Giroscopio {
    private Controller controller;

    public Giroscopio(Controller controller) {

        this.controller = controller;
    }

    public Double xCorrent() {
        return 0d;
    }

    public Double yCorrent() {
        return 0d;
    }

    public Double zCorrent() {
        return 0d;
    }

    public boolean inclinado() {
        return false;
    }

    public void ajustarInclinacao() {

    }

    public boolean apontaParaNorte() {
        return false;
    }

    public void girar(double angulo) {

    }
}
