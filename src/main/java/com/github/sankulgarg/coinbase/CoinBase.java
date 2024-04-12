package com.github.sankulgarg.coinbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CoinBase {


	double maxVal = 0;
	Set<String> path;

	void dfs(String curr, Map<String, List<Ticker>> graph, double currAmount, String target, Set<String> visited) {

		if (curr.equals(target)) {
			if (currAmount > maxVal) {
				maxVal = currAmount;
				path = new LinkedHashSet<>();
				path.addAll(visited);
			}
			return;
		}

		if (graph.get(curr) != null && !graph.get(curr).isEmpty()) {

			for (Ticker ticker : graph.get(curr)) {
				if (!visited.contains(ticker.curr)) {
					visited.add(ticker.curr);
					dfs(ticker.curr, graph, currAmount * ticker.w, target, visited);
					visited.remove(ticker.curr);
				}
			}
		}

	}

	double getMaxExchangeValue(String baseCurrency, double baseAmount, Map<String, List<Ticker>> graph, String target) {
		maxVal = 0.0d;
		path = new LinkedHashSet<>();
		path.add(baseCurrency);
		dfs(baseCurrency, graph, baseAmount, target, path);
		System.out.println(path);
		return maxVal;

	}

	public static void main(String[] args) throws IOException, InterruptedException {

		Map<String,Map<String,Double> > graph = new HashMap<>();

		graph.put("BTC", new HashMap<>());
		/*
		 * Map<String, List<Ticker>> graph = new HashMap<>();
		 * 
		 * List<Ticker> tickers = new ArrayList<>(); graph.put("BTC", tickers);
		 * tickers.add(new Ticker(10000d, "USD")); tickers.add(new Ticker(9500d,
		 * "EUR"));
		 * 
		 * tickers = Arrays.asList(new Ticker(1 / 10000d, "BTC"), new Ticker(1 / 200d,
		 * "ETH"), new Ticker(.90, "EUR")); graph.put("USD", tickers);
		 * 
		 * tickers = Arrays.asList(new Ticker(1 / 9500d, "BTC"), new Ticker(1 / 180d,
		 * "ETH"), new Ticker(1 / .90d, "USD")); graph.put("EUR", tickers);
		 * 
		 * tickers = Arrays.asList(new Ticker(200, "USD"), new Ticker(180, "EUR"));
		 * graph.put("ETH", tickers);
		 */

		
		TickersHelper helper =new TickersHelper();
		System.out.println(new CoinBase().getMaxExchangeValue("USD", 100, helper.buildGraph(), "EUR"));
	}

	/*
	 * tickers = { 'BTC-USD': 10000.0, 'BTC-EUR': 9500.0, 'ETH-USD': 200.0,
	 * 'ETH-EUR': 180.0 }
	 */

}
