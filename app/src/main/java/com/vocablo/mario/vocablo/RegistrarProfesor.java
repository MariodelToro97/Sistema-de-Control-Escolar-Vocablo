package com.vocablo.mario.vocablo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RegistrarProfesor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_profesor);

        getSupportActionBar().hide();
    }
}
