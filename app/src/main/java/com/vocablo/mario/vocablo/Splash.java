package com.vocablo.mario.vocablo;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class Splash extends Activity {
    private final int DURACION_SPLASH = 2000; //Declaración del tiempo en milisegundos

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //Forma de la pantalla en la que se va a mostrar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //

        setContentView(R.layout.splash); //Fija el layout a mostrar

        new Handler().postDelayed(new Runnable(){
            public void run(){ //evento que se desencadena al finalizar el tiempo declarado
                Intent intent = new Intent(Splash.this, Login.class); //Encargado de lanzar la otra actividad desde aqui
                startActivity(intent); //Inicia la instrucción anterior
                finish(); //Cierra la activity completamente
            };
        }, DURACION_SPLASH);

        BaseVocablo db = new BaseVocablo(this, null, null, 1);
    }
}