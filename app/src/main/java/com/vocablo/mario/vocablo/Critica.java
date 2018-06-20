package com.vocablo.mario.vocablo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Critica extends AppCompatActivity {

    //Asignación de las variables de los tipos botones
    Button Regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_critica);

        getSupportActionBar().hide(); //Oculta la barra superior de la pantalla

        Regresar = (Button) findViewById(R.id.button3);

        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Critica.this,InterfazAlumno.class)); //Encargado de lanzar la otra actividad desde aqui
                finish(); //Cierra la activity completamente
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
