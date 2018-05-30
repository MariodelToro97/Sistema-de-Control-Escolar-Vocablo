package com.vocablo.mario.vocablo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExamenDiagnostico extends AppCompatActivity {

    Button Siguiente1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen_diagnostico);
        Siguiente1 = (Button)findViewById(R.id.bntRealizarExamen);

        getSupportActionBar().hide();


        Siguiente1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(Login.this, ExamenDiagnostico.class);
                startActivity(new Intent(ExamenDiagnostico.this,RealizacionDiag.class));
                //finish();
            }
        });
    }
}
