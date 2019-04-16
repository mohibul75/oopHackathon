package application;

public class InvalidRegistrationNumberException extends Exception {
	
	private String registrationNumber;
	
	public InvalidRegistrationNumberException(String registrationNumber) {
		
		super("Invalid Registration Number		"+registrationNumber);
		this.registrationNumber=registrationNumber;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	

}