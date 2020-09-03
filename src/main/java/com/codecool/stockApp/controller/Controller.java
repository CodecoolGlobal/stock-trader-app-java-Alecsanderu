package com.codecool.stockApp.controller;


import com.codecool.stockApp.util.Trader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Controller {

	private Trader trader;

	public Controller(Trader trader) {
		this.trader = trader;
	}

	@GetMapping("buy/{stock}/{price}")
	public boolean buyStocks(@PathVariable("stock") String stock, @PathVariable("price") Long price) throws IOException {
		return trader.buy(stock, price);
	}
}
