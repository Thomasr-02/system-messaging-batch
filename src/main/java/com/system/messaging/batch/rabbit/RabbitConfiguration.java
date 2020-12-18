package com.system.messaging.batch.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitConfiguration {

    @Bean
    public Queue queue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-message-deduplication", true);
        return new Queue("q.download", true, false, false, args);

    }

}
