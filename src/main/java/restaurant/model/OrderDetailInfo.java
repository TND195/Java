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
     private String dish_name;
    private String dish_img_url;
    private double dish_price;
    private String dish_description;

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getDish_img_url() {
        return dish_img_url;
    }

    public void setDish_img_url(String dish_img_url) {
        this.dish_img_url = dish_img_url;
    }

    public double getDish_price() {
        return dish_price;
    }

    public void setDish_price(double dish_price) {
        this.dish_price = dish_price;
    }

    public String getDish_description() {
        return dish_description;
    }

    public void setDish_description(String dish_description) {
        this.dish_description = dish_description;
    }

    public OrderDetailInfo( int dish_id, int quantity, double price, Date created_at) {
        this.dish_id = dish_id;
        this.quantity = quantity;
        this.price = price;
        this.created_at = created_at;
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
