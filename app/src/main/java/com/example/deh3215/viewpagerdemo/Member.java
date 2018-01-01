package com.example.deh3215.viewpagerdemo;

import java.io.Serializable;

/**
 * Created by deh3215 on 2017/12/31.
 */

public class Member implements Serializable{

    private int id;
    private int image;
    private String name;

    public Member(int id, int image, String name) {
        this.id = id;
        this.image = image;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }
}

