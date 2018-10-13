package hello.Controllers;

import hello.Greeting;
import hello.HelloMessage;
import hello.nexmo.beans.DtmfEvent;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.util.HtmlUtils;

public class NexmoController {

    @MessageMapping("/nexmo-socket2")
    public void HandleIncoming(DtmfEvent event) throws Exception {

        System.out.println( "Handling Event" + event.getEvent() );

    }


}
