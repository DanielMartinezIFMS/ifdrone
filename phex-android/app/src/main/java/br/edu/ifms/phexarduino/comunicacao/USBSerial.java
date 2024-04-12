package br.edu.ifms.phexarduino.comunicacao;

/*
sinalizacao - airplane-mode off  (comunicação por radio foi ativada)
 */

import br.edu.ifms.phexarduino.Controller;

public class USBSerial {
    public boolean conectado = false;
    public boolean bidirecional = false;
    private Controller controller;

    public USBSerial(Controller controller) {

        this.controller = controller;
    }

    public void conectar() {
        if(conectado)
            desconectar();
        conexaoSerial();
    }

    private void conexaoSerial() {

    }

    private void desconectar() {

    }

    public void testarComunicacao() {
    }

    public void registrar(String canal, IComandoSerial comando) {
    }

    public void enviar(String tipo, String mensagem) {

    }

    public void receber(String tipo, String mensagem) {
        /*
        {cc}{num}[,{num}...];
            cc =
                su|de|av|re     subir, descer, avançar, retroceder
                va|vr|vs|vd     velocidade de avanço, retrocesso, subida e descida,
                pl|pg           pouso livre, pouso guiado
                gr              girar
                bs              retornar a base
                li|de           ligar e desligar

            num = 999999.9999999
        ex:
            su2.0;   subir a 2 metros de altura (altura != altitude)

         */
        if(tipo.equals("altitude")){
            String[] args = mensagem.split(";");
            double altitude = Double.parseDouble(args[0]);
            double pressao = Double.parseDouble(args[1]);
            controller.atualizar( (Controller ctrl)->{
                controller.altitude = altitude;
                controller.pressao = pressao;
            });
        }
    }


    public boolean barometroExterno() {
        return false;
    }

    public Boolean conectarLora() {
        return false;
    }

    public void atualizarRotores() {
        enviar("r1",controller.r1.toString());
        enviar("r2",controller.r2.toString());
        enviar("r3",controller.r3.toString());
        enviar("r4",controller.r4.toString());
        enviar("r5",controller.r5.toString());
        enviar("r6",controller.r6.toString());
        enviar("rotor","atualizar");
    }
}
