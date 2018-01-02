/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.model;

import java.util.List;

/**
 *
 * @author Admin
 */
public class HistoryInfo {
    private List<OrderDetailInfo> orderDetailInfos;
    private int id;

    public HistoryInfo(List<OrderDetailInfo> orderDetailInfos, int id) {
        this.orderDetailInfos = orderDetailInfos;
        this.id = id;
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
    
}
