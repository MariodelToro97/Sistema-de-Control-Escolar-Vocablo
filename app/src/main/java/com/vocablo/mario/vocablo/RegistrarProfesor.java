package com.vocablo.mario.vocablo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class RegistrarProfesor extends AppCompatActivity {
        //Declararción de las variables a usar durante esta Activity
        Button Cancelar;
        Button Registrar;
        Spinner Nivel;
        EditText RFC, Nombre, ApellidoP, ApellidoM, FechaNac, Telefono, Carrera, Correo, Cedula;
        RadioButton  GeneroM, GeneroF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_profesor);

        getSupportActionBar().hide(); //oculta la barra superior de la pantalla

        //Creación de la clase de la base de datos
        final BaseVocablo baseVocablo = new BaseVocablo(this, null, null, 1);

        //Asignación de los botones a las variables
        Cancelar = (Button)findViewById(R.id.Cancelar); //Botón Cancelar
        Registrar = (Button)findViewById(R.id.button5); //Botón Registrar

        RFC = (EditText)findViewById(R.id.editText22);  //Campo RFC
        Nombre = (EditText)findViewById(R.id.editText10); //Campo Nombre
        ApellidoP = (EditText)findViewById(R.id.editText16); // Campo apellido paterno
        ApellidoM = (EditText)findViewById(R.id.editText17); // Campo apellido materno
        FechaNac = (EditText)findViewById(R.id.editText21); //Campo fecha nacimiento
        GeneroM = (RadioButton) findViewById(R.id.radioButton8); //Campo radio button de hombre
        GeneroF = (RadioButton) findViewById(R.id.radioButton11); //Campo radio button femenino
        Telefono = (EditText)findViewById(R.id.editText18); //Campo telefono
        Carrera = (EditText)findViewById(R.id.editText23); //Campo carrera
        Correo = (EditText)findViewById(R.id.editText19); //Campo correo
        Cedula = (EditText)findViewById(R.id.editText24); //Campo cedula

        //Creación de las variables donde se guardaran los datos de la pantalla
        String rfc, nombre, apellidop, apellidom, fechanac, genero, telefono, carrera, correo, cedula;

        //Asignación de los objetos a las variables que serán usadas en la activity
        rfc = RFC.getText().toString();
        nombre = Nombre.getText().toString();
        apellidop = ApellidoP.getText().toString();
        apellidom = ApellidoM.getText().toString();
        fechanac = FechaNac.getText().toString();
        telefono = Telefono.getText().toString();
        carrera = Carrera.getText().toString();
        correo = Correo.getText().toString();
        cedula = Cedula.getText().toString();

        if (GeneroF.isChecked()){
            genero = "Femenino";
        } else {
            if (GeneroM.isChecked()) {
                genero = "Masculino";
            }
        }

        final int membresia = (int) (Math.random() * 999999) + 1; //Generación del número de la membresía
        int password = (int) (Math.random() * 999) + 1; //Generación de la contraseña

        Nivel = (Spinner) findViewById(R.id.spinner1); //Asignación del Spinner a la variable
        ArrayAdapter<CharSequence> spinner_Adapter = ArrayAdapter.createFromResource(this, R.array.Estudios, android.R.layout.simple_spinner_item); //Creación del objeto array con los horarios

        Nivel.setAdapter(spinner_Adapter); //Asignación de los horarios al spinner

        Cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Entra si se presiona el botón de cancelar
                startActivity(new Intent(RegistrarProfesor.this, InterfazAdmin.class));//Encargado de lanzar la otra actividad desde aqui
                finish();//Cierra la activity completamente
            }
        });

        /*Registrar.setOnClickListener(new View.OnClickListener() { //Entra si se presona el botón de Registrar
            @Override
            public void onClick(View v) {
                baseVocablo.insertarMaestro(membresia);
            }
        });*/
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
