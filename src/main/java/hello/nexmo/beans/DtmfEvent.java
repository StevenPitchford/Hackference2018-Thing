package hello.nexmo.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

// {"event":"websocket:dtmf","digit":"5","duration":260}
@JsonIgnoreProperties(ignoreUnknown = true)
public class DtmfEvent implements Serializable {

    private static String websocketEvent = "websocket:dtmf";

    private String digit;
    private String event;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDigit() {
        return digit;
    }

    public void setDigit(String digit) {
        this.digit = digit;
    }

    public boolean isWebsocketEvent()
    {
        return websocketEvent.equals(event);
    }

    public int parseDigit()
    {
        Integer i = Integer.parseInt(digit);
        return i;
    }

}
