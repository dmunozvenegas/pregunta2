package com.example.diegomunoz.basedatos;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by diegomunoz on 18-01-16.
 */
public class splash extends AppCompatActivity {

    private boolean estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        cargarPreferencias();
        if (estado) {
            Intent intent = new Intent(splash.this,MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            procesoCarga proceso = new procesoCarga();
            proceso.execute();
        }

    }

    private void cargarPreferencias() {
        SharedPreferences mispreferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        mispreferencias.getBoolean("isLoad", false);
    }

    private void guardarPreferencias(boolean valor) {
        SharedPreferences mispreferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mispreferencias.edit();
        editor.putBoolean("isLoad",valor);
        editor.commit();
    }

    private class procesoCarga extends AsyncTask<Void,Void,Void> {
        ProgressDialog dialog;

        ArrayList<EPreguntas> preguntas = new ArrayList<EPreguntas>(Arrays.asList(
                new EPreguntas("Quien descubrio America","Cristobal Colon","Diego Maradona","Pele","Zidane","Cristobal Colon"),
                new EPreguntas("Quien Mato a Marilyn","Diego Rivera","Ferb","Batman","Raton Mickey","Raton Mickey"),
                new EPreguntas("Quien le robo el sombrero al Profesor","Kiko","Chavo","Botija","Zidane","Chavo"),
                new EPreguntas("Quien fue el creador de Facebook","Martin Luter King","Bob Marley","Mark Zuckerberg","Pepa Pig","Mark Zuckerberg"),
                new EPreguntas("Quien ganó la ultima Copa America 2015","España","Mexico","Chile","Brasil","Chile"),
                new EPreguntas("Quien le robo el sombrero al Profesor","Kiko","Chavo","Botija","Zidane","Chavo"),
                new EPreguntas("Cuantos Pokemones existen","150","721","666","123","721")
        ));

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(splash.this);
            dialog.setTitle("Esto Es Titulo");
            dialog.setMessage("Insertando en BD");
            dialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            guardarPreferencias(true);

            if (dialog.isShowing()){
                dialog.dismiss();
                Intent intent = new Intent(splash.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }

        @Override
        protected Void doInBackground(Void... params) {
            DPreguntas helper = new DPreguntas(splash.this);

            for (int i = 0 ; i < preguntas.size() ; i++){
                EPreguntas preg = new EPreguntas();
                preg = preguntas.get(i);
                helper.insertarPreguntas(preg);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            return null;
        }
    }
}
