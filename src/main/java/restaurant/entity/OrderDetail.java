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
@Table(name = "order_detail")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = -2576670215015463100L;
    private int id;
    private int order_id;
    private int dish_id;
    private int quantity;
    private double price;
    private Date created_at;
    private int del_flag;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    @Column(name = "order_id", nullable = false)
    public int getOrder_id() {
        return order_id;
    }

    @Column(name = "dish_id", nullable = false)
    public int getDish_id() {
        return dish_id;
    }

    @Column(name = "quanlity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    @Column(name = "price", nullable = false)
    public double getPrice() {
        return price;
    }

    @Column(name = "created_at", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getCreated_at() {
        return created_at;
    }

    @Column(name = "del_flag", nullable = false)
    public int getDel_flag() {
        return del_flag;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

    public void setDel_flag(int del_flag) {
        this.del_flag = del_flag;
    }

}
