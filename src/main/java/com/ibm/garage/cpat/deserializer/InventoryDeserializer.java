package com.ibm.garage.cpat.deserializer;

import com.ibm.garage.cpat.models.Inventory;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class InventoryDeserializer extends JsonbDeserializer<Inventory> {
    public InventoryDeserializer(){
        // pass the class to the parent.
        super(Inventory.class);
    }
}