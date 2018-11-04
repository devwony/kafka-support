package com.matrix.kafkasupport.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaProducerMgrTest {

    @Autowired
    KafkaProducerMgr kafkaProducerMgr;

    @Test
    public void getKafkaFileProducer() {

        KafkaFileProducer kafkaFileProducer = kafkaProducerMgr.getKafkaFileProducer();

        kafkaFileProducer.setFilePath("/home/wony/01.workspace/s-data/region.tbl");

        kafkaFileProducer.start("test-topic");
    }
}