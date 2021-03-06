package customers;

import org.springframework.beans.factory.annotation.Value;

public class EmailSender implements IEmailSender {
	private String outgoingMailServer = "smtp.acme.com";
	private ILogger logger;
	
	@Value(value = "smtp.mailserver.com")
	private String emailServer;
	
	public EmailSender() {
	}
	
	public EmailSender(ILogger logger) {
		this.logger = logger;
	}

	public String getOutgoingMailServer() {
		return outgoingMailServer;
	}

	public void sendEmail (String email, String message){
		System.out.println("EmailSender: sending '"+message+"' to "+email + " using mailserver " + emailServer );
		logger.log("Email is sent: message= "+message +" , emailaddress ="+ email  );
	}
}
