package com.market.shares.service;

import com.market.shares.model.entity.Share;
import com.market.shares.model.request.ShareRequest;
import com.market.shares.model.response.SharePurchaseResponse;
import com.market.shares.model.response.ShareResponse;
import com.market.shares.parser.ShareParser;
import com.market.shares.repository.IShareRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class ShareService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShareService.class);

    private final IShareRepository shareRepository;

    @Autowired
    public ShareService (IShareRepository shareRepository) {
        this.shareRepository = shareRepository;
    }

    public ShareResponse save(ShareRequest shareRequest) {
        LOGGER.debug("ShareService.save ticket={}", shareRequest.getTicketAcronym());

        Share share = ShareParser.parse(shareRequest);
        return ShareParser.parse(shareRepository.save(share));
    }

    public List<ShareResponse> findAll() {
        LOGGER.debug("ShareService.findAll");

        return shareRepository.findAll()
                .stream()
                .map(ShareParser::parse)
                .collect(Collectors.toList());
    }

    public SharePurchaseResponse purchase(int quantity, String ticketAcronym) {
        LOGGER.debug("ShareService.buy quantity={}, ticketAcronym={}", quantity, ticketAcronym);

        Share found = shareRepository.findByTicketAcronym(ticketAcronym);
        BigDecimal result = (found.getPrice().multiply(new BigDecimal(quantity)));

        LOGGER.debug("ShareService.buy result={}", result);

        return new SharePurchaseResponse()
                .setTicketAcronym(found.getTicketAcronym())
                .setQuantity(quantity)
                .setPrice(found.getPrice())
                .setResult(result);
    }
}
