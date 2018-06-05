package com.vocablo.mario.vocablo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class RegistrarAlumno extends AppCompatActivity {
    //Creación de las variables locales a usar detipo botón durante esta activity
    Button cancelar;
    Button Registrar;
    Spinner NivelG;
    Spinner NivelE;
    EditText Nombre;
    EditText ApellidoP;
    EditText ApellidoM;
    EditText Domicilio;
    EditText Correo;
    EditText Telefono;
    EditText FechaNac;
    RadioButton Hombre;
    RadioButton Mujer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_alumno);

        //Creación del objeto del tipo de la clase de la base de datos para mandarlo a llamar cuando se inserta el dato
        BaseVocablo BD = new BaseVocablo(this, null, null, 1);

        //Asignación de los botones a las variables
        cancelar = (Button)findViewById(R.id.button2); //Botón Cacelar
        Registrar = (Button) findViewById(R.id.button6); //Botón Registrar
        NivelG = (Spinner) findViewById(R.id.nivel); //Asignación del Spinner a la variable
        NivelE = (Spinner) findViewById(R.id.nivel2); //Asignación del Spinner a la variable
        Nombre = (EditText) findViewById(R.id.editText9); //Edit Text Nombre
        ApellidoP = (EditText) findViewById(R.id.editText10); //Edit Text apellido paterno
        ApellidoM = (EditText) findViewById(R.id.editText11); //Edit Text apellido materno
        Domicilio = (EditText)findViewById(R.id.editText15); //Edit text domicilio
        Correo = (EditText)findViewById(R.id.editText12); //Edit text Correo
        Telefono = (EditText)findViewById(R.id.editText13); //Edit text Telefono
        FechaNac = (EditText)findViewById(R.id.editText14); //Edit text Fecha Nacimianto
        Hombre = (RadioButton)findViewById(R.id.radioButton5); //RadioButton Masculino
        Mujer = (RadioButton) findViewById(R.id.radioButton6); //RadioButton Femenino

        ArrayAdapter<CharSequence> spinner_Adapter = ArrayAdapter.createFromResource(this, R.array.NivelGeneral, android.R.layout.simple_spinner_item); //Creación del objeto array con los niveles
        final ArrayAdapter <CharSequence> nivelP = ArrayAdapter.createFromResource(this, R.array.Principiante, android.R.layout.simple_spinner_item); //Creación del objeto array con los respectivos subniveles
        final ArrayAdapter <CharSequence> nivelI = ArrayAdapter.createFromResource(this, R.array.Intermedia, android.R.layout.simple_spinner_item); //Creación del objeto array con los respectivos subniveles
        final ArrayAdapter <CharSequence> nivelIP = ArrayAdapter.createFromResource(this, R.array.IntermediaPlus, android.R.layout.simple_spinner_item); //Creación del objeto array con los respectivos subniveles
        final ArrayAdapter <CharSequence> nivelA = ArrayAdapter.createFromResource(this, R.array.Avanzado, android.R.layout.simple_spinner_item); //Creación del objeto array con los respectivos subniveles
        final AlertDialog.Builder alert= new AlertDialog.Builder(this); //Declaración del tipo de objeto de AlertDialog para mostrar

        NivelG.setAdapter(spinner_Adapter); //Asignación de los horarios al spinner

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Entra cuando se presiona la tecla de Aceptar en el AlertDialog
                startActivity(new Intent(RegistrarAlumno.this, InterfazAdmin.class));//Encargado de lanzar la otra actividad desde aqui
                finish();//Cierra la activity completamente
            }
        });

        Registrar.setOnClickListener(new View.OnClickListener() { //Entra cuando se presiona el botón de registrar
            @Override
            public void onClick(View v) {
                String radio;
                if (Hombre.isChecked()) { //Checa si se seleccionó el radiobutton del género masculino
                    radio = "m"; //Se asigna el valor a ingresar en la BD
                } else {
                    if (Mujer.isChecked()){//Checa si se seleccionó el radiobutton del género femenino
                        radio = "f"; //Se asigna el valor a ingresar en la BD
                    }
                }

                int membresia = (int) (Math.random() * 999999) + 1; //Generación del número de la membresía
                int password = (int) (Math.random() * 999) + 1; //Generación de la contraseña

                alert.setMessage("Datos ingresados de forma correcta:\nMembresía: " + membresia + "\nPassword: " + password); //Asignación de lo que se va a desplegar en el mensaje central del AlertDialog
                alert.setCancelable(false);
                alert.setTitle("Estudiante Ingresado"); //asignación del titulo del AlertDialog

                alert.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {//Entra cuando se presiona la tecla de Aceptar en el AlertDialog
                        startActivity(new Intent(RegistrarAlumno.this,InterfazAlumno.class)); //Encargado de lanzar la otra actividad desde aqui
                        finish(); //Cierra la activity completamente
                    }
                });
                alert.show(); //Muestra el AlertDialog

                //BD.insertarAlumno();
            }
        });

        //Método que se activa al elegir una opción en el spinner del nivel
        NivelG.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { //Entra si se selecciona un item
                if (NivelG.getSelectedItem().toString().equalsIgnoreCase("Principiante")) { //Entra si se selecciona el nivel Principiante
                    NivelE.setAdapter(nivelP); //Asignación de los horarios al spinner
                } else if (NivelG.getSelectedItem().toString().equalsIgnoreCase("Intermedio")) {//Entra si se selecciona el nivel Intermedio
                    NivelE.setAdapter(nivelI); //Asignación de los horarios al spinner
                } else if (NivelG.getSelectedItem().toString().equalsIgnoreCase("Intermedio Plus")) {//Entra si se selecciona el nivel Intermedio Plus
                    NivelE.setAdapter(nivelIP); //Asignación de los horarios al spinner
                } else if (NivelG.getSelectedItem().toString().equalsIgnoreCase("Avanzado")) {//Entra si se selecciona el nivel Avanzado
                    NivelE.setAdapter(nivelA); //Asignación de los horarios al spinner
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { //Entra si no se escoge nada
            }
        });

        getSupportActionBar().hide(); //Oculta la barra superior de la pantalla

    }
}
