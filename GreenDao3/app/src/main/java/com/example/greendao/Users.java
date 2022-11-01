package com.example.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Users {
    String nom;

    @Generated(hash = 1121120129)
    public Users(String nom) {
        this.nom = nom;
    }

    @Generated(hash = 2146996206)
    public Users() {
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}