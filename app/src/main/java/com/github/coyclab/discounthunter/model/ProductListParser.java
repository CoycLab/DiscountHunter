package com.github.coyclab.discounthunter.model;

import com.github.coyclab.discounthunter.model.product.IProductListParser;
import com.github.coyclab.discounthunter.model.product.ProductList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Date;

import static android.support.v4.os.LocaleListCompat.create;
import static java.lang.Integer.valueOf;

public class ProductListParser implements IProductListParser {

    private final InputStream mInputStream;

    public ProductListParser(final InputStream pInputStream) {
        mInputStream = pInputStream;
    }

    @Override
    public ProductList parse() throws Exception {
        final Reader reader = new InputStreamReader(mInputStream);
        final Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

                    @Override
                    public Date deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {
                        return json == null ? null : new Date(json.getAsLong());
                    }
                }).create();
        return gson.fromJson(reader, ProductList.class);
    }
}

