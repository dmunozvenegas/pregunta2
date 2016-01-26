package com.example.diegomunoz.basedatos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by diegomunoz on 18-01-16.
 */
public class Jugar extends AppCompatActivity implements View.OnClickListener{

    private Button btn1,btn2,btn3,btn4;
    private TextView pregunta;
    EPreguntas p = null;
    DPreguntas objpreguntas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jugar);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        pregunta = (TextView)findViewById(R.id.tvPregunta);
        generarPreguntas();

    }

    private void generarPreguntas() {
        objpreguntas = new DPreguntas(this);
        ArrayList<EPreguntas> preg = objpreguntas.getPregunta("0");
        if (!preg.isEmpty()) {
            int aleatorio = generarAleatorio(preg.size());
            p = preg.get(aleatorio);
            btn1.setText(p.getA1());
            btn2.setText(p.getA2());
            btn3.setText(p.getA3());
            btn4.setText(p.getA4());
            pregunta.setText(p.getPregunta());
        }
    }

    private int generarAleatorio(int cantidad) {
        return (int) (Math.random()*cantidad);
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button)v;
        if (p.getAc().equals(btn.getText())){
            Toast.makeText(getApplicationContext(),"ACERTASTE",Toast.LENGTH_SHORT).show();
            p.setEstado(1);
            objpreguntas.actualizarPreguntas(p);
            generarPreguntas();

        }else{
            Toast.makeText(getApplicationContext(),"EQUIVOCADO",Toast.LENGTH_SHORT).show();
        }
    }
}
