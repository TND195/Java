package restaurant.dao;

import java.util.List;
import restaurant.model.CartInfo;
import restaurant.model.OrderBillInfo;
import restaurant.model.OrderDetailInfo;
import restaurant.model.PaginationResult;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public interface OrderDAO {
     public int saveOrder(CartInfo cartInfo);
 
    public PaginationResult<OrderBillInfo> listOrderInfo(int page,
            int maxResult, int maxNavigationPage);
    
    public OrderBillInfo getOrderInfo(int orderId);
    
  
}
