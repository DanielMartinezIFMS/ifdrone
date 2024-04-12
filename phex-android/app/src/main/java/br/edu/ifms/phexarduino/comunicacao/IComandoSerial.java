package br.edu.ifms.phexarduino.comunicacao;

public interface IComandoSerial {

    void receber(String data);
    String enviar();
}
