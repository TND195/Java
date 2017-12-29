/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.dao.impl;

import restaurant.dao.DishDAO;
import restaurant.dao.OrderDAO;
import restaurant.entity.OrderBill;
import restaurant.entity.OrderDetail;
import java.util.Date;
import java.util.List;
import restaurant.model.CartInfo;
import restaurant.model.CartLineInfo;
import restaurant.model.CustomerInfo;
import restaurant.model.OrderBillInfo;
import restaurant.model.PaginationResult;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import restaurant.entity.Customer;


/**
 *
 * @author Admin
 */
public class OrderDAOImpl implements OrderDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
   
    
    @Override
    public void saveOrder(CartInfo cartInfo) {
        Session session = sessionFactory.getCurrentSession();
        
        OrderBill order = new OrderBill();
        
        order.setCreated_at(new Date());
        order.setSum_money(cartInfo.getAmountTotal());
        
        CustomerInfo customerInfo = cartInfo.getCustomerInfo();
        Customer customer = new Customer();
        customer.setAddress(customerInfo.getAddress());
        customer.setCreated_at(new Date());
        customer.setDel_flag(0);
        customer.setName(customerInfo.getName());
        customer.setPhone(customerInfo.getPhone());
        session.save(customer);
        order.setCustomer_id(customer.getId());
        order.setBranch_id(0);
        order.setStatus(0);
        order.setOrder_type(3);
        order.setDel_flag(0);
        
        session.save(order);
        
        List<CartLineInfo> lines = cartInfo.getCartLines();
        
        for (CartLineInfo line : lines) {
            OrderDetail detail = new OrderDetail();
            detail.setOrder_id(order.getId());
            detail.setPrice(line.getAmount());
            detail.setQuantity(line.getQuantity());
            detail.setCreated_at(new Date());
            detail.setDel_flag(0);
            int id_dish = line.getDishInfo().getId();
            detail.setDish_id(id_dish);
            
            session.save(detail);
        } 
    }
    
    @Override
    public PaginationResult<OrderBillInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage) {
        String sql = "Select new " + OrderBillInfo.class.getName()//
                + "(ord.id, ord.orderDate, ord.orderNum, ord.amount, "
                + " ord.customerName, ord.customerAddress, ord.customerEmail, ord.customerPhone) " + " from "
                + OrderBill.class.getName() + " ord "//
                + " order by ord.orderNum desc";
        Session session = this.sessionFactory.getCurrentSession();
        
        Query query = session.createQuery(sql);
        
        return new PaginationResult<OrderBillInfo>(query, page, maxResult, maxNavigationPage);
    }

    public OrderBill findOrder(int orderId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(OrderBill.class);
        crit.add(Restrictions.eq("id", orderId));
        return (OrderBill) crit.uniqueResult();
    }
    
    @Override
    public OrderBillInfo getOrderInfo(int orderId) {
        OrderBill order = this.findOrder(orderId);
        if (order == null) {
            return null;
        }
        return new OrderBillInfo();
    }
   
    
    
}
