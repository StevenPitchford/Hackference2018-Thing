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
/*
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
	// Add to FIFO

	fq.put (message.getName());

        Thread.sleep(1000); // simulated delay
	StringBuilder sb = new StringBuilder();

        return new Greeting("Hello, " + HtmlUtils.htmlEscape(fq.pop()) + "!");
//        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
*/

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
      public Greeting greeting(HelloMessage message) throws Exception {

        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	
//	bbb.doStuff(message.getName());
	}
}