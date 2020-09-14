package com.market.shares.mock;

import com.market.shares.model.response.SharePurchaseResponse;

import java.math.BigDecimal;

public class SharePurchaseMock {

    private static final BigDecimal PRICE = new BigDecimal("32.03");
    private static final int QUANTITY = 200;

    public static SharePurchaseResponse getSharePurchaseResponse() {
        return new SharePurchaseResponse()
                .setTicketAcronym("BBAS3")
                .setQuantity(QUANTITY)
                .setPrice(PRICE)
                .setResult(PRICE.multiply(new BigDecimal(QUANTITY)));
    }
}
