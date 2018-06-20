package com.vocablo.mario.vocablo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RevisarTutorados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revisar_tutorados);

        getSupportActionBar().hide(); //Oculta la barra superior de la pantalla
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
