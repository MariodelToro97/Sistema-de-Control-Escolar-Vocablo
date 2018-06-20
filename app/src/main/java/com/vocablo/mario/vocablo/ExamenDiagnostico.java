package com.vocablo.mario.vocablo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExamenDiagnostico extends AppCompatActivity {

    Button Siguiente1; //Declaración de la variable de Realizar examen
    Button SiguienteP; //Declaración de la variable de Regresar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen_diagnostico);
        Siguiente1 = (Button)findViewById(R.id.bntRealizarExamen); //Asignacion a la variable del botón de Realizar examen
        SiguienteP = (Button)findViewById(R.id.bntRealizarExamen2); //Asignación de la variable de Regresar

        getSupportActionBar().hide(); //Oculta la barra superior

        Siguiente1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Se ejecuta al presionar la tecla de Realizar Examen
                startActivity(new Intent(ExamenDiagnostico.this, RealizacionDiag.class)); //Despliegue de la pantalla a mostrar
                finish(); //Cierra la activity completamente
            }
        });

        SiguienteP.setOnClickListener(new View.OnClickListener() { //Se ejecuta al presionar la tecla de Regresar
            @Override
            public void onClick(View v) { //Se ejecuta al presionar la tecla de Regresar
                startActivity(new Intent(ExamenDiagnostico.this, Login.class)); //Despliegue de la pantalla a mostrar
                finish();//Cierra la activity completamente
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
