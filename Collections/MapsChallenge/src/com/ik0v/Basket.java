package com.ik0v;

import java.util.*;

/**
 * Created by dev on 17/02/2016.
 */
public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if (quantity > 0) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public int removeFromBasket(StockItem item, int quantity) {
        if (quantity <= item.getReserved()) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket - quantity);
            item.reserveItem(-quantity);
            return quantity;
        }
        System.out.println("You can't remove " + quantity + " " + item.getName()
                + " from " + this.name + " basket. It contains (" + item.getReserved()  +")" );
        return 0;
    }

    public void checkOut() {
        for(StockItem item: list.keySet()) {
            item.adjustStock(-item.getReserved());
            item.reserveItem(-item.getReserved());
        }
        System.out.println(this.name + " made a purchase, basket is empty");
        list.clear();
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() + ((list.size() == 1) ? " item" : " items") + "\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }
}
