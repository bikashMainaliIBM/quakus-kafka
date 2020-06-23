package com.ibm.garage.cpat.deserializer;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;
import com.ibm.garage.cpat.models.Item;

public class ItemDeserializer extends JsonbDeserializer<Item> {
    public ItemDeserializer(){
        // pass the class to the parent.
        super(Item.class);
    }
}