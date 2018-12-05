package com.matrix.kafkasupport.consumer;

import com.matrix.kafkasupport.admin.KafkaConfigMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerMgr {

    @Autowired
    KafkaConfigMgr kafkaConfigMgr;

    /**
     * kafka mapd consumer
     * @return
     */
    public KafkaMapdConsumer getKafkaMapdConsumer() {
        KafkaMapdConsumer kafkaMapdConsumer = new KafkaMapdConsumer();
        kafkaMapdConsumer.setConfig(kafkaConfigMgr.getConfigForConsumer());
        return kafkaMapdConsumer;
    }
}
