package hello;

import org.springframework.messaging.handler.annotation.SendTo;
import hello.beans.ToadControl;
import hello.beans.ToadControlActions;

public class ToadWhisperer
{

	public void addToad( String id )
	{
		ToadControl tc = new ToadControl();
		tc.setCommand(ToadControlActions.Add);
		tc.setToadID(id);
		broadcast( tc );
	}

	public void removeToad( String id )
	{
		ToadControl tc = new ToadControl();
		tc.setCommand(ToadControlActions.Remove);
		tc.setToadID(id);
		broadcast( tc );
	}

	public void croakToad( String id, Integer pitch )
	{
		ToadControl tc = new ToadControl();
		tc.setCommand(ToadControlActions.Croak);
		tc.setToadID(id);
		tc.setPitch(pitch);
		broadcast( tc );
	}

	@SendTo("/topic/toadcontrol")
	private ToadControl broadcast( ToadControl tc )
	{
		return tc;
	}

}