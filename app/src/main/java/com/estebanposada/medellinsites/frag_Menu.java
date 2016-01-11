package com.estebanposada.medellinsites;


import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
//import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;



public class frag_Menu extends ListFragment{

    int sel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag__menu, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.menucine, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);


    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String[] cines = getResources().getStringArray(R.array.menucine);
        Toast.makeText(getActivity(),cines[position], Toast.LENGTH_SHORT).show();



        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        cine1 fragment1 = new cine1();
        cine2 fragment2 = new cine2();
        cine3 fragment3 = new cine3();

        //fragmentTransaction.add(android.R.id.content, fragment).commit();

       switch (position) {
            case 0:
               fragmentTransaction.hide(this);

                //fragmentTransaction.replace(android.R.id.list, fragment1);
                fragmentTransaction.add(android.R.id.content, fragment1).commit();
                break;
           case 1:

               fragmentTransaction.hide(this);
               fragmentTransaction.add(android.R.id.content, fragment2).commit();
               //fragmentTransaction.replace(android.R.id.list, fragment2);
               break;
           case 2:
               fragmentTransaction.hide(this);
               fragmentTransaction.add(android.R.id.content, fragment3).commit();
               //fragmentTransaction.replace(android.R.id.list, fragment3);
               break;

        }

    }



}
