package com.market.shares.parser;

import com.market.shares.model.entity.Share;
import com.market.shares.model.request.ShareRequest;
import com.market.shares.model.response.ShareResponse;

public class ShareParser {

    public static Share parse(ShareRequest shareRequest) {
        return Share.builder()
                .id(shareRequest.getId())
                .ticket(shareRequest.getTicket())
                .ticketAcronym(shareRequest.getTicketAcronym())
                .price(shareRequest.getPrice())
                .priceToEarnings(shareRequest.getPriceToEarnings())
                .dividendYield(shareRequest.getDividendYield())
                .pricePerBookValue(shareRequest.getPricePerBookValue())
                .roe(shareRequest.getRoe())
                .dailyLiquidity(shareRequest.getDailyLiquidity())
                .build();
    }

    public static ShareResponse parse(Share share) {
        return ShareResponse.builder()
                .id(share.getId())
                .ticket(share.getTicket())
                .ticketAcronym(share.getTicketAcronym())
                .price(share.getPrice())
                .priceToEarnings(share.getPriceToEarnings())
                .dividendYield(share.getDividendYield())
                .pricePerBookValue(share.getPricePerBookValue())
                .roe(share.getRoe())
                .dailyLiquidity(share.getDailyLiquidity())
                .build();
    }
}
