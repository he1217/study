package com.he.excise.kafka.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:  hs
 * @Date: 2019/2/28 21:57
 * @Description:
 */
@Configuration
@EnableKafka
public class KafkaProducerConfig {

    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${kafka.producer.retries}")
    private Integer retries;

    @Value("${kafka.producer.batch-size}")
    private Integer batchSize;

    @Value("${kafka.producer.buffer-memory}")
    private Integer bufferMemory;

    @Value("${kafka.producer.linger}")
    private Integer linger;

    @Value("${kafka.producer.sasl.kafkaAuth}")
    private Boolean kafkaAuth;

    @Value("${kafka.producer.sasl.mechanism}")
    private String mechanism;

    @Value("${kafka.producer.sasl.jaasConfig}")
    private String jaasConfig;

    @Value("${kafka.producer.sasl.username}")
    private String username;

    @Value("${kafka.producer.sasl.password}")
    private String password;





    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>(7);
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.RETRIES_CONFIG, retries);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
        props.put(ProducerConfig.LINGER_MS_CONFIG, linger);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        if (kafkaAuth) {
            props.put("security.protocol", "SASL_PLAINTEXT");
            props.put("sasl.mechanism", mechanism);
            props.put("sasl.jaas.config",
                    jaasConfig + " required username=\"" + username + "\" password=\"" + password + "\";");
        }
        return props;
    }

    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    private static KafkaProducer<String,Object> producer;


    @PostConstruct
    public void initKafkaProducer(){
        producer = new KafkaProducer<String, Object>(producerConfigs());
    }




    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
