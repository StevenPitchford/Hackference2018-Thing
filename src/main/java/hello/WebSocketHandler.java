package hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.nexmo.beans.DtmfEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;

@Component
public class WebSocketHandler extends AbstractWebSocketHandler {

    @Autowired
    WebSocketConfig webSocketConfig;


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

            this.webSocketConfig.template.convertAndSend("/topic/toadcontrol", "{pitch:1}");

        }
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws IOException {
        //System.out.println("New Binary Message Received");
    }
}
