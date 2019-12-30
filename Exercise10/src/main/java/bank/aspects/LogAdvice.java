package bank.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import bank.logging.ILogger;

@Aspect
@Configuration
public class LogAdvice {
	
	@Autowired
	private ILogger logger;
	
	@After("execution(public * bank.dao.*.*(..) )")
	public void traceAfterBankDao(JoinPoint joinPoint) {
		
		logger.log("method = " + joinPoint.getSignature().getName());
		
	}
	
	@After("execution(public * bank.jms.JMSSender.sendJMSMessage(..)) && args(text)")
	public void traceAfterJmsSender(JoinPoint joinPoint, String text) {
		
		logger.log( "method = " + joinPoint.getSignature().getName()
				  + " JMS text = " + text);
		
	}

}
