package com.ibm.garage.cpat.models;

import lombok.Data;

@Data
public class Item {
    public Long id;
    public String code;
    public String title;
    public double price;

    public Item(){}
}