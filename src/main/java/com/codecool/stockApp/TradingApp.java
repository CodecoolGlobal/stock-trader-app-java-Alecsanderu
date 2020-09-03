package com.codecool.stockApp;

import com.codecool.stockApp.service.StockAPIService;
import com.codecool.stockApp.util.Logger;
import com.codecool.stockApp.util.Trader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Provides a command line interface for stock trading.
 **/
@SpringBootApplication
@Component
public class TradingApp {
//	private Trader trader;
//	private Logger logger;

	StockAPIService service = new StockAPIService();


	public static void main(String[] args) {
		SpringApplication.run(TradingApp.class, args);
	}


//	@PostConstruct
//	void afterInit() {
//		TradingApp app = new TradingApp(trader, logger);
//		app.start(trader);
//	}
//
//	public TradingApp(Trader trader, Logger logger) {
//		this.trader = trader;
//		this.logger = logger;
//	}
//
//	public void start(Trader trader) {
//		Scanner keyboard = new Scanner(System.in);
//		System.out.println("Enter a stock symbol (for example aapl):");
//		String symbol = keyboard.nextLine();
//		System.out.println("Enter the maximum price you are willing to pay: ");
//		double price;
//		try {
//			price = keyboard.nextDouble();
//		} catch (InputMismatchException e) {
//			System.out.println("Invalid input. Enter a number");
//			return;
//		}
//
//		try {
//			boolean purchased = trader.buy(symbol, price);
//			if (purchased) {
//				logger.log("Purchased stock!");
//			}
//			else {
//				logger.log("Couldn't buy the stock at that price.");
//			}
//		} catch (Exception e) {
//			logger.log("There was an error while attempting to buy the stock: " + e.getMessage());
//		}
//	}
}