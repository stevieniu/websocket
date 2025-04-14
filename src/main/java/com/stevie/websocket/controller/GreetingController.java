package com.stevie.websocket.controller;

import com.stevie.websocket.config.model.Greeting;
import com.stevie.websocket.config.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Message message) throws Exception {
        return new Greeting("Hello " + HtmlUtils.htmlEscape(message.name()) + "!");
    }
}
