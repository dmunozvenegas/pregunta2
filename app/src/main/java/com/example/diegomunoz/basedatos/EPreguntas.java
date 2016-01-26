package com.example.diegomunoz.basedatos;

/**
 * Created by diegomunoz on 18-01-16.
 */
public class EPreguntas {

    public static final String TABLE_NAME = "tpreguntas";
    public static final String FIELD_ID = "_id";
    public static final String FIELD_PREGUNTA = "pregunta";
    public static final String FIELD_A1 = "a1";
    public static final String FIELD_A2 = "a2";
    public static final String FIELD_A3 = "a3";
    public static final String FIELD_A4 = "a4";
    public static final String FIELD_AC = "ac";
    public static final String FIELD_ESTADO = "estado";
    public static final String CREATE_DB_TABLE = "create table " + TABLE_NAME + "( " +
                                                    FIELD_ID + " integer primary key autoincrement," +
                                                    FIELD_PREGUNTA + " text," +
                                                    FIELD_A1 + " text," +
                                                    FIELD_A2 + " text," +
                                                    FIELD_A3 + " text," +
                                                    FIELD_A4 + " text," +
                                                    FIELD_AC + " text," +
                                                    FIELD_ESTADO + " INTEGER DEFAULT 0" + " );";

    private int id;
    private String pregunta;
    private String a1;
    private String a2;
    private String a3;
    private String a4;
    private String ac;
    private int estado;

    public EPreguntas(String pregunta, String a1, String a2, String a3, String a4, String ac) {
        this.pregunta = pregunta;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.ac = ac;
    }

    public EPreguntas(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
