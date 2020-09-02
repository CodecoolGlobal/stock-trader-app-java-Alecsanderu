package com.codecool.stockApp;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


// TODO
class StockAPIServiceTest {

    @Test // everything works
    void testGetPriceNormalValues() throws IOException {
        RemoteURLReader reader = mock(RemoteURLReader.class);
        StockAPIService service = new StockAPIService();
        service.setReader(reader);
        when(reader.readFromUrl("https://run.mocky.io/v3/9e14e086-84c2-4f98-9e36-54928830c980?stock=$")).thenReturn("{'symobl': '$', 'price': 100.00}");
        assertEquals(100.00, service.getPrice("$"));
    }

    @Test // readFromURL threw an exception
    void testGetPriceServerDown() throws IOException {
        RemoteURLReader reader  = mock(RemoteURLReader.class);
        StockAPIService service = new StockAPIService();
        service.setReader(reader);
        when(reader.readFromUrl("https://run.mocky.io/v3/9e14e086-84c2-4f98-9e36-54928830c980?stock=abc")).thenThrow(IOException.class);
        assertThrows(IOException.class, () -> service.getPrice("abc"));
    }

    @Test // readFromURL returned wrong JSON
    void testGetPriceMalformedResponse() throws IOException {
    RemoteURLReader reader  = mock(RemoteURLReader.class);
    StockAPIService service = new StockAPIService();
    service.setReader(reader);
    when(reader.readFromUrl("https://run.mocky.io/v3/9e14e086-84c2-4f98-9e36-54928830c980?stock=abc")).thenReturn("");
    assertThrows(JSONException.class, () -> service.getPrice("abc"));
    }

}