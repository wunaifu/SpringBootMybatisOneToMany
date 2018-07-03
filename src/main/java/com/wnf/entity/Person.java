package com.wnf.entity;

public class Person {
    private String pname;
    private int pid;
    private int page;

    private Card card;

    @Override
    public String toString() {
        return "Person{" +
                "pname='" + pname + '\'' +
                ", pid=" + pid +
                ", page=" + page +
                ", card=" + card +
                '}';
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
