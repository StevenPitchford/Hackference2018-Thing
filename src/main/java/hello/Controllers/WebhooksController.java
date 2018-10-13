package hello.Controllers;

import hello.nexmo.beans.ConnectAction;
import hello.nexmo.beans.TalkAction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WebhooksController {

    @RequestMapping("/webhooks/answer_url")
    public List AnswerURL()
    {
        List<Object> response = new ArrayList<Object>();

        response.add( new TalkAction() );
        response.add( new ConnectAction() );

        return response;
    }

}
