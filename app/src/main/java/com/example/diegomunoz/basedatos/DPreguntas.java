package com.example.diegomunoz.basedatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by diegomunoz on 18-01-16.
 */
public class DPreguntas extends SQLiteOpenHelper {

    private static final String DB_NAME = "preguntas";
    private static final int SCHEME_VERSION = 1;
    private SQLiteDatabase db;


    public DPreguntas(Context context) {
        super(context, DB_NAME, null, SCHEME_VERSION);
        db = this.getWritableDatabase();
    }

    private ContentValues generarValores(EPreguntas preguntas) {
        ContentValues valores = new ContentValues();
        valores.put(EPreguntas.FIELD_PREGUNTA,preguntas.getPregunta());
        valores.put(EPreguntas.FIELD_A1,preguntas.getA1());
        valores.put(EPreguntas.FIELD_A2,preguntas.getA2());
        valores.put(EPreguntas.FIELD_A3,preguntas.getA3());
        valores.put(EPreguntas.FIELD_A4, preguntas.getA4());
        valores.put(EPreguntas.FIELD_AC,preguntas.getAc());
        valores.put(EPreguntas.FIELD_ESTADO,preguntas.getEstado());
        return valores;
    }

    public void insertarPreguntas(EPreguntas preguntas) {
        db.insert(EPreguntas.TABLE_NAME, null, generarValores(preguntas));
    }

    public ArrayList<EPreguntas> getPregunta(String valor){

        ArrayList<EPreguntas> preguntas = new ArrayList<>();
        String columna[] = {EPreguntas.FIELD_ID,EPreguntas.FIELD_PREGUNTA,
                            EPreguntas.FIELD_A1,EPreguntas.FIELD_A2,EPreguntas.FIELD_A3,EPreguntas.FIELD_A4,
                            EPreguntas.FIELD_AC,EPreguntas.FIELD_ESTADO};
        Cursor c = db.query(EPreguntas.TABLE_NAME,columna,EPreguntas.FIELD_ESTADO + "=?",new String[] {valor},null,null,null);

        if (c.moveToFirst()){
            do {
                EPreguntas p = new EPreguntas();
                p.setId(c.getInt(0));
                p.setPregunta(c.getString(1));
                p.setA1(c.getString(2));
                p.setA2(c.getString(3));
                p.setA3(c.getString(4));
                p.setA4(c.getString(5));
                p.setAc(c.getString(6));
                p.setEstado(c.getInt(7));
                preguntas.add(p);
            }while(c.moveToNext());
        }
        return preguntas;
    }

    public void actualizarPreguntas(EPreguntas preguntas) {
        db.update(EPreguntas.TABLE_NAME,generarValores(preguntas),EPreguntas.FIELD_ID + "=?", new String[] {String.valueOf(preguntas.getId())});
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(EPreguntas.CREATE_DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
