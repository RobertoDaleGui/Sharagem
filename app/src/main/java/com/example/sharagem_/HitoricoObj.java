package com.example.sharagem_;

public class HitoricoObj {
    private String garageiro;
    private int tempo;
    private String data;

    public HitoricoObj(String garageiro, int tempo, String data) {
        this.garageiro = garageiro;
        this.tempo = tempo;
        this.data = data;
    }

    public String getGarageiro() {
        return garageiro;
    }

    public void setGarageiro(String garageiro) {
        this.garageiro = garageiro;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HistoricoDAO{" +
                "garageiro='" + garageiro + '\'' +
                ", tempo=" + tempo +
                ", data='" + data + '\'' +
                '}';
    }

}
