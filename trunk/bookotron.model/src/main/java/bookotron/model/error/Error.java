package bookotron.model.error;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Error")
public class Error {

	private String message;
	
	public Error(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
