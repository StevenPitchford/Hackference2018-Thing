package hello.beans;

import java.io.Serializable;

public class ToadControl implements Serializable {

    private String command;
    private String toadID;
    private Integer pitch = null;


    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setCommand(ToadControlActions command) {
        this.command = command.toString();
    }

    public String getToadID() {
        return toadID;
    }

    public void setToadID(String toadID) {
        this.toadID = toadID;
    }

    public Integer getPitch() {
        return pitch;
    }

    public void setPitch(Integer pitch) {
        this.pitch = pitch;
    }
}
