package com.geektechkb.android34;

import java.io.Serializable;
public class CatModel implements Serializable {
    private String imageCat;
    private String descrioption;

    public CatModel(String imageCat, String descrioption) {
        this.imageCat = imageCat;
        this.descrioption = descrioption;
    }

    public String getImageCat() {
        return imageCat;
    }

    public String getDescrioption() {
        return descrioption;
    }
}
