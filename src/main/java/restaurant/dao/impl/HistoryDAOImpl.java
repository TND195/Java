/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import restaurant.dao.HistoryDAO;
import restaurant.dao.OrderDAO;
import restaurant.dao.OrderDetailDAO;
import restaurant.model.HistoryInfo;
import restaurant.model.OrderBillInfo;
import restaurant.model.OrderDetailInfo;

/**
 *
 * @author Admin
 */
public class HistoryDAOImpl implements HistoryDAO{

    @Autowired
    OrderDetailDAO orderDetailDAO;
    @Autowired 
    OrderDAO orderDAO;
    public List<HistoryInfo> getListHistory(List<Integer> ids) {
       List<HistoryInfo> list = new ArrayList<HistoryInfo>();
       if (ids.size() !=0) {
       for(int i=0;i<ids.size();i++) {
           
           List<OrderDetailInfo> listo = orderDetailDAO.getlist(ids.get(i));
           OrderBillInfo orderBillInfo = orderDAO.getOrderInfo(ids.get(i));
           HistoryInfo historyInfo = new HistoryInfo(listo, ids.get(i),orderBillInfo.getCreated_at(),orderBillInfo.getStatus(),orderBillInfo.getSum_money());
           list.add(historyInfo);
       }
       return list;
       }
       return null;
    }
    
}
