package com.ibm.garage.cpat;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

import com.ibm.garage.cpat.models.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A bean producing random temperature data every second.
 * The values are written to a Kafka topic (temperature-values).
 * Another topic contains the name of weather stations (weather-stations).
 * The Kafka configuration is specified in the application configuration.
 */
@ApplicationScoped
public class ComplianceService {
    private final static Logger LOGGER = LoggerFactory.getLogger("ComplianceService");

    private ExecutorService queue = Executors.newSingleThreadExecutor();
    @Channel("Inventory-data-topic") Emitter<Inventory> inventoryEmitter;

    @Incoming("Item-data-topic")
    public void process(Item item) {
        CompletableFuture.supplyAsync(() -> {
            LOGGER.info("Received message {} in kafkaTopic", item);
            Inventory inventory = new Inventory();
            inventory.id = item.id;
            inventory.itemCode = item.code;
            inventory.price = item.price;
            inventory.quantity = 0L;
            inventory.storeName = "DefaultStoreName";
            inventoryEmitter.send(inventory);
            return "";
        }, queue);
    }


    @Incoming("Inventory-data-topic-incoming")
    public void processInventory(Inventory inventory) {
        CompletableFuture.supplyAsync(() -> {
            LOGGER.info("Received Inventory message {} in kafkaTopic", inventory);
            return "";
        }, queue);
    }
}