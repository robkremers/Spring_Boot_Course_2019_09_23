package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, SensorRecord> kafkaTemplate;
    
    public void send(String topic, SensorRecord sensorRecord){
//    	System.out.println("sending message=" + sensorRecord.toString() + " to topic="+ topic);
        kafkaTemplate.send(topic, sensorRecord);
    }
}
