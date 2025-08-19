package com.example.price_monitor.controller;

import com.example.price_monitor.model.coinbase.SpotPriceResponse;
import com.example.price_monitor.model.price.PriceResponse;
import com.example.price_monitor.service.CoinbaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/prices")
public class PriceController {
    private final CoinbaseService coinbaseService;

    @GetMapping("/{currentPair}/market-price")
    public ResponseEntity<PriceResponse> getMarketPrice(@PathVariable String currentPair) {
        var spotPriceByCurrentPair = coinbaseService.getSpotPriceByCurrentPair(currentPair);
        return ResponseEntity.ok(PriceResponse.from(spotPriceByCurrentPair));
    }
}
