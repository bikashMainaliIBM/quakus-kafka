# data converter project
this project reads data from topic `item-topic` which contains serialized data of type Item and converts data to Inventory type and sends data to another topic `inventory-topic`. these two topic needs to be on you kafka-cluster.

## ENV
3 environment variable are required to connect to ibm cloud
```
BOOTSTRAP_SERVERS // server you want to connect to
```
```
API_KEY /// api key to connect to server
```
```
CERT_LOCATION // cert location
```

export these variable using 
```
export BOOTSTRAP_SERVERS=XXXXX
export API_KEY=XXXX
export CERT_LOCATION=XXXX
```


if you are connecting to ibm cloud or do not required java cert comment line with `${CERT_LOCATION}` and `mp.messaging.connector.smallrye-kafka.ssl.truststore.password=password` on application.properties

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

