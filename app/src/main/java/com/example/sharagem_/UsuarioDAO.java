package com.example.sharagem_;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO {
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public UsuarioDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void inserir(Usuario usuario) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //db.execSQL("INSERT INTO pessoa(nome) VALUES(" + pessoa.getNome() + ")");
        ContentValues cv = new ContentValues();
        cv.put("nome", usuario.getNome());
        cv.put("login", usuario.getLogin());
        cv.put("senha", usuario.getSenha());
        db.insert("Usuario", null, cv);
    }

    public ArrayList<Usuario> listaUsuarios() {
        db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(
                "Usuario",
                new String[]{"nome", "login", "senha"},
                null,
                null,
                null,
                null,
                null
        );
        ArrayList<Usuario> arrUsuarios = new ArrayList<Usuario>();
        while (cursor.moveToNext()) {
            Usuario u = new Usuario(cursor.getString(0), cursor.getString(1), cursor.getString(2));
            arrUsuarios.add(u);
        }
        return arrUsuarios;
    }
}
