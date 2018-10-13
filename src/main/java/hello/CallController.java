package hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexmo.client.voice.ncco.Ncco;
import com.nexmo.client.voice.ncco.TalkNcco;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/event")
    public String event() {
        return "";
    }

    @GetMapping(value = "/answer", produces = "application/json")
    public String answer() throws JsonProcessingException {
        TalkNcco message = new TalkNcco("Hey, it's callum... Yes? Oh yeah! mhm? Just kidding, it's an answer machine beeeep");

        Ncco[] nccos = new Ncco[]{message};

        return new ObjectMapper().writer().writeValueAsString(nccos);
    }
}
