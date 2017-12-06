package com.github.coyclab.discounthunter.model.product;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;

import java.util.List;

public class ProductList implements IProductList {

    private static final String PRODUCTS = "products";

    @SerializedName(PRODUCTS)
    private List<Product> mProductList;

    @Override
    public List<Product> getProductList() throws JSONException {
        return mProductList;
    }
}
