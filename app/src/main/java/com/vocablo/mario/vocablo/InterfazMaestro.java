package com.vocablo.mario.vocablo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InterfazMaestro extends AppCompatActivity {

    //Declaración de las variables de tipo botón que se usan
    Button Cerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_maestro);

        getSupportActionBar().hide(); //Oculta la barra superior de la pantalla

        //asignación de los botones a las variables creadas
        Cerrar = (Button)findViewById(R.id.btnCerrarSesion);

        Cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InterfazMaestro.this, Login.class)); //Encargado de lanzar la otra actividad desde aqui
                finish(); //Cierra la activity completamente
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(InterfazMaestro.this, Login.class)); //Encargado de lanzar la otra actividad desde aqui
        finish(); //Cierra la activity completamente
    }
}
