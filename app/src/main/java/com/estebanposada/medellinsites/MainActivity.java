package com.estebanposada.medellinsites;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adaptador;
    ListView lstmenu;
    int sel;

    private menuclass[] datal =
            new menuclass[]{
                    new menuclass(R.drawable.mcine, "Cim", "Cine"),
                    new menuclass(R.drawable.mtheater, "Ther", "Teatro"),
                    new menuclass(R.drawable.mrest, "Restau", "Restaurantes"),
                    new menuclass(R.drawable.mparty, "gf", "Rumbas"),
                    new menuclass(R.drawable.mtour, "tu", "Sitios tour")
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] menu = getResources().getStringArray(R.array.menu);
        String[] subm = getResources().getStringArray(R.array.menu_s);
        datal[0].setMenu(menu[0]);      datal[0].setSubm(subm[0]);
        datal[1].setMenu(menu[1]);      datal[1].setSubm(subm[1]);
        datal[2].setMenu(menu[2]);      datal[2].setSubm(subm[2]);
        datal[3].setMenu(menu[3]);      datal[3].setSubm(subm[3]);
        datal[4].setMenu(menu[4]);      datal[4].setSubm(subm[4]);


        Adapter adaptador = new Adapter(this, datal);
        lstmenu = (ListView) findViewById(R.id.menuid);
        lstmenu.setAdapter(adaptador);
        lstmenu.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sel = (int) parent.getItemIdAtPosition(position);

                switch (sel) {
                    case 0:
                        Toast.makeText(MainActivity.this, datal[position].getMenu(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), cinemas.class));
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, datal[position].getMenu(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), theaters.class));
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, datal[position].getMenu(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Restaurants.class));
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, datal[position].getMenu(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), rparty.class));
                        break;
                    case 4:
                        Toast.makeText(MainActivity.this, datal[position].getMenu(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), tours.class));
                        break;
                }
            }
        });

    }

    public class Adapter extends ArrayAdapter {
        public Adapter(Context context, menuclass[] data) {
            super(context, R.layout.menu, datal);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.menu, null);

            TextView menu = (TextView) item.findViewById(R.id.timvec);
            menu.setText(datal[position].getMenu());

            TextView subm = (TextView) item.findViewById(R.id.timvec2);
            subm.setText(datal[position].getSubm());

            ImageView imagen = (ImageView) item.findViewById(R.id.imvec);
            imagen.setImageResource(datal[position].getImagevec());


            return item;
        }
    }

}
