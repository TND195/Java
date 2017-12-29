/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

    private static final long serialVersionUID = -2576670215015463100L;
    private int id;
    private String name;
    private String address;
    private String phone;
    private Date created_at;
    private int del_flag;

    @Id
    @Column(name = "id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    @Column(name = "name", nullable = false, length = 128)
    public String getName() {
        return name;
    }

    @Column(name = "address", nullable = false, length = 128)
    public String getAddress() {
        return address;
    }

    @Column(name = "phone", nullable = false, length = 128)
    public String getPhone() {
        return phone;
    }

    @Column(name = "created_at", nullable = false, length = 128)
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getCreated_at() {
        return created_at;
    }

    @Column(name = "del_flag", nullable = false)
    public int getDel_flag() {
        return del_flag;
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

    public void setDel_flag(int del_flag) {
        this.del_flag = del_flag;
    }

}
