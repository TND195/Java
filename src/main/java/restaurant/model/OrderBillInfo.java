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
public class OrderBillInfo {
    
    private int id;
    private int customer_id;
    private int status;
    private int oder_type;
    private double sum_money;
    private Date created_at;  
    private int order_num;
    
    private List<OrderDetailInfo> details;

    public OrderBillInfo() {
    }

    public OrderBillInfo(int id, int customer_id, int status, int oder_type, double sum_money, Date created_at, int order_num, List<OrderDetailInfo> details) {
        this.id = id;
        this.customer_id = customer_id;
        this.status = status;
        this.oder_type = oder_type;
        this.sum_money = sum_money;
        this.created_at = created_at;
        this.order_num = order_num;
        this.details = details;
    }

    public int getOrder_num() {
        return order_num;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

   

    public int getId() {
        return id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public int getStatus() {
        return status;
    }

    public int getOder_type() {
        return oder_type;
    }

    public double getSum_money() {
        return sum_money;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public List<OrderDetailInfo> getDetails() {
        return details;
    }
    
}
