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
import android.widget.Toast;

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
public class cine1 extends Fragment {

    static final LatLng Med = new LatLng(6.250117735421909,-75.5778694152832);
    static final LatLng PosProc1 = new LatLng(6.3387635,-75.5465198); //Procinal puerta del norte
    static final LatLng PosProc2 = new LatLng(6.2142552272682146,-75.57476073503494); //Procinal Monterrey
    static final LatLng PosProc3 = new LatLng(6.270572929916585,-75.57742953300476); //Procinal florida
    static final LatLng PosProc4 = new LatLng(6.1617553,-75.6073707); //Procinal Mayorca
    MapView mMapView;
    private GoogleMap googleMap;

    public cine1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cine1, container, false);
        mMapView = (MapView) v.findViewById(R.id.mapViewci1);
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
                PosProc1).title("Procinal 1").snippet("C.C Puerta del Norte");
        MarkerOptions marker2 = new MarkerOptions().position(
                PosProc2).title("Procinal 2").snippet("C.C Monterrey");
        MarkerOptions marker3 = new MarkerOptions().position(
                PosProc3).title("Procinal 3").snippet("C.C Florida");
        MarkerOptions marker4 = new MarkerOptions().position(
                PosProc4).title("Procinal 4").snippet("C.C Mayorca");
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
        view.findViewById(R.id.fbproc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.facebook.com/procinal/"));
                startActivity(intent);
            }
        });
        view.findViewById(R.id.wbpro).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.procinal.com.co/"));
                startActivity(intent);
            }
        });
        view.findViewById(R.id.pro1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(PosProc1).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            }
        });
        view.findViewById(R.id.pro2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(PosProc2).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            }
        });
        view.findViewById(R.id.pro3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(PosProc3).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            }
        });
        view.findViewById(R.id.pro4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(PosProc4).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory
                        .newCameraPosition(cameraPosition));
            }
        });
        view.findViewById(R.id.back1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag_Menu menu = new frag_Menu();
                //fragmentTransaction.hide(getParentFragment());
                fragmentTransaction.replace(android.R.id.content, menu).commit();
            }
        });
    }

    /*@Override
    public void onDestroyView() {
        super.onDestroyView();
        FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        frag_Menu menu = new frag_Menu();
        fragmentTransaction.add(android.R.id.content, menu);
        Toast.makeText(getActivity(), "Destroy VIew", Toast.LENGTH_SHORT).show();
    }*/

//    @Override
//    public void onStop() {
//        super.onStop();
//        FragmentManager fragmentManager = getFragmentManager();
//        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        frag_Menu menu = new frag_Menu();
//        fragmentTransaction.add(android.R.id.content, menu);
//        Toast.makeText(getActivity(), "Stop", Toast.LENGTH_SHORT).show();
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        frag_Menu menu = new frag_Menu();
        fragmentTransaction.add(android.R.id.content, menu);
        //Toast.makeText(getActivity(), "Detach", Toast.LENGTH_SHORT).show();
    }
}
