package com.vocablo.mario.vocablo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistrarAdministrativo extends AppCompatActivity {

    Button Cancelar; //Creación de la variable a usar de tipo botón

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_administrativo);

        Cancelar = (Button)findViewById(R.id.button2); //Asignación de la variable con el botón de cancelar

        Cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Entra al presionar la tecla de cancelar
                startActivity(new Intent(RegistrarAdministrativo.this, InterfazAdmin.class)); //Encargado de lanzar la otra actividad desde aqui
                finish();//Cierra la activity completamente
            }
        });

        getSupportActionBar().hide(); //Oculta la barra superior de la pantalla
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
