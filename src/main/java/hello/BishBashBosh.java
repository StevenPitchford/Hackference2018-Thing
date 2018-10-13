package hello;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.util.HtmlUtils;

public class BishBashBosh
{

	public void doStuff( String s )
	{
		broadcast( s );
	}
	
	@SendTo("/topic/greetings")
	private Greeting broadcast( String s )
	{
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(s) + "!");
	}

}