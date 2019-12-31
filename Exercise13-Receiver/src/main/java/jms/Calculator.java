package jms;

import org.springframework.stereotype.Service;

@Service
public class Calculator {

	private int value = 0;
	
	public Calculator() {
	}
	
	public int processCalculateRequest(String message) {
		
		String calcType = message.substring(0, 1);
		int calcValue = Integer.parseInt(message.substring(1));
		
		System.out.println("processCalculateRequest: message = " + message + ", calcType = " + calcType + ", calcValue = " + calcValue);
		
		switch(calcType) {
			case "+":
				value += calcValue;
				break;
			case "-":
				value -= calcValue;
				break;
			case "*":
				value *= calcValue;
				break;
			case "/":
				value /= calcValue;
				break;
			default:
				// do nothing.
		}
		return value;
	}
}
