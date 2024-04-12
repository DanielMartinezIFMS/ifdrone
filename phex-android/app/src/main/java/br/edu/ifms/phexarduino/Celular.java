package br.edu.ifms.phexarduino;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;

/**
 * @noinspection deprecation
 */
public class Celular {


    private Controller ctrl;

    public Celular() {
    }

    public Celular(Controller controller) {
        this.ctrl = controller;
    }

    public void configurar() {
        this.setModoAviao();
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    private void setModoAviao() {

        IntentFilter intentFilter = new
                IntentFilter("android.intent.action.AIRPLANE_MODE_CHANGED");

        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                boolean isAirplaneMode = isAirplaneModeOn(context);
                ctrl.sinalize("airplane-mode off");

            }
        };

        ctrl.getContext().registerReceiver(receiver, intentFilter);



        Settings.Global.putInt(
                ctrl.getContext().getContentResolver(),
                Settings.System.AIRPLANE_MODE_ON, 0);
    }

    private boolean isAirplaneModeOn(Context context) {

        return Settings.Global.getInt(context.getContentResolver(),
                Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }


    public void alertaAmarelo() {

    }

    public void alertaVermelho() {

    }

    public void alertaVerde() {

    }

    public void alertaAzul() {

    }

    public void erro(String message) {

    }
}

