package com.wnf.entity;

import java.io.Serializable;
import java.util.List;

public class Roles implements Serializable {

    private int rid;
    private String rname;

    private List<Users> users;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", users=" + users +
                '}';
    }
}
