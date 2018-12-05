package com.matrix.kafkasupport.producer;


import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

public class KafkaFileProducer extends KafkaCommProducerImpl {

    Instant startTm;
    Instant endTm;

    private String FILE_PATH = null;
    BufferedReader fileBuff = null;

    public void setFilePath(String filePath) {
        this.FILE_PATH = filePath;
    }

    @Override
    public boolean start(String topic) {

        if( this.FILE_PATH == null ) {
            return false;
        }

        /**
         * read File
         */
        try {
            startTm = Instant.now();
            fileBuff = Files.newBufferedReader(Paths.get(FILE_PATH));
            Stream<String> lines = fileBuff.lines().map(str -> str.toUpperCase());
            endTm = Instant.now();
            System.out.printf("<!-----[%s] Read all lines by using BufferedReader-----!>%n", Duration.between(startTm, endTm).toMillis());
            System.out.println("<!-----Let's start send data to Kafka-----!>");
            /**
             * send data
             */
            startTm = Instant.now();
            lines.forEach(text->
                    {
                        try {
                            super.kafkaProducer.send( new ProducerRecord<String, String>(topic, text)).get();
                            //System.out.println(topic + "<---->" + text);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }
            );

            lines.close();
            endTm = Instant.now();
            System.out.printf("<!-----[%s] Send all lines to Kafka-----!>%n", Duration.between(startTm, endTm).toMillis());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return true;
    }


}
