package br.edu.ifms.phexarduino.comunicacao;

import java.util.List;

import br.edu.ifms.phexarduino.Controller;

public abstract class ComandoSerial implements IComandoSerial {
    Controller ctrl = null;
    List<String> buffer = null;
    public ComandoSerial(Controller ctrl){
        this.ctrl=ctrl;
    }
}
