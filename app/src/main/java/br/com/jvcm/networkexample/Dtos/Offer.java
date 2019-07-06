package br.com.jvcm.networkexample.Dtos;

import com.google.gson.annotations.SerializedName;

/**
 * offerId
 * name
 * descriptiom
 * img
 * value
 */
public class Offer {

    private String name;
    private String descripitiom;
    private String offerId;
    private float value;
    @SerializedName("img")
    private String img;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripitiom() {
        return descripitiom;
    }

    public void setDescripitiom(String descripitiom) {
        this.descripitiom = descripitiom;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }
}
