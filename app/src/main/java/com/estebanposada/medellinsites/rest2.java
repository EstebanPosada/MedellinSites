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
public class rest2 extends Fragment {

    static final LatLng Med = new LatLng(6.250117735421909,-75.5778694152832);
    static final LatLng PosMon1 = new LatLng(6.2096929140711605,-75.56791003793478); //Mondongos Poblado
    static final LatLng PosMon2 = new LatLng(6.246362952473201,-75.5891377106309);  ////Mondongos La 70
    static final LatLng PosMon3 = new LatLng(25.806733448840365,-80.33775541931391); //Mondongos Miami
    MapView mMapView;
    private GoogleMap googleMap;

    public rest2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_rest2, container, false);
        mMapView = (MapView) v.findViewById(R.id.mapViewre2);
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
                PosMon1).title("Mondongo's").snippet("El Poblado");
        MarkerOptions marker2 = new MarkerOptions().position(
                PosMon2).title("Mondongo's").snippet("La 70");
        MarkerOptions marker3 = new MarkerOptions().position(
                PosMon3).title("Mondongo's").snippet("Miami");
        googleMap.addMarker(marker);
        googleMap.addMarker(marker2);
        googleMap.addMarker(marker3);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(Med).zoom(14).build();
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
        view.findViewById(R.id.fbmond).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.mondongos.com.co/"));
                startActivity(intent);
            }
        });
        view.findViewById(R.id.wbmon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.mondongos.com.co/"));
                startActivity(intent);
            }
        });
        view.findViewById(R.id.mond1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(PosMon1).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            }
        });
        view.findViewById(R.id.mond2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(PosMon2).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            }
        });
        view.findViewById(R.id.mond3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(PosMon3).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            }
        });
    }
}
