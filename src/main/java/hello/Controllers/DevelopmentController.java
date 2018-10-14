package hello.Controllers;

import hello.ToadWhisperer;
import hello.beans.DevelopmentMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class DevelopmentController {

    @Autowired
    private ToadWhisperer toadWhisperer;

    @MessageMapping("/development")
    public void processMessage( DevelopmentMessage message ) throws Exception
    {
        System.out.println("Cheese");
        if ( message.getPitch() > 0 ) {
            toadWhisperer.croakToad("toad", message.getPitch());
        }
    }


}
