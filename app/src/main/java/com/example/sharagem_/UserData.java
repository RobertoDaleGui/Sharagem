package com.example.sharagem_;

import android.app.Application;

public class UserData extends Application {
    private int money;
    private int idUser;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
