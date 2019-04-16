package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MainController {

	private String registrationNumber;
	private String cgpa;
	private String batch;
	private String roll;
	private String name;
	private String address;
	private String fatherName;
	private String PersonnelFileName = "personnelInfo.txt";
	private String academicFileName = "academicInfo.txt";
	private AcademicInfo studentAcademicInfo;
	private PersonnalInfo studentPersonnalInfo;
	private ArrayList<PersonnalInfo> listOfPersonnelInfo = new ArrayList<>();
	private ArrayList<AcademicInfo> listOfAcademicInfo = new ArrayList<>();
	private String faltu;
	private Scanner input = new Scanner(System.in);
	private int j=0;

	public void main() throws InvalidRegistrationNumberException {

		MainController object = new MainController();
		Scanner input = new Scanner(System.in);
		String faltu;

		while (true) {
			System.out.println("Enter your choice :" + "\n" + "1.Add New Information" + "\n" + "2.serach Information"
					+ "\n" + "3.Exit");
			int choice;
			String reg = null;

			choice = input.nextInt();

			if (choice == 1) {
				
				try {
				object.fileWrite();
				
				faltu=input.nextLine();
			} catch(Exception e) {
				System.out.println(e);
			}
			}
			else if (choice == 2) {
				
				object.search();
				
				faltu=input.nextLine();
			}

			else
				break;

		}

	}

	public void fileWrite() throws InvalidRegistrationNumberException {

		Scanner input = new Scanner(System.in);
		boolean bl=false;

		System.out.println("enter your personnal Info : ");

		registrationNumber = input.nextLine();
		
		if(j!=0)
			bl = searchReg(registrationNumber);
		j++;
		
		if(bl==true) {
			
			throw new InvalidRegistrationNumberException(registrationNumber );
			
			
		}
		
		
		
		name = input.nextLine();
		address = input.nextLine();
		fatherName = input.nextLine();

		studentPersonnalInfo = new PersonnalInfo(registrationNumber, name, address, fatherName);

		try {
			FileOutputStream file = new FileOutputStream(PersonnelFileName);
			ObjectOutputStream out = new ObjectOutputStream(file);

			listOfPersonnelInfo.add(studentPersonnalInfo);

			out.writeObject(listOfPersonnelInfo);
			out.close();
			file.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("enter your academic Info : ");

		cgpa = input.nextLine();
		batch = input.nextLine();
		roll = input.nextLine();
		
	//	faltu=input.nextLine();

		studentAcademicInfo = new AcademicInfo(registrationNumber, cgpa, batch, roll);

		try {
			FileOutputStream file = new FileOutputStream(academicFileName);
			ObjectOutputStream out = new ObjectOutputStream(file);

			listOfAcademicInfo.add(studentAcademicInfo);

			out.writeObject(listOfAcademicInfo);
			out.close();
			file.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void search() {
		
		String searchRegistrationNumber;
		System.out.println("enter Registration Number : ");
		searchRegistrationNumber  = input.nextLine();

		try {
			FileInputStream file = new FileInputStream(PersonnelFileName);
			ObjectInputStream in = new ObjectInputStream(file);

			try {


				listOfPersonnelInfo = (ArrayList<PersonnalInfo>) in.readObject();

				for (int i = 0; i < listOfPersonnelInfo.size(); i++) {

					studentPersonnalInfo = listOfPersonnelInfo.get(i);
					String reg = studentPersonnalInfo.getRegistrationNumber();
					

					if (reg.equals(searchRegistrationNumber)) {

						System.out.println(studentPersonnalInfo.toString());
					}

					studentPersonnalInfo = null;

				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			in.close();
			file.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//THIS TRY-CATCH IS FOR aCADEMIC INFO
		
		try {
			FileInputStream file1 = new FileInputStream(academicFileName );
			ObjectInputStream in1= new ObjectInputStream(file1);

			try {

				listOfAcademicInfo = (ArrayList<AcademicInfo>) in1.readObject();

				for (int i = 0; i < listOfPersonnelInfo.size(); i++) {

					studentAcademicInfo = listOfAcademicInfo.get(i);
					String reg = studentAcademicInfo.getRegistrationNumber();

					if (reg.equals(searchRegistrationNumber)) {

						System.out.println(studentAcademicInfo.toString());
					}

					studentAcademicInfo = null;

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			in1.close();
			file1.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public boolean searchReg(String Newreg) {
		
		boolean bl=false;
		
		try {
			FileInputStream file = new FileInputStream(PersonnelFileName);
			ObjectInputStream in = new ObjectInputStream(file);

			try {


				listOfPersonnelInfo = (ArrayList<PersonnalInfo>) in.readObject();

				for (int i = 0; i < listOfPersonnelInfo.size(); i++) {

					studentPersonnalInfo = listOfPersonnelInfo.get(i);
					String reg = studentPersonnalInfo.getRegistrationNumber();
					

					if (reg.equals(Newreg)) {
						
						System.out.println(reg+"\t"+Newreg);

						bl=true;
						break;
					}

					studentPersonnalInfo = null;

				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			in.close();
			file.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return bl;
		
	}

}
