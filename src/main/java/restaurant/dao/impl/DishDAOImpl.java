/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.dao.impl;

import restaurant.dao.DishDAO;
import restaurant.entity.Dish;
import java.util.Date;
import restaurant.model.DishInfo;
import restaurant.model.PaginationResult;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Transactional
public class DishDAOImpl implements DishDAO{
   @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Dish findDish(int id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Dish.class);
        crit.add(Restrictions.eq("id", id));
        return (Dish) crit.uniqueResult();
    }

    @Override
    public DishInfo findDishInfo(int id) {
        Dish dish = this.findDish(id);
        if (dish == null) {
            return null;
        }
        return new DishInfo(dish.getId(), dish.getName(), dish.getImg_url(),dish.getCreated_at(), dish.getPrice(), dish.getDescription());
    }

    @Override
    public PaginationResult<DishInfo> queryDishs(int page, int maxResult, int maxNavigationPage) {
            return queryDishs(page, maxResult, maxNavigationPage, null);
    }

    @Override
    public PaginationResult<DishInfo> queryDishs(int page, int maxResult, int maxNavigationPage, String likeName) {
    
        String sql = "Select new " + DishInfo.class.getName() //
                + " (p.id, p.name, p.img_url,p.created_at, p.price, p.description) " + " from "//
                + Dish.class.getName() + " p ";
        if (likeName != null && likeName.length() > 0) {
            sql += " Where lower(p.name) like :likeName and p.del_flag = 0";
        }
        sql += " order by p.created_at desc ";
        //
        Session session = sessionFactory.getCurrentSession();
 
        Query query = session.createQuery(sql);
        if (likeName != null && likeName.length() > 0) {
            query.setParameter("likeName", "%" + likeName.toLowerCase() + "%");
        }
       
        return new PaginationResult<DishInfo>(query, page, maxResult, maxNavigationPage);
    }

    public PaginationResult<DishInfo> queryDishsByDirectory(int page, int maxResult, int maxNavigationPage, int id_directory) {
        String sql = "Select new " + DishInfo.class.getName() //
                + " (p.id, p.name, p.img_url,p.created_at, p.price, p.description) " + " from "//
                + Dish.class.getName() + " p "
                + " Where p.dish_directory_id = :dish_directory_id and p.del_flag = 0";
        Session session = sessionFactory.getCurrentSession();
 
        Query query = session.createQuery(sql);
        
        query.setParameter("dish_directory_id", id_directory);
        
        return new PaginationResult<DishInfo>(query, page, maxResult, maxNavigationPage);
    }
    
}
