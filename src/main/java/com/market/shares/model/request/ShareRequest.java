package com.market.shares.model.request;

import java.math.BigDecimal;

public class ShareRequest {

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

    public ShareRequest setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTicket() {
        return ticket;
    }

    public ShareRequest setTicket(String ticket) {
        this.ticket = ticket;
        return this;
    }

    public String getTicketAcronym() {
        return ticketAcronym;
    }

    public ShareRequest setTicketAcronym(String ticketAcronym) {
        this.ticketAcronym = ticketAcronym;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ShareRequest setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getPriceToEarnings() {
        return priceToEarnings;
    }

    public ShareRequest setPriceToEarnings(BigDecimal priceToEarnings) {
        this.priceToEarnings = priceToEarnings;
        return this;
    }

    public BigDecimal getDividendYield() {
        return dividendYield;
    }

    public ShareRequest setDividendYield(BigDecimal dividendYield) {
        this.dividendYield = dividendYield;
        return this;
    }

    public BigDecimal getPricePerBookValue() {
        return pricePerBookValue;
    }

    public ShareRequest setPricePerBookValue(BigDecimal pricePerBookValue) {
        this.pricePerBookValue = pricePerBookValue;
        return this;
    }

    public BigDecimal getRoe() {
        return roe;
    }

    public ShareRequest setRoe(BigDecimal roe) {
        this.roe = roe;
        return this;
    }

    public BigDecimal getDailyLiquidity() {
        return dailyLiquidity;
    }

    public ShareRequest setDailyLiquidity(BigDecimal dailyLiquidity) {
        this.dailyLiquidity = dailyLiquidity;
        return this;
    }
}
