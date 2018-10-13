package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class CallController {

    @MessageMapping("/call")
    @SendTo("/topic/greetings")
    public String greeting(HelloMessage message) {
        return message.toString();
    }
}
