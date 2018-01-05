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
    

    public HistoryInfo(List<OrderDetailInfo> orderDetailInfos, int id, Date create_at) {
        this.orderDetailInfos = orderDetailInfos;
        this.id = id;
        this.create_at = create_at;
    }

    public List<OrderDetailInfo> getOrderDetailInfos() {
        return orderDetailInfos;
    }

    public void setOrderDetailInfos(List<OrderDetailInfo> orderDetailInfos) {
        this.orderDetailInfos = orderDetailInfos;
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
