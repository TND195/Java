/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.model;

/**
 *
 * @author Admin
 */
public class CartLineInfo {

    private DishInfo dishInfo;
    private int quantity;

    public CartLineInfo() {
        this.quantity = 0;
    }

    public DishInfo getDishInfo() {
        return dishInfo;
    }

    public void setDishInfo(DishInfo dishInfo) {
        this.dishInfo = dishInfo;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getAmount() {
        return this.dishInfo.getPrice() * this.quantity;
    }
}
