package com.matrix.kafkasupport.producer;

import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

public abstract class KafkaCommProducerImpl implements KafkaCommProducer {

    protected KafkaProducer kafkaProducer;

    @Override
    public void setConfig(Properties prop){
        this.kafkaProducer = new KafkaProducer<String, String>(prop);
    }
}
