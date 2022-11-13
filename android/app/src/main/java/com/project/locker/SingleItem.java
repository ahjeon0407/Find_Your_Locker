package com.project.locker;

public class SingleItem {
    private String name;
    private String num;

    public SingleItem(String name, String num){
        this.name = name;
        this.num = num;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNum(String num){
        this.num = num;
    }

    public String getName(){
        return this.name;
    }

    public String getNum(){
        return this.num;
    }
}
