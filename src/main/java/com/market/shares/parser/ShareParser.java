package com.market.shares.parser;

import com.market.shares.model.entity.Share;
import com.market.shares.model.request.ShareRequest;
import com.market.shares.model.response.ShareResponse;

public class ShareParser {

    public static Share parse(ShareRequest shareRequest) {
        return new Share()
                .setId(shareRequest.getId())
                .setTicket(shareRequest.getTicket())
                .setTicketAcronym(shareRequest.getTicketAcronym())
                .setPrice(shareRequest.getPrice())
                .setPriceToEarnings(shareRequest.getPriceToEarnings())
                .setDividendYield(shareRequest.getDividendYield())
                .setPricePerBookValue(shareRequest.getPricePerBookValue())
                .setRoe(shareRequest.getRoe())
                .setDailyLiquidity(shareRequest.getDailyLiquidity());
    }

    public static ShareResponse parse(Share share) {
        return new ShareResponse()
                .setId(share.getId())
                .setTicket(share.getTicket())
                .setTicketAcronym(share.getTicketAcronym())
                .setPrice(share.getPrice())
                .setPriceToEarnings(share.getPriceToEarnings())
                .setDividendYield(share.getDividendYield())
                .setPricePerBookValue(share.getPricePerBookValue())
                .setRoe(share.getRoe())
                .setDailyLiquidity(share.getDailyLiquidity());
    }
}
