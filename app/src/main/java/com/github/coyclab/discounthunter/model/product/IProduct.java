package com.github.coyclab.discounthunter.model.product;

import com.github.coyclab.discounthunter.model.seller.Seller;

import java.util.Date;

public interface IProduct {

    String getName();

    String getDescription();

    Double getPrice();

    int getDiscount();

    Date getFromDate();

    Date getSinceDate();

    Seller getSeller();
}
