package model;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private String name;
    private String ID;
    private List<Order> orderListOfStudent=new ArrayList<>();

    public Card() {
    }

    public Card(String name, String ID, List<Order> orderList) {
        this.name = name;
        this.ID = ID;
        this.orderListOfStudent = orderList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public List<Order> getOrderList() {
        return orderListOfStudent;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderListOfStudent = orderList;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                ", orderList=" + orderListOfStudent +
                '}';
    }
}
