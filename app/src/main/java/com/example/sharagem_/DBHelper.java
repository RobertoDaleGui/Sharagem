package com.example.sharagem_;

import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "sharagem.db";
    private final static int DATABASE_VERSION = 11;
    private final static String CREATE_USUARIO = "CREATE TABLE " +
            "Usuario (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, login TEXT, senha TEXT)";
    private final static String POPULA_USUARIO = "INSERT INTO Usuario (nome, login, senha) " +
            "VALUES ('Roberto DAlaessandro Guimarães', 'Roberto', '20968802')," +
            " ('Marlon Rodrigues', 'Marlon', '20968802')," +
            " ('Raul Silva Leal', 'Raul', '20987771')," +
            " ('David Patricio','David', '12345678')," +
            " ('Mario Sobrenome', 'Mario', '12345678')";
    private final static String CREATE_GARAGEIRO = "CREATE TABLE " +
            "Garageiro (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, cdgDevolucao NUMERIC, latitude NUMERIC, longitude NUMERIC)";
    private final static String POPULA_GARAGEIROS = "INSERT INTO Garageiro (nome, latitude, longitude, cdgDevolucao) " +
            "VALUES ('Roberto', -23.550524, -46.610202, 8802)," +
            " ('Marlon', -23.5502693, -46.6105029, 123456)," +
            " ('Raul', -23.5498697,-46.6116831, 7771)," +
            " ('David', -23.549490,-46.611756, 123456)," +
            " ('Mario', -23.549287,-46.612053, 123456)";

    private final static String CREATE_HISTORICO = "CREATE TABLE " +
            "Historico (id INTEGER PRIMARY KEY AUTOINCREMENT, garageiro TEXT, tempo INTEGER, data NUMERIC)";
    private final static String DROP_USUARIO = "DROP TABLE Usuario";
    private final static String DROP_GARAGEIRO = "DROP TABLE Garageiro";
    private final static String DROP_HISTORICO = "DROP TABLE Historico";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        context.deleteDatabase(DATABASE_NAME);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL(DROP_USUARIO);
        //db.execSQL(DROP_GARAGEIRO);
        //db.execSQL(DROP_HISTORICO);

        db.execSQL(CREATE_USUARIO);
        db.execSQL(CREATE_GARAGEIRO);
        db.execSQL(CREATE_HISTORICO);

        db.execSQL(POPULA_USUARIO);
        db.execSQL(POPULA_GARAGEIROS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
