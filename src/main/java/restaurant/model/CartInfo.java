/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class CartInfo {


    private CustomerInfo customerInfo;
    private final List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();

    public CartInfo() {

    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public List<CartLineInfo> getCartLines() {
        return this.cartLines;
    }

    private CartLineInfo findLineByCode(int id) {
        for (CartLineInfo line : this.cartLines) {
            if (line.getDishInfo().getId() == id) {
                return line;
            }
        }
        return null;
    }

    public void addProduct(DishInfo dishInfo, int quantity) {
        CartLineInfo line = this.findLineByCode(dishInfo.getId());

        if (line == null) {
            line = new CartLineInfo();
            line.setQuantity(0);
            line.setDishInfo(dishInfo);
            this.cartLines.add(line);
        }
        int newQuantity = line.getQuantity() + quantity;
        if (newQuantity <= 0) {
            this.cartLines.remove(line);
        } else {
            line.setQuantity(newQuantity);
        }
    }

    public void validate() {

    }

    public void updateProduct(int id, int quantity) {
        CartLineInfo line = this.findLineByCode(id);

        if (line != null) {
            if (quantity <= 0) {
                this.cartLines.remove(line);
            } else {
                line.setQuantity(quantity);
            }
        }
    }

    public void removeProduct(DishInfo dishInfo) {
        CartLineInfo line = this.findLineByCode(dishInfo.getId());
        if (line != null) {
            this.cartLines.remove(line);
        }
    }

    public boolean isEmpty() {
        return this.cartLines.isEmpty();
    }

    public boolean isValidCustomer() {
        return this.customerInfo != null && this.customerInfo.isValid();
    }

    public int getQuantityTotal() {
        int quantity = 0;
        for (CartLineInfo line : this.cartLines) {
            quantity += line.getQuantity();
        }
        return quantity;
    }

    public double getAmountTotal() {
        double total = 0;
        for (CartLineInfo line : this.cartLines) {
            total += line.getAmount();
        }
        return total;
    }

    public void updateQuantity(CartInfo cartForm) {
        if (cartForm != null) {
            List<CartLineInfo> lines = cartForm.getCartLines();
            for (CartLineInfo line : lines) {
                this.updateProduct(line.getDishInfo().getId(), line.getQuantity());
            }
        }

    }
}
