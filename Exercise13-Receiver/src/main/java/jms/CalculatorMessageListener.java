package jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class CalculatorMessageListener {
	
	@Autowired
	private Calculator calculator;
	
	public CalculatorMessageListener() {
		calculator = new Calculator();
	}
	
    @JmsListener(destination = "calcQueue")
    public void receiveMessage(final String message) {
    	
    	int calculatedValue = calculator.processCalculateRequest(message);
    	
    	System.out.println("JMS receiver received message:" + message + ", calculated  value = " + calculatedValue);
    }


}
