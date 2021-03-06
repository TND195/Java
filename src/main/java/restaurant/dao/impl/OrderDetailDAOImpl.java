/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import restaurant.dao.DishDAO;
import restaurant.dao.OrderDetailDAO;
import restaurant.entity.Dish;
import restaurant.entity.OrderDetail;
import restaurant.model.DishInfo;
import restaurant.model.OrderDetailInfo;

/**
 *
 * @author Admin
 */
public class OrderDetailDAOImpl implements OrderDetailDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired
    private DishDAO dishDAO;

    public List<DishInfo> getListTopSell() {
        String sql = "Select new " + OrderDetailInfo.class.getName() //
                + "(d.dish_id, d.quantity) "//
                + " from " + OrderDetail.class.getName() + " d where d.del_flag = 0"
                + " order by d.dish_id";

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery(sql);

        List<OrderDetailInfo> details = query.list();
        if (!details.isEmpty() && details != null) {
            for (int i = details.size() - 1; i > 0; i--) {
                if (details.get(i).getDish_id() == details.get(i - 1).getDish_id()) {
                    int quantity = details.get(i - 1).getQuantity() + details.get(i).getQuantity();
                    details.get(i - 1).setQuantity(quantity);
                    details.remove(i);
                }
            }

            Collections.sort(details);
            List<Integer> ids = new ArrayList<Integer>();
            for (int i = 0; i < details.size(); i++) {
                if (i < 5) {
                    ids.add(details.get(i).getDish_id());
                }
            }

            String sqlDish = "Select new " + DishInfo.class.getName() //
                    + " (p.id, p.name, p.img_url,p.created_at, p.price, p.description) " + " from "//
                    + Dish.class.getName() + " p "
                    + "where p.id in (:ids) and p.del_flag = 0";
            Query queryDish = session.createQuery(sqlDish);
            queryDish.setParameterList("ids", ids);
           return   queryDish.getResultList();
             
        } else {
            return null;
        }
    }
    public List<OrderDetailInfo> getlist(int orderid) {
          String sql = "Select new " + OrderDetailInfo.class.getName()//
                + "(ord.dish_id, ord.quantity, ord.price, ord.created_at) " + " from "
                + OrderDetail.class.getName() + " ord where ord.del_flag = 0 and ord.order_id = :orderid";
        Session session = this.sessionFactory.getCurrentSession();
        
        Query query = session.createQuery(sql);
        query.setParameter("orderid", orderid);
        List<OrderDetailInfo> orderDetailInfos = query.list();
        for (OrderDetailInfo orderDetailInfo : orderDetailInfos) {
            DishInfo findDishInfo = dishDAO.findDishInfo(orderDetailInfo.getDish_id());
            orderDetailInfo.setDish_img_url(findDishInfo.getImg_url());
            orderDetailInfo.setDish_name(findDishInfo.getName());
            orderDetailInfo.setDish_price(findDishInfo.getPrice());
            orderDetailInfo.setDish_description(findDishInfo.getDescription());
        }
        return orderDetailInfos;
    }

}
