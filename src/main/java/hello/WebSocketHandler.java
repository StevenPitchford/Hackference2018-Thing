package hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.Controllers.DevelopmentController;
import hello.beans.DevelopmentMessage;
import hello.nexmo.beans.DtmfEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;

@Controller
public class WebSocketHandler extends AbstractWebSocketHandler {

    @Autowired
    DevelopmentController template;


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {

        String payload = message.getPayload();

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println(payload);
        System.out.println("");
        System.out.println("");
        System.out.println("");

        ObjectMapper mapper = new ObjectMapper();
        DtmfEvent dtmfEvent = mapper.readValue(payload, DtmfEvent.class);

        if ( dtmfEvent.isWebsocketEvent() )
        {
            // We have a digit
            int digit = dtmfEvent.parseDigit();
            System.out.println("Number: " + digit);

            DevelopmentMessage cake = new DevelopmentMessage();

            try {
                this.template.processMessage(cake);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws IOException {
        //System.out.println("New Binary Message Received");
    }
}
