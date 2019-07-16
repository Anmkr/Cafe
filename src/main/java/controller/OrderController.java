package controller;

import model.Order;

import java.util.ArrayList;
import java.util.List;


public class OrderController {

    private List<Order> orders = new ArrayList<Order>();

    public void add(Order order) {
        orders.add(order);
    }

    public void printOrders() {
        for (Order order : orders) {
            System.out.println(order);

        }
    }

    public Order getOrderByTable(String name) {
        for (Order order : orders) {
            if (order.getName().equals(name)) {
                return order;
            }
        }
        return null;
    }
}








