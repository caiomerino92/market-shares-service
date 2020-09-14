package com.market.shares.mock;

import com.market.shares.model.request.ShareRequest;
import com.market.shares.model.response.ShareResponse;

import java.math.BigDecimal;

public class ShareResquestMock {

    public static ShareRequest getShareRequest() {
        return new ShareRequest()
                .setTicket("Banco do Brasil")
                .setTicketAcronym("BBAS")
                .setPrice(new BigDecimal("32.03"))
                .setPriceToEarnings(new BigDecimal("5.36"))
                .setDividendYield(new BigDecimal("5.33"))
                .setPricePerBookValue(new BigDecimal("0.87"))
                .setRoe(new BigDecimal("16.30"))
                .setDailyLiquidity(new BigDecimal("522985170.14"));
    }

    public static ShareResponse getShareResponse() {
        return new ShareResponse()
                .setId(1L)
                .setTicket("Banco do Brasil")
                .setTicketAcronym("BBAS")
                .setPrice(new BigDecimal("32.03"))
                .setPriceToEarnings(new BigDecimal("5.36"))
                .setDividendYield(new BigDecimal("5.33"))
                .setPricePerBookValue(new BigDecimal("0.87"))
                .setRoe(new BigDecimal("16.30"))
                .setDailyLiquidity(new BigDecimal("522985170.14"));
    }
}
