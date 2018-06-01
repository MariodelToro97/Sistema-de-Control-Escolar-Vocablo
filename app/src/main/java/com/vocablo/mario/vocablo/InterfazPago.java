package com.vocablo.mario.vocablo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InterfazPago extends AppCompatActivity {

    Button InterfazAlumno; //Declaración del botón de Regresar
    Button Pago; //Declaración del botón de pago

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_pago);

        getSupportActionBar().hide();

        //Asignación de los botones a las variables
        InterfazAlumno = (Button)findViewById(R.id.btnMenuAlumno);
        Pago = (Button) findViewById(R.id.btnMenuAlumno3);

        //Método que realiza al presionar sobre el botón de Regresar
        InterfazAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InterfazPago.this,InterfazAlumno.class)); //Despliegue de la pantalla a mostrar
                finish(); //Cierra la interfaz completamente
            }
        });
        //Método que realiza al presionar sobre el botón de pago
        Pago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InterfazPago.this,InterfazAlumno.class)); //Despliegue de la pantalla a mostrar
                finish(); //Cierra la interfaz completamente
            }
        });
    }
}
