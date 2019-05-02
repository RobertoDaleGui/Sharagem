package com.example.sharagem_;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private Button sair;
    private EditText txtLogin;
    private EditText txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final UsuarioDAO usuarios = new UsuarioDAO(getApplicationContext());
        txtLogin = (EditText) findViewById(R.id.txtLogin);
        txtSenha = (EditText) findViewById(R.id.txtSenha);

        login = findViewById(R.id.btnLogin);
        sair = findViewById(R.id.btnSair);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean cond = false;
                for (Usuario u : usuarios.listaUsuarios()) {
                    if (txtLogin.getText().toString().equalsIgnoreCase(u.getLogin()) && txtSenha.getText().toString().equalsIgnoreCase(u.getSenha())) {
                        cond = true;
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
}
