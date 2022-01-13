package com.kunal.spring.cloud.stream.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class) // In producer we added source.class. I consumer we added Sinc.class
public class SpringCloudStreamConsumerApplication {

    private Logger logger = LoggerFactory.getLogger(SpringCloudStreamConsumerApplication.class);

    @StreamListener("input") // input is the channel name
    public void consumeMessage(Book book) {
        logger.info("Consume payload : " + book);
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamConsumerApplication.class, args);
    }
}