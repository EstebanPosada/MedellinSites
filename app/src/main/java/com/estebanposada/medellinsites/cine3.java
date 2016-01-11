package com.estebanposada.medellinsites;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
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
public class cine3 extends Fragment {

    static final LatLng Med = new LatLng(6.250117735421909,-75.5778694152832);
    static final LatLng PosCc1 = new LatLng(6.2327414,-75.6059468); // Cine colombia Molinos
    static final LatLng PosCc2 = new LatLng(6.1998211,-75.5778446); // Cineco Santa fé
    static final LatLng PosCc3 = new LatLng(6.2412369,-75.5875318); // Cineco Unicentro
    static final LatLng PosCc4 = new LatLng(6.2082183,-75.5656573); // Cineco Oviedo
    MapView mMapView;
    private GoogleMap googleMap;

    public cine3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cine3, container, false);
        mMapView = (MapView) v.findViewById(R.id.mapViewci3);
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
                PosCc1).title("Cineco 1").snippet("C.C Los Molinos");
        MarkerOptions marker2 = new MarkerOptions().position(
                PosCc2).title("Cineco 2").snippet("C.C Santa fé");
        MarkerOptions marker3 = new MarkerOptions().position(
                PosCc3).title("Cineco 3").snippet("C.C Unicentro");
        MarkerOptions marker4 = new MarkerOptions().position(
                PosCc4).title("Cineco 4").snippet("C.C Oviedo");
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
        FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        view.findViewById(R.id.fbcc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.facebook.com/cinecolombiaoficial/"));
                startActivity(intent);
            }
        });
        view.findViewById(R.id.wbcc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.cinecolombia.coms/"));
                startActivity(intent);
            }
        });
        view.findViewById(R.id.cc1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(PosCc1).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            }
        });
        view.findViewById(R.id.cc2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(PosCc2).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            }
        });
        view.findViewById(R.id.cc3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(PosCc3).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            }
        });
        view.findViewById(R.id.cc4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(PosCc4).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            }
        });
        view.findViewById(R.id.back3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag_Menu menu = new frag_Menu();
                //fragmentTransaction.hide(getParentFragment());
                fragmentTransaction.replace(android.R.id.content, menu).commit();
            }
        });
    }
}
