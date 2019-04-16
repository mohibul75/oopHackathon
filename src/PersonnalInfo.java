package application;

import application.Emp;

public class PersonnalInfo extends Emp {
	
	private String registrationNumber;
	private String name;
	private String address;
	private String fatherName;

	
	public PersonnalInfo(String registrationNumber, String name , String address,String fatherName) {
		
		
		this.registrationNumber=registrationNumber;
		this.name =name ;
		this.address=address;
		this.fatherName=fatherName;
		
	
	}
	
	


	public String getRegistrationNumber() {
		return registrationNumber;
	}




	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getFatherName() {
		return fatherName;
	}




	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}




	@Override
	public String toString() {
		return "PersonnalInfo [registrationNumber=" + registrationNumber + ", name=" + name + ", address=" + address
				+ ", fatherName=" + fatherName + "]";
	}
	
	
}
