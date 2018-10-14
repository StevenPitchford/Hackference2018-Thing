package hello.Controllers;

import hello.ToadWhisperer;
import hello.beans.DevelopmentMessage;
import hello.beans.ToadControl;
import hello.beans.ToadControlActions;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

@Component
@Controller
public class DevelopmentController {

    @Autowired
    private ToadWhisperer toadWhisperer;

    @MessageMapping("/development")
    @SendTo("/topic/toadcontrol")
    public ToadControl processMessage( DevelopmentMessage message ) throws Exception
    {
        System.out.println("Cheese");
        System.out.println("Pitch "+message.getPitch());
        if ( message.getPitch() > 0 ) {


            ToadControl tc = new ToadControl();
            tc.setCommand(ToadControlActions.Croak);
            tc.setToadID(message.getToadId());
            tc.setPitch(message.getPitch());

            System.out.println("Pitch Sending "+ message.getPitch());

            return tc;
        }

        return null;
    }


}
