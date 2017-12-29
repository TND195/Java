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

    public List<DishInfo> getListTopSell() {
        String sql = "Select new " + OrderDetailInfo.class.getName() //
                + "(d.dish_id, d.quantity) "//
                + " from " + OrderDetail.class.getName() + " d "
                + " order by d.dish_id desc";

        Session session = this.sessionFactory.getCurrentSession();
        
        Query query = session.createQuery(sql);

        List<OrderDetailInfo> details = query.list();
        
        for(int i = details.size() -1 ; i >0 ; i--) {
            if(details.get(i).getDish_id() == details.get(i -1).getDish_id()) {
                int quantity = details.get(i-1).getQuantity() + details.get(i).getQuantity();
                details.get(i-1).setQuantity(quantity);
                details.remove(i);
            }
        }
        
       Collections.sort(details);
       List<Integer> ids = new ArrayList<Integer>();
       for(int i=0 ; i<details.size() ; i++) {
           ids.add(details.get(i).getDish_id());
       }
         String sqlDish = "Select new " + DishInfo.class.getName() //
                + " (p.id, p.name, p.img_url,p.created_at, p.price) " + " from "//
                + Dish.class.getName() + " p "
                + "where p.id in (:ids)";
       Query queryDish = session.createQuery(sqlDish);
       queryDish.setParameterList("ids", ids);
       List<DishInfo> dishs = queryDish.getResultList();
       return dishs;
    }

}
