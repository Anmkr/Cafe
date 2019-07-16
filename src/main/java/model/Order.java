package model;

public class Order {

    public String name;
    public double cost;

    public Order(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public Order() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}




