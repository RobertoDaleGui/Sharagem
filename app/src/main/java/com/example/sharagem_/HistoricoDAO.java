package com.example.sharagem_;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class HistoricoDAO {
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public HistoricoDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void inserir(GarageiroObj garageiro) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //db.execSQL("INSERT INTO pessoa(nome) VALUES(" + pessoa.getNome() + ")");
        ContentValues cv = new ContentValues();
        cv.put("garageiro", garageiro.getNome());
        cv.put("tempo", garageiro.getLat());
        cv.put("data", garageiro.getLon());
        db.insert("Historico", null, cv);
    }

    public List<HitoricoObj> listaHistorico() {
        db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(
                "Historico",
                new String[]{"garageiro", "tempo", "data"},
                null,
                null,
                null,
                null,
                null
        );
        ArrayList<HitoricoObj> garageiros = new ArrayList<HitoricoObj>();
        while (cursor.moveToNext()) {
            HitoricoObj h = new HitoricoObj(cursor.getString(0), cursor.getInt(1), cursor.getString(2));
            garageiros.add(h);
        }
        return garageiros;
    }

}
