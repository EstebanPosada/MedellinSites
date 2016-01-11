package com.estebanposada.medellinsites;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class rest1 extends Fragment {

    static final LatLng Med = new LatLng(6.250117735421909,-75.5778694152832);
    static final LatLng PosRan1 = new LatLng(6.232952031807875,-75.60414299368858); //Rancherito los molinos
    static final LatLng PosRan2 = new LatLng(6.178286276200222,-75.44136073440313); // Rancherito Rionegro
    static final LatLng PosRan3 = new LatLng(6.218300880734473,-75.56479465216398); // Rancherito Las Palmas
    static final LatLng PosRan4 = new LatLng(6.098003310132089,-75.63440669327974); // Rancherito Caldas

    MapView mMapView;
    private GoogleMap googleMap;

    public rest1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_rest1, container, false);
        mMapView = (MapView) v.findViewById(R.id.mapViewre1);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        googleMap = mMapView.getMap();
        // create marker
        MarkerOptions marker = new MarkerOptions().position(
                PosRan1).title("El Rancherito 1").snippet("Los Molinos");
        MarkerOptions marker2 = new MarkerOptions().position(
                PosRan2).title("El Rancherito 2").snippet("Rionegro");
        MarkerOptions marker3 = new MarkerOptions().position(
                PosRan3).title("El Rancherito 3").snippet("Las Palmas");
        MarkerOptions marker4 = new MarkerOptions().position(
                PosRan4).title("El Rancherito 4").snippet("Caldas");
        googleMap.addMarker(marker);
        googleMap.addMarker(marker2);
        googleMap.addMarker(marker3);
        googleMap.addMarker(marker4);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(Med).zoom(9).build();
        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
        googleMap.setMyLocationEnabled(true);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.fbran).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.facebook.com/RestauranteElRancherito"));
                startActivity(intent);
            }
        });
        view.findViewById(R.id.wbran).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.elrancherito.com.co/"));
                startActivity(intent);
            }
        });
        view.findViewById(R.id.ran1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(PosRan1).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            }
        });
        view.findViewById(R.id.ran2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(PosRan2).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            }
        });
        view.findViewById(R.id.ran3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(PosRan3).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            }
        });
        view.findViewById(R.id.ran4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(PosRan4).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            }
        });
    }
}
