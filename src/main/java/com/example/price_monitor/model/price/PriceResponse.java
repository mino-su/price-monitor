package com.example.price_monitor.model.price;

import com.example.price_monitor.model.coinbase.SpotPriceResponse;

public record PriceResponse(Double amount, String base, String currency) {
    public static PriceResponse from(SpotPriceResponse spotPriceResponse) {
        var amount = Double.parseDouble(spotPriceResponse.data().amount());
        var base = spotPriceResponse.data().base();
        var currency = spotPriceResponse.data().currency();

        return new PriceResponse(amount, base, currency);
    }
}
