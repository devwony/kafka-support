package com.matrix.kafkasupport.consumer;

import java.util.Properties;

public interface KafkaCommConsumer {

    void setConfig(Properties prop);

    boolean start(String topic);
}
