/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import restaurant.dao.BranchDAO;
import restaurant.entity.Branch;
import restaurant.model.BranchInfo;


/**
 *
 * @author Admin
 */
public class BranchDAOImpl implements BranchDAO{
    @Autowired
    private SessionFactory sessionFactory;
    
    public List<BranchInfo> queryBranch() {
         String sql = "Select new " + BranchInfo.class.getName() //
                + " ( b.name, b.address) " + " from "//
                + Branch.class.getName() + " b where b.del_flag = 0";
       Session session = this.sessionFactory.getCurrentSession();
        
        Query query = session.createQuery(sql);
        
        return query.list();
    }
    
}
