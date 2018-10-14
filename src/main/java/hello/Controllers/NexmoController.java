package hello.Controllers;

import hello.nexmo.beans.DtmfEvent;
import org.springframework.messaging.handler.annotation.MessageMapping;

public class NexmoController {

    @MessageMapping("/nexmo-socket2")
    public void HandleIncoming(DtmfEvent event) throws Exception {

        System.out.println( "Handling Event" + event.getEvent() );

    }


}
