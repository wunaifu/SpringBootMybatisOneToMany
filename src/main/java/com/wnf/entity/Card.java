package com.wnf.entity;

public class Card {
    private int uid;
    private String cnumber;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    @Override
    public String toString() {
        return "Card{" +
                "uid=" + uid +
                ", cnumber='" + cnumber + '\'' +
                '}';
    }
}
