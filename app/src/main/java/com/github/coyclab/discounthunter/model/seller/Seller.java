package com.github.coyclab.discounthunter.model.seller;

import com.github.coyclab.discounthunter.model.shop.Shop;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Seller implements ISeller {

    private static final String SELLER_NAME = "seller_name";
    private static final String SELLER_LOGO = "seller_logo";
    private static final String SHOP_LIST = "shop_list";


    @SerializedName(SELLER_NAME)
    private String mName;

    @SerializedName(SHOP_LIST)
    private List<Shop> mShopList;

    @SerializedName(SELLER_LOGO)
    private String mSellerLogo;

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public List<Shop> getShopList() {
        return mShopList;
    }

    @Override
    public String getSellerLogo() {
        return mSellerLogo;
    }
}
