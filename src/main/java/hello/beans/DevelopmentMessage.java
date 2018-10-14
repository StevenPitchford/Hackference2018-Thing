package hello.beans;

import java.io.Serializable;

public class DevelopmentMessage implements Serializable {

    private Integer pitch = 5;
    private String command = "Croak";
    private String toadId = "toad";

    public Integer getPitch() {
        return pitch;
    }

    public void setPitch(Integer pitch) {
        this.pitch = pitch;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getToadId() {
        return toadId;
    }

    public void setToadId(String toadId) {
        this.toadId = toadId;
    }
}
