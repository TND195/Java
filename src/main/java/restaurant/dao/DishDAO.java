/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.dao;

import restaurant.entity.Dish;
import restaurant.model.DishInfo;
import restaurant.model.PaginationResult;

/**
 *
 * @author Admin
 */
public interface DishDAO {
        public Dish findDish(int id);
    
    public DishInfo findDishInfo(int id) ;
  
    
    public PaginationResult<DishInfo> queryDishs(int page,
                       int maxResult, int maxNavigationPage  );
    
    public PaginationResult<DishInfo> queryDishs(int page, int maxResult,
                       int maxNavigationPage, String likeName);
    public PaginationResult<DishInfo> queryDishsByDirectory(int page, int maxResult,
                       int maxNavigationPage, int id_directory);
}
