package br.com.jvcm.networkexample.Dtos;

import android.support.annotation.DrawableRes;

public class OfferDtos {

    private String NameProduct;
    private String ProductDescription;
    @DrawableRes
    private int ImgProduct;

    public String getNameProduct() {
        return NameProduct;
    }

    public void setNameProduct(String nameProduct) {
        NameProduct = nameProduct;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public int getImgProduct() {
        return ImgProduct;
    }

    public void setImgProduct(int imgProduct) {
        ImgProduct = imgProduct;
    }
}
