package com.vocablo.mario.vocablo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RegistrarAdministrativo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_administrativo);

        getSupportActionBar().hide();
    }
}
