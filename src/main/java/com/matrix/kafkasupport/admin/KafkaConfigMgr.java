package com.matrix.kafkasupport.admin;

import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class KafkaConfigMgr {

    /**
     * get infomation about kafka configuration
     * @return
     */
    public Properties getConfigForProducer(){
        Properties config = new Properties();

        // Set the kafka configuration properties.
        config.put("bootstrap.servers", "127.0.0.1:9092");
        config.put("acks", "all");
        config.put("retries", 0);
        config.put("batch.size", 100000);
        config.put("linger.ms", 1);
        config.put("buffer.memory", 33554432);
        config.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        config.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return config;
    }//~

    /**
     * get infomation about kafka configuration
     * @return
     */
    public Properties getConfigForConsumer(){
        Properties config = new Properties();

        // Set the kafka configuration properties.
        config.put("bootstrap.servers", "127.0.0.1:9092");
        config.put("group.id", "test");
        config.put("enable.auto.commit", "true");
        config.put("auto.commit.interval.ms", "1000");
        config.put("session.timeout.ms", "30000");
        config.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        config.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return config;
    }//~

}
