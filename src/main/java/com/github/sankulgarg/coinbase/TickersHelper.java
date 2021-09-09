package com.github.sankulgarg.coinbase;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class TickersHelper {

	RestTemplate restTemplate = new RestTemplate();
	private static String PRODUCT_URL = "https://api.pro.coinbase.com/products";
	private static String TICKER_URL = "https://api.pro.coinbase.com/products/";

	ProductDTO[] fetchAllTickersPair() throws IOException, InterruptedException {  
		return restTemplate.getForObject(URI.create(PRODUCT_URL), ProductDTO[].class);

	}

	Map<String, List<Ticker>> buildGraph() throws IOException, InterruptedException {
		ProductDTO[] productResponse = fetchAllTickersPair();
		Map<String, List<Ticker>> graph= new HashMap<>();
		for(ProductDTO product: productResponse) {
			
			System.out.println("calling pair: "+ product.getId());
			TickerDTO tickerDTO = restTemplate.getForObject(URI.create(TICKER_URL)+product.getId()+"/ticker", TickerDTO.class);
			String[] products = product.getId().split("-");
			
			graph.computeIfAbsent(products[0], l-> new ArrayList<>());
			graph.computeIfAbsent(products[1], l-> new ArrayList<>());
			
			graph.get(products[0]).add(new Ticker(Double.valueOf(tickerDTO.ask), products[1]));
			graph.get(products[1]).add(new Ticker(Double.valueOf(tickerDTO.getBid()), products[0]));
			
			
		}
		return graph;
	}

}
