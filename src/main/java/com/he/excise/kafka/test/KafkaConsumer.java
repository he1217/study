package com.he.excise.kafka.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.json.JSONObject;
import org.springframework.core.codec.StringDecoder;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/7/28 17:22
 */
@Slf4j
public class KafkaConsumer {
    @KafkaListener(id = "${kafka.listener.span-group-id1}",
            topics = {"${kafka.listener.span-topic}"},
            containerFactory = "kafkaListenerContainerFactory0")
    public void spanServerListBatchListener(List<ConsumerRecord<?, ?>> records, Acknowledgment ack) {
        try {
            records.stream().forEach(record -> {
                Optional<?> kafkaMessage = Optional.ofNullable(record.value());
                if (kafkaMessage.isPresent()) {
                    String kafkaMsg = kafkaMessage.get().toString();
                    System.out.println("消费到的数据:"+kafkaMsg);
                }
            });
        } catch (Exception e) {
            log.error("kafka监听异常:" + e.getMessage(), e);
        } finally {
            ack.acknowledge();
        }
    }

}
