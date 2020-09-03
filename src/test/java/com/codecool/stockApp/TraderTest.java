package com.codecool.stockApp;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

// TODO
class TraderTest {


    @Test // Bid was lower than price, buy should return false.
    void testBidLowerThanPrice() throws IOException {
        StockAPIService mockStockApiService = mock(StockAPIService.class);
        Trader trader = new Trader(mockStockApiService);
        when(mockStockApiService.getPrice("$")).thenReturn(100.00);
        assertFalse(trader.buy("$", 99));
    }

    @Test // bid was equal or higher than price, buy() should return true.
    void testBidHigherThanPrice() throws IOException {
        StockAPIService mockStockApiService = mock(StockAPIService.class);
        Trader trader = new Trader(mockStockApiService);
        when(mockStockApiService.getPrice("$")).thenReturn(100.00);
        assertTrue(trader.buy("$", 101));
    }
}