package com.vocablo.mario.vocablo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class RegistrarAlumno extends AppCompatActivity {
    //Creación de las variables locales a usar detipo botón durante esta activity
    Button cancelar;
    Spinner NivelG;
    Spinner NivelE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_alumno);

        //Asignación de los botones a las variables
        cancelar = (Button)findViewById(R.id.button2); //Botón Cacelar
        NivelG = (Spinner) findViewById(R.id.nivel); //Asignación del Spinner a la variable
        NivelE = (Spinner) findViewById(R.id.nivel2); //Asignación del Spinner a la variable
        ArrayAdapter<CharSequence> spinner_Adapter = ArrayAdapter.createFromResource(this, R.array.NivelGeneral, android.R.layout.simple_spinner_item); //Creación del objeto array con los niveles
        final ArrayAdapter <CharSequence> nivelP = ArrayAdapter.createFromResource(this, R.array.Principiante, android.R.layout.simple_spinner_item); //Creación del objeto array con los respectivos subniveles
        final ArrayAdapter <CharSequence> nivelI = ArrayAdapter.createFromResource(this, R.array.Intermedia, android.R.layout.simple_spinner_item); //Creación del objeto array con los respectivos subniveles
        final ArrayAdapter <CharSequence> nivelIP = ArrayAdapter.createFromResource(this, R.array.IntermediaPlus, android.R.layout.simple_spinner_item); //Creación del objeto array con los respectivos subniveles
        final ArrayAdapter <CharSequence> nivelA = ArrayAdapter.createFromResource(this, R.array.Avanzado, android.R.layout.simple_spinner_item); //Creación del objeto array con los respectivos subniveles

        NivelG.setAdapter(spinner_Adapter); //Asignación de los horarios al spinner

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Entra cuando se presiona la tecla de Aceptar en el AlertDialog
                startActivity(new Intent(RegistrarAlumno.this, InterfazAdmin.class));//Encargado de lanzar la otra actividad desde aqui
                finish();//Cierra la activity completamente
            }
        });

        NivelG.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (NivelG.getSelectedItem().toString().equalsIgnoreCase("Principiante")) {
                    NivelE.setAdapter(nivelP); //Asignación de los horarios al spinner
                } else if (NivelG.getSelectedItem().toString().equalsIgnoreCase("Intermedio")) {
                    NivelE.setAdapter(nivelI); //Asignación de los horarios al spinner
                } else if (NivelG.getSelectedItem().toString().equalsIgnoreCase("Intermedio Plus")) {
                    NivelE.setAdapter(nivelIP); //Asignación de los horarios al spinner
                } else if (NivelG.getSelectedItem().toString().equalsIgnoreCase("Intermedio Plus")) {
                    NivelE.setAdapter(nivelA); //Asignación de los horarios al spinner
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        getSupportActionBar().hide(); //Oculta la barra superior de la pantalla

    }
}
