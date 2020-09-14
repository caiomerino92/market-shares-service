package com.market.shares.service;

import com.market.shares.config.ServiceTest;
import com.market.shares.mock.ShareMock;
import com.market.shares.model.entity.Share;
import com.market.shares.model.request.ShareRequest;
import com.market.shares.model.response.SharePurchaseResponse;
import com.market.shares.model.response.ShareResponse;
import com.market.shares.parser.ShareParser;
import com.market.shares.repository.IShareRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShareServiceTest extends ServiceTest {

    @MockBean
    private IShareRepository shareRepository;

    @Autowired
    private ShareService shareService;

    @Test
    public void save() {
        Share mockResponse = ShareMock.getShare();
        Mockito.when(shareRepository.save(ArgumentMatchers.any())).thenReturn(mockResponse);

        ShareResponse response = shareService.save(ShareMock.getShareRequest());

        Assert.assertNotNull(response.getId());
        Assert.assertEquals(mockResponse.getId(), response.getId());

        Assert.assertNotNull(response.getTicket());
        Assert.assertEquals(mockResponse.getTicket(), response.getTicket());

        Assert.assertNotNull(response.getTicketAcronym());
        Assert.assertEquals(mockResponse.getTicketAcronym(), response.getTicketAcronym());

        Assert.assertNotNull(response.getPrice());
        Assert.assertEquals(mockResponse.getPrice(), response.getPrice());

        Assert.assertNotNull(response.getPriceToEarnings());
        Assert.assertEquals(mockResponse.getPriceToEarnings(), response.getPriceToEarnings());

        Assert.assertNotNull(response.getDividendYield());
        Assert.assertEquals(mockResponse.getDividendYield(), response.getDividendYield());

        Assert.assertNotNull(response.getPricePerBookValue());
        Assert.assertEquals(mockResponse.getPricePerBookValue(), response.getPricePerBookValue());

        Assert.assertNotNull(response.getRoe());
        Assert.assertEquals(mockResponse.getRoe(), response.getRoe());

        Assert.assertNotNull(response.getDailyLiquidity());
        Assert.assertEquals(mockResponse.getDailyLiquidity(), response.getDailyLiquidity());

    }

    @Test
    public void findAll() {
        List<Share> mockResponse = Collections.singletonList(ShareMock.getShare());
        Mockito.when(shareRepository.findAll()).thenReturn(mockResponse);

        List<ShareResponse> response = shareService.findAll();

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.size()).isEqualTo(mockResponse.size());
    }

    @Test
    public void purchase() {
        Share mockResponse = ShareMock.getShare();
        Mockito.when(shareRepository.findByTicketAcronym(ArgumentMatchers.anyString())).thenReturn(mockResponse);

        SharePurchaseResponse response = shareService.purchase(200, mockResponse.getTicketAcronym());

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getTicketAcronym()).isEqualTo(mockResponse.getTicketAcronym());
        Assertions.assertThat(response.getQuantity()).isEqualTo(200);
        Assertions.assertThat(response.getPrice()).isEqualTo(mockResponse.getPrice());
        Assertions.assertThat(response.getResult()).isEqualTo(mockResponse.getPrice().multiply(new BigDecimal(200)));
    }
}
