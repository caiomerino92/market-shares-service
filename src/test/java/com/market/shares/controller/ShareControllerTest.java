package com.market.shares.controller;

import com.google.gson.Gson;
import com.market.shares.MarketSharesServiceApplication;
import com.market.shares.config.CustomTest;
import com.market.shares.mock.ShareResquestMock;
import com.market.shares.model.request.ShareRequest;
import com.market.shares.model.response.ShareResponse;
import com.market.shares.service.ShareService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MarketSharesServiceApplication.class)
@Transactional
public class ShareControllerTest extends CustomTest {

    private static final String SHARE_RELATIVE_URL = "/api/share/v1";

    @MockBean
    private ShareService shareService;

    @Test
    public void save() throws Exception {
        ShareRequest mockRequest = ShareResquestMock.getShareRequest();
        String mockRequestJson = new Gson().toJson(mockRequest);

        when(shareService.save(any())).thenReturn(ShareResquestMock.getShareResponse());

        MockHttpServletResponse result = mockMvc.perform(post(SHARE_RELATIVE_URL)
                .contentType(APPLICATION_JSON)
                .content(mockRequestJson)).andReturn().getResponse();

        assertThat(result).isNotNull();

        assertThat(result.getStatus()).isNotNull();
        assertThat(result.getStatus()).isEqualTo(201);
    }
}
