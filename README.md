# In this project we have impl SpringBoot Kafka

```Default topic used for this demo is``` **test** 

## How to run zookeeper and kafka in cmd

### To run zookeeper in powershell

```.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties```

### To run kafka server in powershell

```.\bin\windows\kafka-server-start.bat .\config\server.properties```

### To create topic in powershell at a particular server

```./kafka-topics.bat --create --bootstrap-server localhost:9092 --topic test```

### To get list of topic in powershell at a particular server

```./kafka-topics.bat --bootstrap-server localhost:9092 --list```
### To get all message from topic from powershell

```./kafka-console-consumer.bat --topic test --bootstrap-server localhost:9092 --from-beginning```

