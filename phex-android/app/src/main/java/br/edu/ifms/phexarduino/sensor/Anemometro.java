package br.edu.ifms.phexarduino.sensor;

import br.edu.ifms.phexarduino.Controller;

public class Anemometro {
    private Controller controller;

    public Anemometro(Controller controller) {

        this.controller = controller;
    }

    public double anguloCorrente() {
        return 0;
    }

    public double velocidadeCorrente() {
        return 0;
    }
}
