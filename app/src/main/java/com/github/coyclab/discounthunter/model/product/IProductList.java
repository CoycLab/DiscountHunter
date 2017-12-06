package com.github.coyclab.discounthunter.model.product;

import org.json.JSONException;

import java.util.List;

public interface IProductList {

    List<Product> getProductList() throws JSONException;
}
