package com.matrix.kafkasupport.consumer;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Properties;

public abstract class KafkaCommConsumerImpl implements KafkaCommConsumer {

    protected KafkaConsumer<String, String> kafkaConsumer;

    @Override
    public void setConfig(Properties prop){
        this.kafkaConsumer = new KafkaConsumer<String, String>(prop);
    }
}
