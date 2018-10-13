package hello.nexmo.beans;

/*

[
    {
       "action": "connect",
       "endpoint": [
           {
                "type": "websocket",
                "uri": "wss://example.com/socket",
                "content-type": "audio/l16;rate=16000",
                "headers": {
                    "prop1": "value1",
                    "prop2": "value2"
                }
           }
       ]
     }
]

	private List endpoint = new ArrayList(); 
	private String action = "Connect" ;


*/


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ConnectActionEndpoint implements Serializable
{
	private String type = "websocket";
	private String uri = "wss://toadcall.cleverapps.io/nexmo-socket2";
	private String contentType = "audio/l16;rate=8000";
	private Map<String,String> headers = new HashMap<String,String>();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
}
