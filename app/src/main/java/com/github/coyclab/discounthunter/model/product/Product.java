package com.github.coyclab.discounthunter.model.product;

import com.github.coyclab.discounthunter.model.seller.Seller;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Product implements IProduct {

    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String PRICE = "price";
    private static final String DISCOUNT = "discount";
    private static final String IMAGE = "image";
    private static final String CATEGORY = "category";
    private static final String FROM_DATE = "from_date";
    private static final String SINCE_DATE = "since_date";
    private static final String SELLER = "seller";

    @SerializedName(NAME)
    private String mName;

    @SerializedName(DESCRIPTION)
    private String mDescription;

    @SerializedName(PRICE)
    private Double mPrice;

    @SerializedName(DISCOUNT)
    private int mDiscount;

    @SerializedName(IMAGE)
    private String mImage;

    @SerializedName(CATEGORY)
    private int mCategory;

    @SerializedName(FROM_DATE)
    private Date mFromDate;

    @SerializedName(SINCE_DATE)
    private Date mSinceDate;

    @SerializedName(SELLER)
    private Seller mSeller;

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public String getDescription() {
        return mDescription;
    }

    @Override
    public Double getPrice() {
        return mPrice;
    }

    @Override
    public int getDiscount() {
        return mDiscount;
    }

    @Override
    public String getImage() {
        return mImage;
    }

    @Override
    public int getCategory() {
        return mCategory;
    }

    @Override
    public Date getFromDate() {
        return mFromDate;
    }

    @Override
    public Date getSinceDate() {
        return mSinceDate;
    }

    @Override
    public Seller getSeller() {
        return mSeller;
    }

}
