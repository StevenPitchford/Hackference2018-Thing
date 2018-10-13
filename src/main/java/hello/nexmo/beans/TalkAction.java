package hello.nexmo.beans;

import java.io.Serializable;

public class TalkAction implements Serializable
{

    private String action = "Talk";
    private String text = "Welcome to ToadCall, the entertaining entertainment which seeks to entertain you in and entertaining manner, albeit entertainingly.";

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
