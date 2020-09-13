package com.market.shares.model.response;

import java.math.BigDecimal;

public class SharePurchaseResponse {

    private String ticketAcronym;
    private int quantity;
    private BigDecimal price;
    private BigDecimal result;

    public String getTicketAcronym() {
        return ticketAcronym;
    }

    public SharePurchaseResponse setTicketAcronym(String ticketAcronym) {
        this.ticketAcronym = ticketAcronym;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public SharePurchaseResponse setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public SharePurchaseResponse setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getResult() {
        return result;
    }

    public SharePurchaseResponse setResult(BigDecimal result) {
        this.result = result;
        return this;
    }
}
