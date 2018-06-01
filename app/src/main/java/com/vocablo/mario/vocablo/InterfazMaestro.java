package com.vocablo.mario.vocablo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InterfazMaestro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_maestro);

        getSupportActionBar().hide(); //Oculta la barra superior de la pantalla
    }
}
