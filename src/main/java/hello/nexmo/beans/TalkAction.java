package hello.nexmo.beans;

import java.io.Serializable;

public class TalkAction implements Serializable
{

    private String action = "talk";
    private String text = "Welcome to ToadCall, the entertaining entertainment which seeks to entertain you in and entertaining manner, albeit entertainingly. To facilitate your entertainment, we would be very appreciative if, following this message, you would press a button on your keypad. Thanks in advance for participating in this amazing form of entertainiment! ";

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
