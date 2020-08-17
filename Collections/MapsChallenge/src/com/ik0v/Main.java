package com.ik0v;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
	    StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket timsBasket = new Basket("Tim");
        reserveItem(timsBasket, "car", 0); // trying to reserve with wrong amount

        reserveItem(timsBasket, "car", 2);

        reserveItem(timsBasket, "car", 1); // trying to reserve when stock is 0
        System.out.println(timsBasket);

        reserveItem(timsBasket, "spanner", 5); // trying with non-existing item

        reserveItem(timsBasket, "juice", 4);
        reserveItem(timsBasket, "cup", 12);
        unReserveItem(timsBasket, "cola", 10);
        unReserveItem(timsBasket, "cup", 10);
        unReserveItem(timsBasket, "cup", 10);
        reserveItem(timsBasket, "bread", 1);
        System.out.println(timsBasket);
        timsBasket.checkOut();
        System.out.println(timsBasket);

        System.out.println(stockList);

        for(Map.Entry<String, Double> price: stockList.PriceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }
    }

    public static int reserveItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.reserveStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }

    public static int unReserveItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("There is no " + item + " in " + basket.getName() + "s basket");
            return 0;
        } if (quantity <= 0) return 0;
        return (basket.removeFromBasket(stockItem, quantity));
    }

}
