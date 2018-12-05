package com.matrix.kafkasupport.producer;

import com.matrix.kafkasupport.admin.KafkaConfigMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerMgr {

    @Autowired
    KafkaConfigMgr kafkaConfigMgr;

    /**
     * Kafka File producer
     * @return
     */
    public KafkaFileProducer getKafkaFileProducer() {
        KafkaFileProducer kafkaFileProducer = new KafkaFileProducer();
        kafkaFileProducer.setConfig(kafkaConfigMgr.getConfigForProducer());

        return kafkaFileProducer;
    }


}
