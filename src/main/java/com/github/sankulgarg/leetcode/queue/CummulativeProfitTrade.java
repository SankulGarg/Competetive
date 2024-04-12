package com.github.sankulgarg.leetcode.queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CummulativeProfitTrade {

    enum Type {
        BUY, SELL;
    }

    static class Trade {
        long timestamp;
        Type type;
        int quantity;
        int price;

        Trade(long timestamp, Type type, int price, int quantity) {
            this.timestamp = timestamp;
            this.type = type;
            this.quantity = quantity;
            this.price = price;
        }
    }

    public int maxProfit(List<Trade> trades) {
        PriorityQueue<Trade> tradePriorityQueue = new PriorityQueue<>(Comparator.comparingInt(t -> t.price));
        int maxProfit=0;
        for (Trade trade : trades) {
            if (trade.type == Type.BUY) {
                tradePriorityQueue.offer(trade);
            } else {
                while (!tradePriorityQueue.isEmpty() && trade.quantity > 0) {
                    if(tradePriorityQueue.peek().price>trade.price)
                        break;
                    Trade buyTrade = tradePriorityQueue.poll();
                    if (buyTrade.quantity > trade.quantity) {
                        buyTrade.quantity -= trade.quantity;
                        maxProfit += (trade.price - buyTrade.price) * trade.quantity;
                        trade.quantity = 0;
                        tradePriorityQueue.add(buyTrade);

                    } else {
                        trade.quantity -= buyTrade.quantity;
                        maxProfit += (trade.price - buyTrade.price) * buyTrade.quantity;
                    }
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        CummulativeProfitTrade cummulativeProfitTrade = new CummulativeProfitTrade();
        Trade tr1 = new Trade(1, Type.BUY, 20, 10);
        Trade tr2 = new Trade(2, Type.BUY, 40, 20);
        Trade tr3 = new Trade(3, Type.SELL, 42, 7);
        Trade tr4 = new Trade(4, Type.BUY, 40, 5);
        Trade tr5 = new Trade(5, Type.SELL, 3, 20);


        List<Trade> inputList = Arrays.asList(tr1, tr2, tr3, tr4, tr5);
        System.out.println(cummulativeProfitTrade.maxProfit(inputList)); // 20*7+2*5+2*3=154
    }

}
