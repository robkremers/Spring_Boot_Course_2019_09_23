package customers.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import customers.ILogger;

@Aspect
@Configuration
public class StopwatchAdvice {
	
	@Autowired
	private ILogger logger;
	
	/**
	 * Write a new advice that calculates the duration of the method calls to the DAO object and
	 * outputs the result to the console.
	 */
	@Around("execution(public * customers.CustomerDAO.save(..))")
	public Object traceCustomerDAODuration(ProceedingJoinPoint call) throws Throwable {
		
		StopWatch stopWatch = new StopWatch("");
		stopWatch.start(call.getSignature().getName());
		
		Object object = call.proceed();
		
		stopWatch.stop();
		logger.log(stopWatch.prettyPrint());
		
		long totalTime = stopWatch.getTotalTimeMillis();
		logger.log("Time to execute " + call.getSignature().getName() + ": " + totalTime + " ms.");
		
		return object;
	}
	
}
