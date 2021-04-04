package com.huawei.rocketmq.utils;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class RocketUtils {

    public static DefaultMQPushConsumer createConsumer() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("conser0401");
        consumer.setNamesrvAddr("127.0.0.1:9876");
        consumer.subscribe("Topic0325", "*");
        consumer.setConsumeThreadMax(4);
        consumer.setConsumeThreadMin(4);
        consumer.setPullBatchSize(1);
        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                for (MessageExt messageExt : list) {
                    System.out.println(new String(messageExt.getBody()) + "@" + System.currentTimeMillis());
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        consumer.start();
        return consumer;
    }

    public static void shutdownConsumer(DefaultMQPushConsumer consumer) {
        consumer.shutdown();
    }
}
