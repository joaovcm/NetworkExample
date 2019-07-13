package br.com.jvcm.networkexample.Dtos;

import com.google.gson.annotations.SerializedName;

/**
 * offerId
 * name
 * description
 * img
 * value
 */
public class Offer {

    private String name;
    private String description;
    private String offerId;
    private String value;
    @SerializedName("img")
    private String img;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
