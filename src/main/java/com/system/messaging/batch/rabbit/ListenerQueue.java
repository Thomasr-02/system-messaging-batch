package com.system.messaging.batch.rabbit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ListenerQueue {
    private final Logger logger = LoggerFactory.getLogger("");

    private final ObjectMapper objectMapper = new ObjectMapper();



    @RabbitListener(queues = "q.download", concurrency = "10")
    public void listener(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag, @Header("x-job-mutavel") Boolean mutavel ) throws IOException {
        logger.info("Message received {} ", message);

        try {
            System.out.println("teste");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

