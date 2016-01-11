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
public class cine2 extends Fragment {

    static final LatLng Med = new LatLng(6.250117735421909,-75.5778694152832);
    static final LatLng Posrf1 = new LatLng(6.229881716611266,-75.56997634470463); //royal premium plaza
    static final LatLng Posrf2 = new LatLng(6.251604176756476,-75.58572761714458); //Royal Films Carrefour la 65
    static final LatLng Posrf3 = new LatLng(6.268986561202095,-75.56540116667747); //royal Bosque Plaza
    MapView mMapView;
    private GoogleMap googleMap;

    public cine2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cine2, container, false);
        mMapView = (MapView) v.findViewById(R.id.mapViewci2);
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
                Posrf1).title("Royal Films 1").snippet("C.C Premium Plaza");
        MarkerOptions marker2 = new MarkerOptions().position(
                Posrf2).title("Royal Films 2").snippet("Carrefour la 65");
        MarkerOptions marker3 = new MarkerOptions().position(
                Posrf3).title("Royal Films 3").snippet("C.C Bosque Plaza");
        googleMap.addMarker(marker);
        googleMap.addMarker(marker2);
        googleMap.addMarker(marker3);

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
        view.findViewById(R.id.fbrf).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.facebook.com/RoyalFilms/"));
                startActivity(intent);
            }
        });
        view.findViewById(R.id.wbrf).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.royal-films.com/"));
                startActivity(intent);
            }
        });
        view.findViewById(R.id.rf1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(Posrf1).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            }
        });
        view.findViewById(R.id.rf2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(Posrf2).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            }
        });
        view.findViewById(R.id.rf3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(Posrf3).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            }
        });
        view.findViewById(R.id.back2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag_Menu menu = new frag_Menu();
                //fragmentTransaction.hide(getParentFragment());
                fragmentTransaction.replace(android.R.id.content, menu).commit();
            }
        });
    }
}
