package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Controller {
	
	@FXML
	private TextField Name;
	
	@FXML
	private TextField FatherName;
	
	@FXML
	private TextField reg;
	
	@FXML
	private TextField Address;
	
	@FXML
	private TextField Cgpa;
	
	@FXML
	private TextField Batch;
	
	@FXML
	private TextField Roll;
	
	private String registrationNumber=null;
	private String cgpa;
	private String batch;
	private String roll;
	private String name=null;
	private String address=null;
	private String fatherName=null;
	private String PersonnelFileName = "personnelInfo.txt";
	private String academicFileName = "academicInfo.txt";
	private AcademicInfo studentAcademicInfo;
	private PersonnalInfo studentPersonnalInfo;
	private ArrayList<PersonnalInfo> listOfPersonnelInfo = new ArrayList<>();
	private ArrayList<AcademicInfo> listOfAcademicInfo = new ArrayList<>();
	private String faltu;
	private Scanner input = new Scanner(System.in);
	private int j=0;
	
	@FXML
	private AnchorPane rootPane;
	
	@FXML
	private AnchorPane rootPane1;
	
	@FXML
	public void printInformation() throws Exception {
		
				Parent pane2;
				pane2 = FXMLLoader.load(getClass().getClassLoader().getResource("application/PrintCertificate.fxml"));
			
				rootPane.getChildren().setAll(pane2);
		
			
				String searchRegistrationNumber="3333";

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
		
		
		
		
	
	@FXML
	public void addInfo(ActionEvent event) throws IOException {
		
		Parent pane1 = FXMLLoader.load(getClass().getClassLoader().getResource("application/AddInfo.fxml"));
		rootPane.getChildren().setAll(pane1);
		
		try {
		name=(String)this.Name.getPromptText();
		//address=(String)Address.getText();
		//fatherName=(String)FatherName.getText();
		//registrationNumber=(String)reg.getText();
		
		System.out.println(name);
		
		
		} catch(Exception e) {
			
			System.out.println(e);
		}
		
		
	}
	
	@FXML
	public void next(ActionEvent event) throws IOException {
		
		Parent pane1 = FXMLLoader.load(getClass().getClassLoader().getResource("application/AcademicInfo.fxml"));
		rootPane1.getChildren().setAll(pane1);
		
		//System.out.println(Cgpa.getText());
		
		//cgpa=Cgpa.getText();
		//batch=Batch.getText();
		//roll=Roll.getText();
		
		
		
	}
	
	@FXML
	public void exit() {
		
		System.exit(0);
		
	}

}
