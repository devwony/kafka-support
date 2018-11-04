package com.matrix.kafkasupport.admin;

import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class KafkaConfigMgr {

    /**
     * get infomation about kafka configuration
     * @return
     */
    public Properties getConfiguration(){
        Properties config = new Properties();

        // Set the kafka configuration properties.
        config.put("bootstrap.servers", "127.0.0.1:9092");
        config.put("acks", "all");
        config.put("retries", 0);
        config.put("batch.size", 100);
        config.put("linger.ms", 1);
        config.put("buffer.memory", 33554432);
        config.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        config.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return config;
    }//~

}
