package com.stevie.websocket.config;


import com.stevie.websocket.handler.TestHandler;
import com.stevie.websocket.handler.TutorialHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    /**
     * register path,
     * when call websocket, the path is: ws://hostname/path
     * e.g. ws://localhost:8080/tutorial
     * @param registry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(tutorialHandler(), "/tutorial")
                .addHandler(testHandler(), "/test");
    }

    @Bean
    public WebSocketHandler tutorialHandler() {
        return new TutorialHandler();
    }

    @Bean
    public WebSocketHandler testHandler() {
        return new TestHandler();
    }
}
