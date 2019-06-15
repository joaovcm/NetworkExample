package br.com.jvcm.networkexample.Model;

import android.support.annotation.DrawableRes;

public class OfferDataSet {
    private String NameProduct;
    private String ProductDescripition;
    @DrawableRes
    private int imgProduct;

    public int getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(int imgProduct) {
        this.imgProduct = imgProduct;
    }

    public String getProductDescripition() {
        return ProductDescripition;
    }

    public void setProductDescripition(String productDescripition) {
        ProductDescripition = productDescripition;
    }

    public String getNameProduct() {
        return NameProduct;
    }

    public void setNameProduct(String nameProduct) {
        NameProduct = nameProduct;
    }
}
