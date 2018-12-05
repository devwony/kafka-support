package com.matrix.kafkasupport.consumer;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaConsumerMgrTest {

    @Autowired
    KafkaConsumerMgr kafkaConsumerMgr;

    @Test
    public void getKafkaMapdConsumer() {

        /**
         * Consumer
         */
        KafkaMapdConsumer kafkaMapdConsumer = kafkaConsumerMgr.getKafkaMapdConsumer();
        kafkaMapdConsumer.setInsertSql("INSERT INTO sample VALUES (?)");
        kafkaMapdConsumer.start("test-topic");

    }
}