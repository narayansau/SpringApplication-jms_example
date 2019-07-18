package com.example.jms_example.Configuration;


import lombok.Data;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

import javax.jms.ConnectionFactory;

@Configuration

public class ToDoConfiguration{

    @Bean
    public MappingJackson2MessageConverter jacksonJmsMessageConverter () {

        MappingJackson2MessageConverter converter =
             new    MappingJackson2MessageConverter();
      //converter.setTargetType( MessageType.TEXT);

        //converter.setTypeIdPropertyName("_class_");
        return converter;
    }

    @Bean
    public JmsListenerContainerFactory<?>
                    jmsListenerContainerFactory(ConnectionFactory connectionFactory ,
                             DefaultJmsListenerContainerFactoryConfigurer configurer) {

        DefaultJmsListenerContainerFactory factory = new
                DefaultJmsListenerContainerFactory();
        factory.setErrorHandler( new ToDoErrorHandler() );
        configurer.configure( factory,connectionFactory );
        return factory;

    }

    @Configuration
    static class  MethodListenerConfig implements JmsListenerConfigurer {

        @Override
        public void configureJmsListeners(
                JmsListenerEndpointRegistrar jmsListenerEndpointRegistrar) {
            jmsListenerEndpointRegistrar.setMessageHandlerMethodFactory(
                    myHandlerMethodFactory()
            );

        }

        @Bean
        public MessageHandlerMethodFactory myHandlerMethodFactory() {
            DefaultMessageHandlerMethodFactory factory = new
                    DefaultMessageHandlerMethodFactory();
            factory.setValidator( new ToDOValidator() );
            return factory;
        }
    }
}
