package com.springbootdev.springcloud.stream.examples.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class OrderListener
{
    private static final Logger logger = LoggerFactory.getLogger(OrderListener.class);

    @StreamListener(target = Sink.INPUT)
    public void listenForOrder(Order order)
    {
      logger.info(" received new order ["+order.toString()+"] ");
    }
}
