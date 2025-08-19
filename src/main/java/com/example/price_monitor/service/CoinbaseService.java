package com.example.price_monitor.service;

import com.example.price_monitor.model.coinbase.SpotPriceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class CoinbaseService {
    private static final RestClient restClient = RestClient.create();

    public SpotPriceResponse getSpotPriceByCurrentPair(String currentPair) {
        return restClient
                .get()
                .uri("https://api.coinbase.com/v2/prices/{currentPair}/spot",currentPair)
                .retrieve()
                .body(SpotPriceResponse.class);
    }
}
