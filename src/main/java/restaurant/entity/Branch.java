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
@Table(name = "BRANCH")
public class Branch implements Serializable {

    private int id;
    private String name;
    private String address;
    private int directory_id;
    private Date created_at;
    private int del_flag;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 128)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "address", nullable = false, length = 128)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "directory_id", nullable = false)
    public int getDirectory_id() {
        return directory_id;
    }

    public void setDirectory_id(int directory_id) {
        this.directory_id = directory_id;
    }

    @Column(name = "created_at", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Column(name = "del_flag", nullable = false)
    public int getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(int del_flag) {
        this.del_flag = del_flag;
    }

}
