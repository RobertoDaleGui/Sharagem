package com.example.sharagem_;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class GarageiroDAO {
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public GarageiroDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void inserir(GarageiroObj garageiro) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //db.execSQL("INSERT INTO pessoa(nome) VALUES(" + pessoa.getNome() + ")");
        ContentValues cv = new ContentValues();
        cv.put("nome", garageiro.getNome());
        cv.put("latitude", garageiro.getLat());
        cv.put("longitude", garageiro.getLon());
        db.insert("Garageiro", null, cv);
    }

    public ArrayList<GarageiroObj> listaGarageiros() {
        db = dbHelper.getReadableDatabase();
        long numOfEntries = DatabaseUtils.queryNumEntries(db, "Garageiro");
        if(numOfEntries == 0l) {
            // Tabela vazia, preencha com seus dados iniciais
            Log.d("Tabeloide: ","Vazia!!!");
        } else {
            // Tabela ja contem dados.
            Log.d("Tabeloide: ","Chaeia!!!");
        }
        Cursor cursor = db.query(
                "Garageiro",
                new String[]{"nome", "latitude", "longitude"},
                null,
                null,
                null,
                null,
                null
        );
        ArrayList<GarageiroObj> garageiros = new ArrayList<GarageiroObj>();
        while (cursor.moveToNext()) {
            GarageiroObj g = new GarageiroObj(cursor.getString(0), cursor.getDouble(1), cursor.getDouble(2));
            garageiros.add(g);
        }
        return garageiros;
    }
}
