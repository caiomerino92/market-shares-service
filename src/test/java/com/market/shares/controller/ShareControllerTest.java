package com.market.shares.controller;

import com.google.gson.Gson;
import com.market.shares.config.ControllerTest;
import com.market.shares.mock.ShareMock;
import com.market.shares.mock.SharePurchaseMock;
import com.market.shares.model.request.ShareRequest;
import com.market.shares.model.response.SharePurchaseResponse;
import com.market.shares.model.response.ShareResponse;
import com.market.shares.service.ShareService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class ShareControllerTest extends ControllerTest {

    private static final String SHARE_RELATIVE_URL = "/api/share/v1";

    @MockBean
    private ShareService shareService;

    @Test
    public void save() throws Exception {
        ShareRequest mockRequest = ShareMock.getShareRequest();
        String mockRequestJson = new Gson().toJson(mockRequest);
        ShareResponse mockShareResponse = ShareMock.getShareResponse();

        when(shareService.save(any())).thenReturn(mockShareResponse);

        MockHttpServletResponse result = mockMvc.perform(post(SHARE_RELATIVE_URL)
                .contentType(APPLICATION_JSON)
                .content(mockRequestJson)
        ).andReturn().getResponse();

        ShareResponse response = new Gson().fromJson(result.getContentAsString(), ShareResponse.class);

        assertThat(result).isNotNull();

        assertThat(result.getStatus()).isEqualTo(201);

        assertThat(response.getId()).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);

        assertThat(response.getTicket()).isNotNull();
        assertThat(response.getTicket()).isEqualTo(mockShareResponse.getTicket());

        assertThat(response.getTicketAcronym()).isNotNull();
        assertThat(response.getTicketAcronym()).isEqualTo(mockShareResponse.getTicketAcronym());

        assertThat(response.getPrice()).isNotNull();
        assertThat(response.getPrice()).isEqualTo(mockShareResponse.getPrice());

        assertThat(response.getPriceToEarnings()).isNotNull();
        assertThat(response.getPriceToEarnings()).isEqualTo(mockShareResponse.getPriceToEarnings());

        assertThat(response.getDividendYield()).isNotNull();
        assertThat(response.getDividendYield()).isEqualTo(mockShareResponse.getDividendYield());

        assertThat(response.getPricePerBookValue()).isNotNull();
        assertThat(response.getPricePerBookValue()).isEqualTo(mockShareResponse.getPricePerBookValue());

        assertThat(response.getRoe()).isNotNull();
        assertThat(response.getRoe()).isEqualTo(mockShareResponse.getRoe());

        assertThat(response.getDailyLiquidity()).isNotNull();
        assertThat(response.getDailyLiquidity()).isEqualTo(mockShareResponse.getDailyLiquidity());
    }

    @Test
    public void findAll() throws Exception {
        List<ShareResponse> mockResponse = Collections.singletonList(ShareMock.getShareResponse());

        when(shareService.findAll()).thenReturn(mockResponse);

        MockHttpServletResponse result = mockMvc.perform(get(SHARE_RELATIVE_URL)
                .contentType(APPLICATION_JSON)
        ).andReturn().getResponse();

        List<ShareResponse> response = Arrays.asList(new Gson().fromJson(result.getContentAsString(), ShareResponse[].class));

        Assert.assertEquals(200, result.getStatus());
        Assert.assertEquals(mockResponse.size(), response.size());
    }

    @Test
    public void purchase() throws Exception {
        SharePurchaseResponse mockSharePurchaseResponse = SharePurchaseMock.getSharePurchaseResponse();
        when(shareService.purchase(anyInt(), anyString())).thenReturn(mockSharePurchaseResponse);

        MockHttpServletResponse result = mockMvc.perform(post(SHARE_RELATIVE_URL + "/purchase")
                .contentType(APPLICATION_JSON)
                .param("quantity", "200")
                .param("ticketAcronym","BBAS3")
        ).andReturn().getResponse();

        SharePurchaseResponse sharePurchaseResponse = new Gson().fromJson(result.getContentAsString(), SharePurchaseResponse.class);

        assertThat(result.getStatus()).isEqualTo(200);

        assertThat(sharePurchaseResponse.getTicketAcronym()).isNotNull();
        assertThat(sharePurchaseResponse.getTicketAcronym()).isEqualTo(mockSharePurchaseResponse.getTicketAcronym());

        assertThat(sharePurchaseResponse.getQuantity()).isNotNull();
        assertThat(sharePurchaseResponse.getQuantity()).isEqualTo(mockSharePurchaseResponse.getQuantity());

        assertThat(sharePurchaseResponse.getPrice()).isNotNull();
        assertThat(sharePurchaseResponse.getPrice()).isEqualTo(mockSharePurchaseResponse.getPrice());

        assertThat(sharePurchaseResponse.getResult()).isNotNull();
        assertThat(sharePurchaseResponse.getResult()).isEqualTo(mockSharePurchaseResponse.getResult());
    }
}
