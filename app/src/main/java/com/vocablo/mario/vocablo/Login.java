package com.vocablo.mario.vocablo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {


    Button Siguiente;
    Button IniciarAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Siguiente = (Button)findViewById(R.id.btnLLenarInfo);
        IniciarAdmin = (Button)findViewById(R.id.btnAdmin);

        getSupportActionBar().hide();

        AlertDialog.Builder alert= new AlertDialog.Builder(this);
        alert.setMessage("Ejemplo de alerta");
        alert.setCancelable(false);
        alert.setTitle("Titulo del mensaje");
        alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int i = 0;
                int j = i+2;

            }
        });

        alert.setPositiveButton("Procesar datos", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int j= 8;
                 int y = 8+j-1;

            }
        });


        alert.show();


        Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(Login.this, ExamenDiagnostico.class);
                startActivity(new Intent(Login.this,ExamenDiagnostico.class));
                //finish();
            }
        });

        IniciarAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(Login.this, ExamenDiagnostico.class);
                startActivity(new Intent(Login.this,InterfazAdmin.class));
                finish();
            }
        });




    }


}