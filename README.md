# data converter project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

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

