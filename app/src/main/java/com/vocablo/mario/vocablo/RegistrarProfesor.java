package com.vocablo.mario.vocablo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistrarProfesor extends AppCompatActivity {
    //Declararción de las variables a usar durante esta Activity
    Button Cancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_profesor);

        //Asignación de los botones a las variables
        Cancelar = (Button)findViewById(R.id.Cancelar); //Botón Cancelar

        Cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Entra si se presiona el botón de cancelar
                startActivity(new Intent(RegistrarProfesor.this, InterfazAdmin.class));//Encargado de lanzar la otra actividad desde aqui
                finish();//Cierra la activity completamente
            }
        });

        getSupportActionBar().hide(); //oculta la barra superior de la pantalla
    }
}
