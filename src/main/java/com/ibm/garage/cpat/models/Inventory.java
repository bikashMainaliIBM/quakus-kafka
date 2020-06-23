package com.ibm.garage.cpat.models;

import lombok.Data;

@Data
public class Inventory {
    public Long id;
    public String storeName;
    public String itemCode;
    public Long quantity;
    public Double price;
    public String timestamp;
    
    public Inventory(){}
}