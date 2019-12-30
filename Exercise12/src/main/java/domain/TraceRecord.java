package domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class TraceRecord {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRACERECORD_SEQ")
	private long id;
	@Column(columnDefinition = "DATE DEFAULT CURRENT_DATE", nullable = false)
	private Date date = new Date();
	private String name;
	
	public TraceRecord() {}
	
	public TraceRecord(String name) {
		super();
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
