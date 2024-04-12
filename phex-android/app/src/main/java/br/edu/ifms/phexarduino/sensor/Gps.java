package br.edu.ifms.phexarduino.sensor;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import br.edu.ifms.phexarduino.Controller;
import br.edu.ifms.phexarduino.MainActivity;

public class Gps implements LocationListener {
    private Controller controller;

    public Gps(Controller controller, MainActivity act) {
        this.controller = controller;

        LocationManager locationManager = (LocationManager)
                act.getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(act, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(act, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 500, 0.5f, this);

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
            controller.atualizar((Controller controller)->{
                controller.latitude = location.getLatitude();
                controller.longitude = location.getLongitude();
                if(!controller.altitudePorGPS) {
                    controller.altitude = location.getAltitude();
                }
            });
    }

    public boolean disponivel() {
        return false;
    }

    public double latitudeCorrente() {
        return 0;
    }

    public double longitudeCorrente() {
        return 0;
    }
}
