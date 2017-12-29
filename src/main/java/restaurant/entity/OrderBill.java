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

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "order_bill")
public class OrderBill implements Serializable {

    private static final long serialVersionUID = -2576670215015463100L;
    private int id;
    private int customer_id;
    private int branch_id;
    private int status;
    private int order_type;
    private double sum_money;
    private Date created_at;
    private int del_flag;
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    @Column(name = "customer_id", nullable = false)
    public int getCustomer_id() {
        return customer_id;
    }

    @Column(name = "branch_id", nullable = false)
    public int getBranch_id() {
        return branch_id;
    }

    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    @Column(name = "order_type", nullable = false)
    public int getOrder_type() {
        return order_type;
    }

    @Column(name = "sum_money", nullable = false)
    public double getSum_money() {
        return sum_money;
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

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setOrder_type(int order_type) {
        this.order_type = order_type;
    }

    public void setSum_money(double sum_money) {
        this.sum_money = sum_money;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setDel_flag(int del_flag) {
        this.del_flag = del_flag;
    }

}
