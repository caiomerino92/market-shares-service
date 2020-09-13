package com.market.shares.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShareRequest {

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
