package com.vocablo.mario.vocablo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InterfazPago extends AppCompatActivity {

    Button InterfazAlumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_pago);

        getSupportActionBar().hide();

        InterfazAlumno = (Button)findViewById(R.id.btnMenuAlumno);
        InterfazAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(Login.this, ExamenDiagnostico.class);
                startActivity(new Intent(InterfazPago.this,InterfazAlumno.class));
                finish();
            }
        });
    }
}
