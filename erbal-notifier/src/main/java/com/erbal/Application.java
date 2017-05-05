package com.erbal;

//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.amqp.rabbit.annotation.EnableRabbit;
//import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
//import org.springframework.messaging.converter.MappingJackson2MessageConverter;
//import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Controller
//@EnableRabbit
@EnableScheduling
public class Application
        //implements RabbitListenerConfigurer
{

    /* CORS */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/notifications/**").allowedOrigins("*");
            }
        };
    }

    @RequestMapping(value = "/")
    public String welcome() {
        return "redirect:/welcome.html";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    /* WebSocket RabbitMQ */
//    public static final String EXCHANGE_NAME = "appExchange";
//    public static final String QUEUE_GENERIC_NAME = "appGenericQueue";
//    public static final String QUEUE_SPECIFIC_NAME = "appSpecificQueue";
//    public static final String ROUTING_KEY = "messages.key";
//
//    @Bean
//    public TopicExchange appExchange() {
//        return new TopicExchange(EXCHANGE_NAME);
//    }
//
//    @Bean
//    public Queue appQueueGeneric() {
//        return new Queue(QUEUE_GENERIC_NAME);
//    }
//
//    @Bean
//    public Queue appQueueSpecific() {
//        return new Queue(QUEUE_SPECIFIC_NAME);
//    }
//
//    @Bean
//    public Binding declareBindingGeneric() {
//        return BindingBuilder.bind(appQueueGeneric()).to(appExchange()).with(ROUTING_KEY);
//    }
//
//    @Bean
//    public Binding declareBindingSpecific() {
//        return BindingBuilder.bind(appQueueSpecific()).to(appExchange()).with(ROUTING_KEY);
//    }
//
//    // You can comment all methods below and remove interface's implementation to use the default serialization / deserialization
//    @Bean
//    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
//        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
//        return rabbitTemplate;
//    }
//
//    @Bean
//    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//    @Bean
//    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
//        return new MappingJackson2MessageConverter();
//    }
//
//    @Bean
//    public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
//        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
//        factory.setMessageConverter(consumerJackson2MessageConverter());
//        return factory;
//    }
//
//    @Override
//    public void configureRabbitListeners(final RabbitListenerEndpointRegistrar registrar) {
//        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
//    }
}