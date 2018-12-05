package com.matrix.kafkasupport.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class KafkaMapdConsumer extends KafkaCommConsumerImpl {

    Instant startTm;
    Instant endTm;

    private String insertSql;


    final String JDBC_DRIVER = "com.mapd.jdbc.MapDDriver";
    final String DB_URL = "jdbc:mapd:127.0.0.1:9191:mapd";

    // Database credentials
    final String USER = "mapd";
    final String PASS = "HyperInteractive";

    @Override
    public boolean start(String topic) {



        /**
         * subscribe topic
         */
        super.kafkaConsumer.subscribe(Arrays.asList(topic));

        //ExecutorService insertExecutor = Executors.newSingleThreadExecutor();
        //insertExecutor.submit(() -> {

            Connection conn = null;
            PreparedStatement pstmt = null;
            String val = null;
            try {
                Class.forName(JDBC_DRIVER);

                while (true) {
                    if( conn == null ) {
                        conn = DriverManager.getConnection(DB_URL, USER, PASS);
                        pstmt = conn.prepareStatement(this.insertSql);
                    }

                    ConsumerRecords<String, String> records = this.kafkaConsumer.poll(Duration.ofMillis(1000));
                    // STEP 4: Populate the prepared statement batch
                    for (ConsumerRecord<String, String> record : records) {
                        val = record.value();
                        if( val != null ){
                            pstmt.setString(1, val);
                            pstmt.addBatch();
                            //System.out.println("--->> " + val);
                        }
                    }
                    pstmt.executeBatch();

                    conn.commit();

                    //conn.close();
                }



            } catch (Exception ex) {
                ex.printStackTrace();
            }
        //});
        return true;
    }

    public void setInsertSql(String insertSql) {
        this.insertSql = insertSql;
    }
}
