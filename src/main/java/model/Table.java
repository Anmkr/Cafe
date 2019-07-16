package model;

import java.util.ArrayList;

public class Table {
    private String name;
    private ArrayList<Order> order;


    public Table(String name, ArrayList<Order> order) {
        this.name = name;
       this.order = order;
    }
    public Table(){}

    public String  getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Order> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Order> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Table{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}
