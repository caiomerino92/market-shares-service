package com.market.shares.controller;

import com.market.shares.model.request.ShareRequest;
import com.market.shares.model.response.SharePurchaseResponse;
import com.market.shares.model.response.ShareResponse;
import com.market.shares.service.ShareService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/share")
public class ShareController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShareController.class);

    private final ShareService shareService;

    @Autowired
    public ShareController(ShareService shareService) {
        this.shareService = shareService;
    }

    @PostMapping("/v1")
    @ResponseStatus(HttpStatus.CREATED)
    public ShareResponse save(@RequestBody ShareRequest shareRequest) {
        LOGGER.debug("ShareController.save ticket name={}", shareRequest.getTicketAcronym());

        ShareResponse response = shareService.save(shareRequest);

        LOGGER.debug("ShareController.save request id = {}", response.getId());
        return response;
    }

    @GetMapping("/v1")
    public List<ShareResponse> findAll() {
        LOGGER.debug("ShareController.findAll");

        return shareService.findAll();
    }

    @PostMapping("/v1/purchase")
    public SharePurchaseResponse purchase(@RequestParam int quantity, @RequestParam String ticketAcronym) {
        LOGGER.debug("ShareController.purchase quantity={}, ticketAcronym={}", quantity, ticketAcronym);

        return shareService.purchase(quantity, ticketAcronym);
    }
}
