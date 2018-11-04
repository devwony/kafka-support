package com.matrix.kafkasupport.producer;

import java.util.Properties;

public interface KafkaCommProducer {

    void setConfig(Properties prop);

    boolean start(String topic);
}
