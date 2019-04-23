package com.example.sharagem_;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Locacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locacao);
        Intent it = getIntent();
        int tempo = (int) it.getIntExtra("Tempo", 1);
        final TextView lblTempo_ = (TextView) findViewById(R.id.lblTempo);
        final TextView txtRetomar_ = (TextView) findViewById(R.id.txtRetomar);
        txtRetomar_.setVisibility(View.INVISIBLE);
        new CountDownTimer(tempo * 10000, 1000) {
            public void onTick(long millisUntilFinished) {
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

    }
}
