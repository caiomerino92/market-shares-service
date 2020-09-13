package com.market.shares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.market.shares", exclude = { SecurityAutoConfiguration.class })
public class MarketSharesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketSharesServiceApplication.class, args);
	}

}
