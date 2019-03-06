package com.springbootdev.springcloud.stream.examples.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@EnableBinding(Source.class)
@RestController
public class OrderController
{
    @Autowired
    private Source source;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);


    @PostMapping("/orders/publish")
    public String publishOrder(@RequestBody Order order)
    {
        source.output().send(MessageBuilder.withPayload(order).build());
        logger.info(order.toString());
        return "order_published";
    }
}