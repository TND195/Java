/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.dao;

import java.util.List;
import restaurant.model.BranchInfo;


/**
 *
 * @author Admin
 */
public interface BranchDAO {
    public List<BranchInfo> queryBranch() ;
}
