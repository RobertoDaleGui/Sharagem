package com.example.sharagem_;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Garageiro extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garageiro);
        setTitle("Garagem do Fulano");
        Intent it = getIntent();
        String garageiro = it.getStringExtra("Garageiro");
        final String s = it.getStringExtra("cdgGarageiro");
        final Button locar = (Button) findViewById(R.id.btnLocar);
        final Button cancelar = (Button) findViewById(R.id.btnCancelar);
        final TextView lblGarageiro = (TextView) findViewById(R.id.lblGarageiro);
        final TextView lblValor = (TextView) findViewById(R.id.lblValor);
        final TextView lblTempo = (TextView) findViewById(R.id.lblTempo);
        final SeekBar slcTempo = (SeekBar) findViewById(R.id.slcTempo);
        lblGarageiro.setText(garageiro);
        locar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Garageiro.this, Locacao.class);
                it.putExtra("Tempo", (int)slcTempo.getProgress());
                it.putExtra("cdgGarageiro", s);
                startActivity(it);
                finish();
            }
        });

        slcTempo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lblValor.setText("R$" + progress * 1.22);
                lblTempo.setText(progress + " h(s)");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        lblValor.setText("R$" + slcTempo.getProgress() * 1.22);
        lblTempo.setText(slcTempo.getProgress() + " h(s)");

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
