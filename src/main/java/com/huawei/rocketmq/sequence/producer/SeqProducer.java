package com.huawei.rocketmq.sequence.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.List;


public class SeqProducer {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        // 实例化消息生产者Producer
        DefaultMQProducer producer = new DefaultMQProducer("0401");
        // 设置NameServer的地址
        producer.setNamesrvAddr("127.0.0.1:9876");

        // 启动生产者实例
        producer.start();
        // 发送消息
        for (int i = 0; i < 10000; i++) {

            // 创建消息，并指定Topic，Tag和消息体
            Message message = new Message("Topic0325","*", ("Hello Rocket" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            // 发送消息

            SendResult sendResult = producer.send(message, new MessageQueueSelector() {

                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {

                    int index = 1;
                    /*
                    int cur = (int) o;
                    if (cur >= 0 && cur <=24) {
                        index = 0;
                    } else if (cur >= 25 && cur <=49) {
                        index = 1;
                    } else if (cur >= 50 && cur <=74) {
                        index = 2;
                    } else {
                        index = 3;
                    }*/
                    return list.get(index);
                }
            }, i);
            System.out.printf("%s%n", sendResult);
        }
        producer.shutdown();
    }
}
