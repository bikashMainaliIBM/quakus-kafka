package com.ibm.garage.cpat;

import java.util.concurrent.TimeUnit;

import com.ibm.garage.cpat.models.Item;

import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.reactivex.Flowable;

public class ItemProducer {

    @Outgoing("Item-data-topic-outgoing")                        
    public Flowable<Item> generate() {               
        return Flowable.interval(5, TimeUnit.SECONDS)
                .map(tick -> {
                    Item itm = new Item();
                    itm.code = "111";
                    itm.id = 12L;
                    itm.price = 123.44;
                    itm.title = "New Item";
                    return itm;
                });
    }
}