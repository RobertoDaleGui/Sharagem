package com.example.sharagem_;

import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "sharagem.db";
    private final static int DATABASE_VERSION = 2;
    private final static String CREATE_USUARIO = "CREATE TABLE " +
            "Usuario (id INTEGER PRIMARY KEY AUTOINCREMENT, login TEXT, senha TEXT)";
    private final static String POPULA_USUARIO = "INSERT INTO Usuario (login, senha) " +
            "VALUES ('Roberto', '12345678')," +
            " ('Marlon', '12345678')," +
            " ('Raul', '12345678')," +
            " ('David', '12345678')," +
            " ('Mario', '12345678')";
    private final static String CREATE_GARAGEIRO = "CREATE TABLE " +
            "Garageiro (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, latitude NUMERIC, longitude NUMERIC)";
    private final static String POPULA_GARAGEIROS = "INSERT INTO Garageiro (nome, latitude, longitude) " +
            "VALUES ('Roberto', -23.550524, -46.610202)," +
            " ('Marlon', -23.5502693, -46.6105029)," +
            " ('Raul', -23.5498697,-46.6116831)," +
            " ('David', -23.549490,-46.611756)," +
            " ('Mario', -23.549287,-46.612053)";

    private final static String CREATE_HISTORICO = "CREATE TABLE " +
            "Historico (id INTEGER PRIMARY KEY AUTOINCREMENT, garageiro TEXT, tempo INTEGER, data NUMERIC)";
    private final static String DROP_USUARIO = "DROP TABLE Usuario";
    private final static String DROP_GARAGEIRO = "DROP TABLE Garageiro";
    private final static String DROP_HISTORICO = "DROP TABLE Historico";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
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
