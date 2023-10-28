package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");	//サーバからクライアントへの送信時の宛先名の接頭語を/topicにする処理。使用時は/topic/greetingsを指定。宛先名greetingsはクライアントのjsに定義。
        config.setApplicationDestinationPrefixes("/app");	//クライアントからサーバへの送信時の宛先名の接頭語を/appにする処理。使用時は/app/helloを指定。宛先名helloはコントローラに定義。(@MessageMapping)
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS();	//クライアントからサーバへの接続時に指定する接頭語を /gs-guide-websocketにする処理
    }

}