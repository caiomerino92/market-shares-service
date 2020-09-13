package com.market.shares.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "T_SHARE")
public class Share {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String ticket;

    private String ticketAcronym;

    private Double price;

    private Double priceToEarnings;

    private Double dividendYield;

    private Double pricePerBookValue;

    private Double roe;

    private Double dailyLiquidity;
}
