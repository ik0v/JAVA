package com.ik0v;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dev on 16/02/2016.
 */
public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if(item != null) {
            // check if already have quantities of this item
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // If there are already stocks on this item, adjust the quantity
            if(inStock != item) {
                item.adjustStock(inStock.quantityInStock());
            }

            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int reserveStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);
        if(inStock != null && quantity >0 && (inStock.getReserved()+quantity)
                <= inStock.quantityInStock()) {
            inStock.reserveItem(quantity);
            return quantity;
        } else {
            System.out.println("Wrong amount (" + quantity + ") of: " + inStock.getName()
                    + " to reserve, (" + (inStock.quantityInStock()-inStock.getReserved())
                    + ") in stock");
            return 0;
        }
    }

    public int unReserveStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);
        if(inStock != null && quantity <= inStock.getReserved()) {
            inStock.reserveItem(-quantity);
            return quantity;
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);

        if((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity >0)) {
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for(Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

            s = s + stockItem + ". QTY " + stockItem.quantityInStock()
                    + ". Reserved " + stockItem.getReserved() +". TotValue: ";
            s = s + String.format("%.2f",itemValue) + "\n";
            totalCost += itemValue;
        }
        s = s + "Total stock value " + String.format("%.2f", totalCost) + "\n";
        return s;
    }
}
