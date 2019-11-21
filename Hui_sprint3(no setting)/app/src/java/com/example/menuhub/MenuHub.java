package com.example.menuhub;


import org.litepal.crud.DataSupport;

import java.io.Serializable;

public class MenuHub extends DataSupport implements Serializable {
    public String name;
    public String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
