package br.edu.ifms.phexarduino.sensor;

import br.edu.ifms.phexarduino.Controller;

public class Barometro {
    private Controller controller;

    public Barometro(Controller controller) {

        this.controller = controller;
    }

    public boolean disponivel() {
        return false;
    }

    public Double altitudeCorrente() {
        return 0d;
    }

    public Double pressaoCorrente() {
        return 0;
    }
}
