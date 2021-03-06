/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.model;

import restaurant.entity.Dish;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class DishInfo {

    private int id;
    private String name;
    private String img_url;
    private Date created_at;
    private double price;
    private String description;
    
    public DishInfo() {
    }

    public DishInfo(int id, String name, String img_url, Date created_at, double price,String description) {
        this.id = id;
        this.name = name;
        this.img_url = img_url;
        this.created_at = created_at;
        this.price = price;
        this.description = description;
    }

    public DishInfo(Dish dish) {
        this.id = dish.getId();
        this.name = dish.getName();
        this.img_url = dish.getImg_url();
        this.created_at = dish.getCreated_at();
        this.price = dish.getPrice();
        this.description = dish.getDescription();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
