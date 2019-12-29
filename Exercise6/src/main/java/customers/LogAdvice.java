package customers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogAdvice {
	
	@Autowired
	private ILogger logger;
	
	/**
	 * a. Modify the application so that whenever the sendEmail method on the EmailSender is called,
	 *    a log message is created (using an after advice AOP annotation).
	 * b. The email address and the mail message should be logged too.
	 * c. Log the outgoing mail server too.
	 */
	@After("execution(* customers.EmailSender.sendEmail(..)) && args(email, message)")
	public void traceAfterEmailSender(JoinPoint joinPoint, String email, String message) {
		IEmailSender emailSender = (EmailSender) joinPoint.getTarget();
		logger.log("After execution of method " + joinPoint.getSignature().getName()
				+ "; email address = " + email
				+ "; message = " + message
				+ "; outgoing mail server = " + emailSender.getOutgoingMailServer() );
		
	}

}
