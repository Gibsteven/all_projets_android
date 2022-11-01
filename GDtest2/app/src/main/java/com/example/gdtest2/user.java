package com.example.gdtest2;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class user {
    String name;
    String id;

    @Generated(hash = 1716880134)
    public user(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Generated(hash = 591315204)
    public user() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
