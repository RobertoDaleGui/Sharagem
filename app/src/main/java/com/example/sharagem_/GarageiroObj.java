package com.example.sharagem_;

public class GarageiroObj {
    private String nome;
    private double lat;
    private double lon;

    public GarageiroObj(String nome, double lat, double lon) {
        this.nome = nome;
        this.lat = lat;
        this.lon = lon;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "GarageiroObj{" +
                "nome='" + nome + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
