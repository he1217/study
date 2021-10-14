package com.he.excise.kafka.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hs
 * @Date: 2019/3/5 19:50
 * @Description:
 */
@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.consumer.enable-auto-commit}")
    private Boolean autoCommit;

    @Value("${spring.kafka.consumer.auto-commit-interval}")
    private Integer autoCommitInterval;

    @Value("${spring.kafka.consumer.max-poll-records}")
    private Integer maxPollRecords;

    @Value("${spring.kafka.consumer.auto-offset-reset}")
    private String autoOffsetReset;

    @Value("#{'${spring.kafka.listener.concurrencys}'.split(',')[0]}")
    private Integer concurrency0;

    @Value("#{'${spring.kafka.listener.concurrencys}'.split(',')[1]}")
    private Integer concurrency1;

    @Value("#{'${spring.kafka.listener.concurrencys}'.split(',')[2]}")
    private Integer concurrency2;

    @Value("#{'${spring.kafka.listener.concurrencys}'.split(',')[3]}")
    private Integer concurrency3;

    @Value("#{'${spring.kafka.listener.concurrencys}'.split(',')[4]}")
    private Integer concurrency4;

    @Value("${spring.kafka.listener.poll-timeout}")
    private Long pollTimeout;

    @Value("${spring.kafka.consumer.session-timeout}")
    private String sessionTimeout;

    @Value("${spring.kafka.listener.batch-listener}")
    private Boolean batchListener;

    @Value("${spring.kafka.consumer.max-partition-fetch-bytes}")
    private String maxPartitionFetchBytes;

    @Value("${spring.kafka.consumer.fetch-min-bytes}")
    private String fetchMinBytes;

    @Value("${spring.kafka.consumer.fetch-max-wait-ms}")
    private String fetchMaxWaitMs;

    @Value("${spring.kafka.consumer.sasl.kafkaAuth}")
    private Boolean kafkaAuth;

    @Value("${spring.kafka.consumer.sasl.mechanism}")
    private String mechanism;

    @Value("${spring.kafka.consumer.sasl.jaasConfig}")
    private String jaasConfig;

    @Value("${spring.kafka.consumer.sasl.username}")
    private String username;

    @Value("${spring.kafka.consumer.sasl.password}")
    private String password;


    /**
     * 批量并发n个线程消费
     * @return
     */
    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory0() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = kafkaListenerContainerFactory();
        factory.setConcurrency(concurrency0);
        return factory;
    }

    /**
     * 批量并发n个线程消费
     * @return
     */
    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory1() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = kafkaListenerContainerFactory();
        factory.setConcurrency(concurrency1);
        return factory;
    }

    /**
     * 批量并发n个线程消费
     * @return
     */
    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory2() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = kafkaListenerContainerFactory();
        factory.setConcurrency(concurrency2);
        return factory;
    }

    /**
     * 批量并发n个线程消费
     * @return
     */
    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory3() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = kafkaListenerContainerFactory();
        factory.setConcurrency(concurrency3);
        return factory;
    }

    /**
     * 批量并发n个线程消费
     * @return
     */
    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory4() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = kafkaListenerContainerFactory();
        factory.setConcurrency(concurrency4);
        return factory;
    }

    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        //批量消费
        factory.setBatchListener(batchListener);
        //如果消息队列中没有消息，等待timeout毫秒后，调用poll()方法。
        // 如果队列中有消息，立即消费消息，每次消费的消息的多少可以通过max.poll.records配置。
        //手动提交无需配置
        factory.getContainerProperties().setPollTimeout(pollTimeout);
        //设置提交偏移量的方式，
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        return factory;
    }

    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>(8);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, autoCommitInterval);
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, autoCommit);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeout);

        //增加消费量
        props.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG,maxPartitionFetchBytes);
        props.put(ConsumerConfig.FETCH_MIN_BYTES_CONFIG,fetchMinBytes);
        props.put(ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG,fetchMaxWaitMs);


        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        if (kafkaAuth) {
            props.put("security.protocol", "SASL_PLAINTEXT");
            props.put("sasl.mechanism", mechanism);
            props.put("sasl.jaas.config",
                    jaasConfig + " required username=\"" + username + "\" password=\"" + password + "\";");
        }
        return props;
    }





}
