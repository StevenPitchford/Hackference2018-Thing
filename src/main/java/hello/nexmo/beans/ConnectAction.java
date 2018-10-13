package hello.nexmo.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// TODO Turn into ConnectAction

public class ConnectAction implements Serializable
{

	private List endpoint = new ArrayList();
	private String action = "connect" ;

	public ConnectAction()
	{
		ConnectActionEndpoint ne = new ConnectActionEndpoint();
		getEndpoint().add(ne);
	}

    public List getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(List endpoint) {
        this.endpoint = endpoint;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
