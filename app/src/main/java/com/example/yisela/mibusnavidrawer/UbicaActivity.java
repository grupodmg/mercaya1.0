package com.example.yisela.mibusnavidrawer;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class UbicaActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap mMap;
    private static final String TAG = "PlaceAutocompleteAd";
    public LatLng miubicacion;
    public LatLng midestino;
    public LatLng direccionorigen = null;
    public LatLng direcciondestino = null;
    double latorigen;
    double lngorigen;
    double latdestino;
    double lngdestino;
    private CountDownTimer realTimeTimer;
    double paradalat = 2.442161;
    double paradalng = -76.605682;
    LatLng parada = new LatLng(paradalat, paradalng);
    Marker d;
    Marker e;
    Marker f;
    Marker g;
    Marker h;
    Marker i;
    Marker j;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubica);
        int permissionCheck = ContextCompat.checkSelfPermission(UbicaActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        if (permissionCheck == PackageManager.PERMISSION_DENIED)
        {
        } else
            {
            ActivityCompat.requestPermissions(UbicaActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1);
            }
        LocationManager locationManager = (LocationManager) UbicaActivity.this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener()


        {
            @Override
            public void onLocationChanged(Location location)
            {
                latorigen = 2.441212;
                lngorigen = -76.602685;
                miubicacion = new LatLng(latorigen, lngorigen);
                direccionorigen = miubicacion;
                latdestino = 2.442161;
                lngdestino = -76.605682;
                midestino = new LatLng(latdestino, lngdestino);
                direcciondestino = midestino;
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras)
            {

            }

            @Override
            public void onProviderEnabled(String provider)
            {

            }

            @Override
            public void onProviderDisabled(String provider)
            {

            }
        };

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        latorigen = 2.441212;
        lngorigen = -76.602685;
        miubicacion = new LatLng(latorigen, lngorigen);
        direccionorigen = miubicacion;
        latdestino = 2.442161;
        lngdestino = -76.605682;
        midestino = new LatLng(latdestino, lngdestino);
        direcciondestino = midestino;
        countDownTimer();
    }
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        Marker a = mMap.addMarker(new MarkerOptions().position(direccionorigen).title("Origen"));
        a.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.pegmancuatro));
        //Marker d = mMap.addMarker(new MarkerOptions().position(direcciondestino).title("Destino"));
        //d.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.bici));
        d = mMap.addMarker(new MarkerOptions().position(parada).title("Destino"));
        d.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.bici));
        //mMap.addMarker(new MarkerOptions().position(direcciondestino).title("Destino"));
        double centrarlat =2.441661;
        double centrarlng = -76.604064;
        LatLng centrar = new LatLng(centrarlat, centrarlng);
        CameraPosition camPos = new CameraPosition.Builder()
                .target(centrar)   //Centramos el mapa en Popayan
                .zoom(17)         //Establecemos el zoom en 15
                .bearing(45)      //Establecemos la orientación con el noreste arriba
                .tilt(70)         //Bajamos el punto de vista de la cámara 70 grados
                .build();
        CameraUpdate camUpd3 = CameraUpdateFactory.newCameraPosition(camPos);
        mMap.animateCamera(camUpd3);
        Polyline rutamuestra = mMap.addPolyline(new PolylineOptions()
                .visible(true)//aqui dice si la polyline es visible true-false un ejemplo
                .add(new LatLng(2.441212, -76.602685), new LatLng(2.442161, -76.605682))
                .width(10)
                .color(Color.RED));

        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(false);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        //----------------------------

    }

    private void countDownTimer()
    {

        if (realTimeTimer != null)
        {
            realTimeTimer.cancel();
        }
        realTimeTimer = new CountDownTimer(4000, 1000) {
            public void onTick(long millisUntilFinished) {
                Log.e("seconds remaining: ", "" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                //Toast.makeText(UbicaActivity.this, "Ubicacion Actualizada", Toast.LENGTH_SHORT).show();
                marcarCiclas();
            }
        }.start();
    }

    public void marcarCiclas()
    {

        if(paradalat == 2.442161)
        {
             paradalat = 2.442056;
             paradalng = -76.605450 ;
             parada = new LatLng(paradalat, paradalng);
             d.remove();
             e = mMap.addMarker(new MarkerOptions().position(parada).title("Destino"));
             e.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.bici));
        }else if(paradalat == 2.442056)
        {
            paradalat = 2.441890;
            paradalng = -76.604877 ;
            parada = new LatLng(paradalat, paradalng);
            e.remove();
            f = mMap.addMarker(new MarkerOptions().position(parada).title("Destino"));
            f.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.bici));
        }else if(paradalat == 2.441890)
        {
            paradalat = 2.441781;
            paradalng = -76.604524;
            parada = new LatLng(paradalat, paradalng);
            f.remove();
            g = mMap.addMarker(new MarkerOptions().position(parada).title("Destino"));
            g.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.bici));
        }else if(paradalat == 2.441781)
        {
            paradalat = 2.441693;
            paradalng = -76.604160;
            parada = new LatLng(paradalat, paradalng);
            g.remove();
            h = mMap.addMarker(new MarkerOptions().position(parada).title("Destino"));
            h.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.bici));
        }else if(paradalat == 2.441693)
        {
            paradalat = 2.441366;
            paradalng = -76.603212;
            parada = new LatLng(paradalat, paradalng);
            h.remove();
            i = mMap.addMarker(new MarkerOptions().position(parada).title("Destino"));
            i.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.bici));
        }
        else if(paradalat == 2.441366)
        {
            paradalat = 2.441249;
            paradalng = -76.602781;
            parada = new LatLng(paradalat, paradalng);
            i.remove();
            j = mMap.addMarker(new MarkerOptions().position(parada).title("Destino"));
            j.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.bici));
        }else if (paradalat == 2.441249)
        {
            Toast.makeText(UbicaActivity.this, "El domiciliario llego a su destino", Toast.LENGTH_SHORT).show();
            Button boton =  findViewById(R.id.finalfinal);
            boton.setVisibility(View.VISIBLE);

        }
        countDownTimer();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode)
        {
            case 1:
                {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {


                } else
                    {

                }
                return;
            }
        }
    }


    public void FinalComentario(View view)
    {
        Intent i = new Intent(this, FinalActivity.class);
        startActivity(i);
        realTimeTimer.cancel();
    }
}