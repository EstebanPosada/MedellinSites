package com.estebanposada.medellinsites;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

public class cinemas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinemas);

    }

    /*@Override
    public void onBackPressed() {
        super.onBackPressed();
    }*/

    /*@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Toast.makeText(cinemas.this, "Back", Toast.LENGTH_SHORT).show();
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK){
            Toast.makeText(cinemas.this, "Yes Back", Toast.LENGTH_SHORT).show();
        }
        return super.onKeyDown(keyCode, event);
    }*/
}
