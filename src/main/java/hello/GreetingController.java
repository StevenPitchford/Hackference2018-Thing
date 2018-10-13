package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class GreetingController {

	@Autowired
	private FifoQueue fq;
	@Autowired
	private BishBashBosh bbb;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {

        return new Greeting(HtmlUtils.htmlEscape(message.getName()));
	

	}

	@SendTo("/topic/button")
	public Greeting button(HelloMessage message) throws Exception{
		return new Greeting(HtmlUtils.htmlEscape(message.getName()));
	}
}