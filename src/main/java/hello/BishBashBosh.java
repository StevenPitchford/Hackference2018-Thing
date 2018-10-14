package hello;

import org.springframework.messaging.handler.annotation.SendTo;
import hello.hello.beans.ToadControl;
import hello.hello.beans.ToadControlActions;
import org.springframework.web.util.HtmlUtils;

public class BishBashBosh
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