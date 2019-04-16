package application;

import application.Emp;

public class AcademicInfo  extends Emp {
	

	private String registrationNumber;
	private String cgpa;
	private String batch;
	private String roll;
	
	public  AcademicInfo(String registrationNumber, String cgpa,String batch,String roll) {
		
		this.registrationNumber=registrationNumber;
		this.cgpa=cgpa;
		this.batch=batch;
		this.roll=roll;
		
	}
	
	@Override
	public String toString() {
		return "AcademicInfo [registrationNumber=" + registrationNumber + ", cgpa=" + cgpa + ", batch=" + batch
				+ ", roll=" + roll + "]";
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getCgpa() {
		return cgpa;
	}

	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}
	
	

}
