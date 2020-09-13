package com.market.shares.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShareResponse {

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
