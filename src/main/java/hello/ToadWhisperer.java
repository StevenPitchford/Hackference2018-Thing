package hello;

import org.springframework.messaging.handler.annotation.SendTo;
import hello.beans.ToadControl;
import hello.beans.ToadControlActions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
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



	private ToadControl broadcast( ToadControl tc )
	{
		return tc;
	}

}