/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "DISH")
public class Dish implements Serializable {

    private static final long serialVersionUID = -2576670215015463100L;
    private int id;
    private int dish_directory_id;
    private String name;
    private String img_url;
    private Date created_at;
    private double price;
    private int del_flag;
    private String description;
  
    

    @Id
    @Column(name = "id")
     @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

 

    @Column(name = "dish_directory_id", nullable = false)
    public int getDish_directory_id() {
        return dish_directory_id;
    }

    @Column(name = "name", nullable = false, length = 128)
    public String getName() {
        return name;
    }

    @Column(name = "img_url", nullable = false, length = 128)
    public String getImg_url() {
        return img_url;
    }

    @Column(name = "created_at", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getCreated_at() {
        return created_at;
    }

    @Column(name = "price", nullable = false)
    public double getPrice() {
        return price;
    }

    @Column(name = "del_flag", nullable = false)
    public int getDel_flag() {
        return del_flag;
    }
    @Column(name = "description", nullable = false, length = 128)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setDish_directory_id(int dish_directory_id) {
        this.dish_directory_id = dish_directory_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDel_flag(int del_flag) {
        this.del_flag = del_flag;
    }

}
