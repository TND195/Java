/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HistoryInfo {
    private List<OrderDetailInfo> orderDetailInfos;
    private int id;
    private Date create_at;
    private int status;
    private double amount;
    

    public HistoryInfo(List<OrderDetailInfo> orderDetailInfos, int id, Date create_at,int status,double amount) {
        this.orderDetailInfos = orderDetailInfos;
        this.id = id;
        this.create_at = create_at;
        this.status = status;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    

 

    public List<OrderDetailInfo> getOrderDetailInfos() {
        return orderDetailInfos;
    }

    public void setOrderDetailInfos(List<OrderDetailInfo> orderDetailInfos) {
        this.orderDetailInfos = orderDetailInfos;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }
    
}
