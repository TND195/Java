/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class OrderDetailInfo implements Comparable<OrderDetailInfo>{

    private int id;
    private int dish_id;
    private int quantity;
    private double price;
    private Date created_at;


    public OrderDetailInfo( int dish_id, int quantity, double price) {
        this.dish_id = dish_id;
        this.quantity = quantity;
        this.price = price;

    }

    public OrderDetailInfo(int dish_id, int quantity) {
        this.dish_id = dish_id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getDish_id() {
        return dish_id;
    }

    public int getQuantity() {
        return quantity;
    }

 

    public double getPrice() {
        return price;
    }

    public Date getCreated_at() {
        return created_at;
    }

  

    public void setId(int id) {
        this.id = id;
    }

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public int compareTo(OrderDetailInfo o) {
         int compareQuantity = ((OrderDetailInfo) o).getQuantity();

        return compareQuantity - this.quantity;
    }

}
