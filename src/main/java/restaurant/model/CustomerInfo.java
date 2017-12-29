/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class CustomerInfo {

    private int id;
    private String name;
    private String address;
    private String phone;
    private Date created_at;
    private boolean valid;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public boolean isValid() {
        return valid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

}
