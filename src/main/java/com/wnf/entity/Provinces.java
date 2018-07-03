package com.wnf.entity;

import java.util.List;
import java.util.Set;

public class Provinces {
    private int pid;
    private String pname;

    private List<Citys> citysSet;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public List<Citys> getCitysSet() {
        return citysSet;
    }

    public void setCitysSet(List<Citys> citysSet) {
        this.citysSet = citysSet;
    }

    @Override
    public String toString() {
        return "Provinces{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", citysSet=" + citysSet +
                '}';
    }
}
