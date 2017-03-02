package com.example.yanglh6.myapplication4;

import java.io.Serializable;

/*  存储相应的数据  */
public class Fruit implements Serializable {

    public Fruit(String ItemName) {
        this.ItemName = ItemName;
    }


    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    private String ItemName;
}