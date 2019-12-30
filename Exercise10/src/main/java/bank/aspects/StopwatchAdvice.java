package bank.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import bank.logging.ILogger;

@Aspect
@Configuration
public class StopwatchAdvice {
	
	@Autowired
	private ILogger logger;
	
	@Around("execution(public * bank.service.*.*(..) )")
	public Object traceBankServiceDuration(ProceedingJoinPoint call) throws Throwable {
		
		StopWatch stopWatch = new StopWatch("");
		stopWatch.start(call.getSignature().getName());
		
		Object object = call.proceed();
		
		stopWatch.stop();
		
		long totalTime = stopWatch.getTotalTimeMillis();
		logger.log("Time to execute " + call.getSignature().getName() + ": " + totalTime + " ms.");
		
		
		return object;
		
	}

}
