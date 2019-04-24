package com.example.sharagem_;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Locacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locacao);
        Intent it = getIntent();
        int tempo = (int) it.getIntExtra("Tempo", 1);
        final String cdgGarag = it.getStringExtra("cdgGarageiro");
        final TextView lblTempo_ = (TextView) findViewById(R.id.lblTempo);
        final EditText txtRetomar_ = (EditText) findViewById(R.id.txtRetomar);
        final ProgressBar prbStatus_ = (ProgressBar) findViewById(R.id.prbStatus);
        txtRetomar_.setVisibility(View.INVISIBLE);
        prbStatus_.setMax(tempo * 10000);
        new CountDownTimer(tempo * 10000, 500) {
            public void onTick(long millisUntilFinished) {
                prbStatus_.setProgress((int) millisUntilFinished);
                if ((millisUntilFinished / 10000) < 1) {
                    lblTempo_.setText("Tens menos de uma hora para retomastes teu veículo.");
                } else {
                    lblTempo_.setText("Tens " + (millisUntilFinished / 10000) + " horas para retomar o seu veículo.");
                }
            }

            public void onFinish() {
                lblTempo_.setText("Insira o código do garageiro para retomaste o teu veículo.");
                txtRetomar_.setVisibility(View.VISIBLE);
            }

        }.start();
        txtRetomar_.addTextChangedListener(
                new TextWatcher() {

                    @Override
                    public void afterTextChanged(Editable s) {
                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start,
                                                  int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start,
                                              int before, int count) {
                        if (s.length() >= 6) {
                            if (txtRetomar_.getText().toString().equalsIgnoreCase(cdgGarag)) {
                                finish();
                            } else {
                                lblTempo_.setText("Código inválido.");
                            }
                        }

                    }
                }
        );

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
