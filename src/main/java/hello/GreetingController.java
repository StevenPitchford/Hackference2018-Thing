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

	@MessageMapping("/button")
	@SendTo("/topic/button")
	public Greeting button(WebDial dial) throws Exception{

		System.out.println("");
		System.out.println("");
		System.out.println("CAKE");
		System.out.println("");
		System.out.println("");

		return new Greeting(HtmlUtils.htmlEscape(String.valueOf(dial.pitch)));
	}
}