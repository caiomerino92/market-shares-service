package com.market.shares.model.response;

import java.math.BigDecimal;

public class ShareResponse {

    private Long id;

    private String ticket;

    private String ticketAcronym;

    private BigDecimal price;

    private BigDecimal priceToEarnings;

    private BigDecimal dividendYield;

    private BigDecimal pricePerBookValue;

    private BigDecimal roe;

    private BigDecimal dailyLiquidity;

    public Long getId() {
        return id;
    }

    public ShareResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTicket() {
        return ticket;
    }

    public ShareResponse setTicket(String ticket) {
        this.ticket = ticket;
        return this;
    }

    public String getTicketAcronym() {
        return ticketAcronym;
    }

    public ShareResponse setTicketAcronym(String ticketAcronym) {
        this.ticketAcronym = ticketAcronym;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ShareResponse setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getPriceToEarnings() {
        return priceToEarnings;
    }

    public ShareResponse setPriceToEarnings(BigDecimal priceToEarnings) {
        this.priceToEarnings = priceToEarnings;
        return this;
    }

    public BigDecimal getDividendYield() {
        return dividendYield;
    }

    public ShareResponse setDividendYield(BigDecimal dividendYield) {
        this.dividendYield = dividendYield;
        return this;
    }

    public BigDecimal getPricePerBookValue() {
        return pricePerBookValue;
    }

    public ShareResponse setPricePerBookValue(BigDecimal pricePerBookValue) {
        this.pricePerBookValue = pricePerBookValue;
        return this;
    }

    public BigDecimal getRoe() {
        return roe;
    }

    public ShareResponse setRoe(BigDecimal roe) {
        this.roe = roe;
        return this;
    }

    public BigDecimal getDailyLiquidity() {
        return dailyLiquidity;
    }

    public ShareResponse setDailyLiquidity(BigDecimal dailyLiquidity) {
        this.dailyLiquidity = dailyLiquidity;
        return this;
    }
}
