package com.vocablo.mario.vocablo;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Calendar;

public class InterfazAgendarCita extends AppCompatActivity implements View.OnClickListener {
    //Declaración de los botones
    Button Regresar;
    Button Cita;
    Spinner Horarios; //Declración de los horarios
    ImageButton Calendario; //imagen Calendario
    private int dia, mes, ano, dias;
    EditText tfecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_agendar_cita);

        getSupportActionBar().hide(); //Oculta la barra superior

        Regresar = (Button)findViewById(R.id.btnMenuAlumno2); //Asignación del botón de Regresar
        Cita = (Button)findViewById(R.id.btnMenuAlumno); //Asignación del botón de Agendar Cita
        Calendario = (ImageButton) findViewById(R.id.imageButton); //Asignación del botón calendario.
        tfecha=(EditText)findViewById(R.id. editText35);

        Calendario.setOnClickListener(this);

        Horarios = (Spinner) findViewById(R.id.spinner); //Asignación del Spinner a la variable

        final AlertDialog.Builder alert= new AlertDialog.Builder(this); //Declaración del tipo de objeto de AlertDialog para mostrar

        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Entra si se presiona el botón de Regresar
                startActivity(new Intent(InterfazAgendarCita.this,InterfazAlumno.class)); //Encargado de lanzar la otra actividad desde aqui
                finish();//Cierra la activity completamente
            }
        });

        Cita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Entra si se presiona el botón de cita
                alert.setMessage("Ejemplo de alerta"); //Asignación de lo que se va a desplegar en el mensaje central del AlertDialog
                alert.setCancelable(false);
                alert.setTitle("Cita Agendada"); //asignación del titulo del AlertDialog

                alert.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {//Entra cuando se presiona la tecla de Aceptar en el AlertDialog
                        startActivity(new Intent(InterfazAgendarCita.this,InterfazAlumno.class)); //Encargado de lanzar la otra actividad desde aqui
                        finish(); //Cierra la activity completamente
                    }
                });
                alert.show(); //Muestra el AlertDialog
            }
        });
    }

    @Override
    public void onClick(View v) {
        final Calendar c = Calendar.getInstance();
        dia=c.get(Calendar.DAY_OF_MONTH);
        mes=c.get(Calendar.MONTH);
        ano=c.get(Calendar.YEAR);

        final ArrayAdapter <CharSequence> spinner_AdapterS = ArrayAdapter.createFromResource(this, R.array.HorarioSabado, android.R.layout.simple_spinner_item); //Creación del objeto array con los horarios
        final ArrayAdapter <CharSequence> spinner_Adapter = ArrayAdapter.createFromResource(this, R.array.HorariosSemana, android.R.layout.simple_spinner_item); //Creación del objeto array con los horarios
        final ArrayAdapter <CharSequence> spinner_AdapterD = ArrayAdapter.createFromResource(this, R.array.Domingo, android.R.layout.simple_spinner_item); //Creación del objeto array con los horarios

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                c.set(year, month, dayOfMonth);

                dias=c.get(Calendar.DAY_OF_WEEK);
                String day = "";
                switch (dias){
                    case 1: day = "D";
                        break;
                    case 7: day = "S";
                        break;
                }

                if (day.equalsIgnoreCase("S")) {
                    Horarios.setAdapter(spinner_AdapterS); //Asignación de los horarios al spinner
                    tfecha.setText(dayOfMonth+"/"+month+"/"+year);
                } else {
                    if (day.equalsIgnoreCase("D")){
                        Horarios.setAdapter(spinner_AdapterD); //Asignación de los horarios al spinner
                        tfecha.setText("");
                        Toast.makeText(getApplicationContext(), "No existen clases los domingos", Toast.LENGTH_LONG).show();
                    } else {
                        Horarios.setAdapter(spinner_Adapter); //Asignación de los horarios al spinner
                        tfecha.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                }
            }
        },dia, mes, ano);
        datePickerDialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //Entra si se presiona el botón de Regresar
        startActivity(new Intent(InterfazAgendarCita.this,InterfazAlumno.class)); //Encargado de lanzar la otra actividad desde aqui
        finish();//Cierra la activity completamente
    }
}
