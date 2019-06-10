package com.example.sharagem_;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private Button sair;
    private EditText txtLogin;
    private EditText txtSenha;
    private TextView txtRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final UsuarioDAO usuarios = new UsuarioDAO(getApplicationContext());
        txtLogin = (EditText) findViewById(R.id.txtLogin);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        txtRegistrar = (TextView) findViewById(R.id.txtRegistrar);
        login = findViewById(R.id.btnLogin);
        sair = findViewById(R.id.btnSair);

        txtRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Cadastro.class);
                startActivity(intent);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                boolean cond = false;
                for (Usuario u : usuarios.listaUsuarios()) {
                    if (txtLogin.getText().toString().equalsIgnoreCase(u.getLogin()) && txtSenha.getText().toString().equalsIgnoreCase(u.getSenha())) {
                        cond = true;
                        inPutId(u.getId());
                        Log.d("DAO id:", u.getId() + "");
                    }
                }
                if (cond) {
                    Intent intent = new Intent(getApplicationContext(), Garageiros.class);
                    startActivity(intent);
                    finish();
                } else {
                    txtLogin.setBackgroundColor(Color.parseColor("#ffb3b3"));
                    txtSenha.setBackgroundColor(Color.parseColor("#ffb3b3"));
                }
            }
        });

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void inPutId(int id) {
        ((UserData) this.getApplication()).setIdUser(id);
        Log.d("Login id:", ((UserData) this.getApplication()).getIdUser() + "");
    }
}
