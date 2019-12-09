package customers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service("logger")
public class Logger implements ILogger{

	public void log(String logstring) {
		System.out.println("Logging "+LocalDateTime.now()+" "+logstring);		
	}

}
