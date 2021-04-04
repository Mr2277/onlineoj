package com.huawei.rocketmq.sequence.consumer;

import com.huawei.rocketmq.mysql.MysqlUtils;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.sql.SQLException;
import java.util.List;

public class SeqConsumer {
    public static void main(String[] args) throws MQClientException {
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
    }
}
