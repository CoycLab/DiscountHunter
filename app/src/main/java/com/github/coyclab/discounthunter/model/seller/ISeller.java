package com.github.coyclab.discounthunter.model.seller;

import com.github.coyclab.discounthunter.model.shop.Shop;

import java.util.List;

public interface ISeller {

    String getName();

    List<Shop> getShopList();
}
