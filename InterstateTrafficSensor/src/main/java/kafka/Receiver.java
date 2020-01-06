package kafka;


import java.util.HashMap;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

	@Value("${app.topic.tofasttopic}")
	private String tofastTopic;
	
	@Value("${app.speedlimit}")
	private int speedLimit;
	
	HashMap<String, SensorRecord> sensorRecordMap;
	
	public Receiver() {
		sensorRecordMap = new HashMap<>();
	}
	
    @KafkaListener(topics = {"cameratopic1" , "cameratopic2"})
    public void receive(@Payload SensorRecord sensorRecord,
                        @Headers MessageHeaders headers) {
        System.out.println("received message = " + sensorRecord.toString());
        
        System.out.println("sensorRecordMap: " + Objects.nonNull(sensorRecordMap));
        
        // Save the content of camera 1.
        if (Objects.nonNull(sensorRecord) && sensorRecord.getCameraId() == 1 ) {
        	sensorRecordMap.put(sensorRecord.getLicencePlate(), sensorRecord);
        	System.out.println(sensorRecord.toString() + " has been stored.");
        }
    }

}