package kafka;

import java.io.Serializable;

//import java.time.LocalTime;

public class SensorRecord {
	
	public String licencePlate;
	public int minute;
	public int second;
	public int cameraId;

	public SensorRecord(String licencePlate, int minute, int second, int cameraId) {
		super();
		this.licencePlate = licencePlate;
		this.minute = minute;
		this.second = second;
		this.cameraId = cameraId;
	}

	public SensorRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLicencePlate() {
		return licencePlate;
	}

	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}


	public int getCameraId() {
		return cameraId;
	}

	public void setCameraId(int cameraId) {
		this.cameraId = cameraId;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cameraId;
		result = prime * result + ((licencePlate == null) ? 0 : licencePlate.hashCode());
		result = prime * result + minute;
		result = prime * result + second;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SensorRecord other = (SensorRecord) obj;
		if (cameraId != other.cameraId)
			return false;
		if (licencePlate == null) {
			if (other.licencePlate != null)
				return false;
		} else if (!licencePlate.equals(other.licencePlate))
			return false;
		if (minute != other.minute)
			return false;
		if (second != other.second)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SensorRecord [licencePlate=" + licencePlate + ", minute=" + minute + ", second=" + second
				+ ", cameraId=" + cameraId + "]";
	}

}
