package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.HtmlUtils;

import java.util.Map;

@Controller
public class CallController {

//    @MessageMapping("/call")
//    @SendTo("/topic/greetings")
//    public String greeting(HelloMessage message) {
//        return message.toString();
//    }
    @PostMapping("/call")
    public void call(@RequestBody Map<String, Object> payload) {
        System.out.print(payload);
    }
}
