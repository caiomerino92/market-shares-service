package com.market.shares.model.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;


@Entity
@Table(name = "T_SHARE")
public class Share {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, precision = 10)
    private Long id;

    @Column(name = "DS_TICKET", unique = true)
    private String ticket;

    @Column(name = "DS_TICKET_ACRONYM", unique = true)
    private String ticketAcronym;

    @Column(name = "NR_PRICE")
    private BigDecimal price;

    @Column(name = "NR_PRICE_TO_EARNINGS")
    private BigDecimal priceToEarnings;

    @Column(name = "NR_DIVIDEND_YIELD")
    private BigDecimal dividendYield;

    @Column(name = "NR_PRICE_PER_BOOK_Value")
    private BigDecimal pricePerBookValue;

    @Column(name = "NR_ROE")
    private BigDecimal roe;

    @Column(name = "NR_DAILY_LIQUIDITY")
    private BigDecimal dailyLiquidity;

    public Long getId() {
        return id;
    }

    public Share setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTicket() {
        return ticket;
    }

    public Share setTicket(String ticket) {
        this.ticket = ticket;
        return this;
    }

    public String getTicketAcronym() {
        return ticketAcronym;
    }

    public Share setTicketAcronym(String ticketAcronym) {
        this.ticketAcronym = ticketAcronym;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Share setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getPriceToEarnings() {
        return priceToEarnings;
    }

    public Share setPriceToEarnings(BigDecimal priceToEarnings) {
        this.priceToEarnings = priceToEarnings;
        return this;
    }

    public BigDecimal getDividendYield() {
        return dividendYield;
    }

    public Share setDividendYield(BigDecimal dividendYield) {
        this.dividendYield = dividendYield;
        return this;
    }

    public BigDecimal getPricePerBookValue() {
        return pricePerBookValue;
    }

    public Share setPricePerBookValue(BigDecimal pricePerBookValue) {
        this.pricePerBookValue = pricePerBookValue;
        return this;
    }

    public BigDecimal getRoe() {
        return roe;
    }

    public Share setRoe(BigDecimal roe) {
        this.roe = roe;
        return this;
    }

    public BigDecimal getDailyLiquidity() {
        return dailyLiquidity;
    }

    public Share setDailyLiquidity(BigDecimal dailyLiquidity) {
        this.dailyLiquidity = dailyLiquidity;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Share share = (Share) o;
        return Objects.equals(id, share.id) &&
                Objects.equals(ticket, share.ticket) &&
                Objects.equals(ticketAcronym, share.ticketAcronym) &&
                Objects.equals(price, share.price) &&
                Objects.equals(priceToEarnings, share.priceToEarnings) &&
                Objects.equals(dividendYield, share.dividendYield) &&
                Objects.equals(pricePerBookValue, share.pricePerBookValue) &&
                Objects.equals(roe, share.roe) &&
                Objects.equals(dailyLiquidity, share.dailyLiquidity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticket, ticketAcronym, price, priceToEarnings, dividendYield, pricePerBookValue, roe, dailyLiquidity);
    }

    @Override
    public String toString() {
        return "Share{" +
                "id=" + id +
                ", ticket='" + ticket + '\'' +
                ", ticketAcronym='" + ticketAcronym + '\'' +
                ", price=" + price +
                ", priceToEarnings=" + priceToEarnings +
                ", dividendYield=" + dividendYield +
                ", pricePerBookValue=" + pricePerBookValue +
                ", roe=" + roe +
                ", dailyLiquidity=" + dailyLiquidity +
                '}';
    }
}
