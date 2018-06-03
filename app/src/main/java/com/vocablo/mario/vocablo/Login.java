package com.vocablo.mario.vocablo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Login extends AppCompatActivity {

    //Declaración de las variables de tipo botón que se usan
    Button Siguiente;
    Button IniciarAdmin;
    Spinner Usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //asignación de los botones a las variables creadas
        Siguiente = (Button)findViewById(R.id.btnLLenarInfo);
        IniciarAdmin = (Button)findViewById(R.id.btnAdmin);

        getSupportActionBar().hide(); //Oculta la barra superior de la pantalla

        Usuario = (Spinner) findViewById(R.id.spinner2); //Asignación del Spinner a la variable
        ArrayAdapter<CharSequence> spinner_Adapter = ArrayAdapter.createFromResource(this, R.array.InicioSesion, android.R.layout.simple_spinner_item); //Creación del objeto array con los horarios

        Usuario.setAdapter(spinner_Adapter); //Asignación de los horarios al spinner

        Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Entra cuando se presiona la tecla de Realizar exmaen diagnóstico
                startActivity(new Intent(Login.this,ExamenDiagnostico.class)); //Encargado de lanzar la otra actividad desde aqui
                finish(); //Cierra la activity completamente
            }
        });

        IniciarAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Entra cuando se presiona la tecla de iniciar sesión
                startActivity(new Intent(Login.this,InterfazAdmin.class)); //Encargado de lanzar la otra actividad desde aqui
                finish(); //Cierra la activity completamente
            }
        });

        //código para ocultar la barra de navegación del celular
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
}