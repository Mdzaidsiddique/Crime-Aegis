package com.masaischool.CIMS;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.masaischool.Dao.CrimeDao;
import com.masaischool.Dao.CrimeDaoImpl;
import com.masaischool.Dao.CriminalDao;
import com.masaischool.Dao.CriminalDaoImpl;
import com.masaischool.Entity.Address;
import com.masaischool.Entity.Crime;
import com.masaischool.Entity.Criminal;
import com.masaischool.Entity.PoliceStation;
import com.masaischool.Entity.Victim;
import com.masaischool.Exceptions.CrimeException;
import com.masaischool.Exceptions.NoRecordFoundException;
import com.masaischool.Exceptions.SomeThingWentWrongException;

public class App {
	
	private static boolean loggedIn = false;
	
	
	// <!-- Admin login -->
	public static void AdminlogIn(String user, String pass) {
		if(user.equals("admin") && pass.equals("admin")) {
			loggedIn = true;
			System.out.println("login Successfull");
		}else {
			System.out.println("Wrong Credentials, Please Try Again");
		}
	}
	
	public static void addCrimeUI(Scanner sc) {
		
		System.out.println("Crime Type ? (Theft/Murder/Robbery/Extortion etc)");
		String crimeType = sc.next();
		
		System.out.println("Crime Description ?");
		String crimeDescription = sc.next();
		
		System.out.println("Enter crime Police Station Area");
		String psArea = sc.next();
		
		System.out.println("Date of Crime");
		LocalDate crimeDate = LocalDate.parse(sc.next());
		
		System.out.println("Enter Victim Name");
		String VictimName = sc.next();
		
		System.out.println("Enter Crime Id");
		int cId = sc.nextInt();
		
		System.out.println("Enter City Name");
		String city = sc.next();
		
		System.out.println("Enter State Name");
		String state = sc.next();
		
		System.out.println("Enter Zip Code");
		int zip = sc.nextInt();
		
		Address ad1 = new Address(city, state, zip);
		
		System.out.println("Enter Police Station Name");
		String psName = sc.next();
		
		PoliceStation p1 = new PoliceStation(psName, psArea, cId, ad1);
		Set<PoliceStation> ps1 = new HashSet<>();
		ps1.add(p1);
		
		System.out.println("Enter Victim age");
		int vAge = sc.nextInt();
		
		System.out.println("Enter Victim Gender");
		String gender = sc.next();
		
		Criminal criminal1 = new Criminal();
		
		Crime crime1 = new Crime();
		
		Victim v1 = new Victim(VictimName, ad1, vAge, gender, p1.getPs_id(), cId, ps1, criminal1, crime1);
		

		Set<Criminal> criminalSet1 = new HashSet<>();
		
		Crime crimeOne = new Crime(crimeType, crimeDescription, psArea, crimeDate , VictimName, ps1, v1, criminalSet1);
		
		CrimeDao cd= new CrimeDaoImpl();
		
		try {
			
			cd.addCrime(crimeOne);
			System.out.println("Crime Details Added Successfully!!!!");
			
		} catch (CrimeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void updateCrimeById(Scanner sc) {
		System.out.println("Enter Crime Id");
		int crimeId = sc.nextInt();
		
		
		

	}
	
	
	public static void addCriminalUI(Scanner sc) {
		// TODO Auto-generated method stub

	}
	
	public static void updateCriminalByIdUI(Scanner sc) {
		// TODO Auto-generated method stub

	}
	
	public static void assignCriminalToCrimeByIdUI(Scanner sc) {
		// TODO Auto-generated method stub

	}
	
	public static void removeCriminalFrimCrimeByIdUI(Scanner sc) {
		// TODO Auto-generated method stub

	}
	public static void deleteCrimeByIdUI(Scanner sc) throws NoRecordFoundException, SomeThingWentWrongException, CrimeException {
		System.out.println("Enter Crime Id");
		int crimeId = sc.nextInt();
		CrimeDao cd = new CrimeDaoImpl();
		cd.deleteCrime(crimeId);
		System.out.println("Crime Details Deleted Successfully !");

	}
	//
	public static void deleteCriminalByIdUI(Scanner sc) throws NoRecordFoundException, SomeThingWentWrongException {
		System.out.println("Enter Criminal Id");
		int criminalId = sc.nextInt();
		CriminalDao cd = new CriminalDaoImpl();
		cd.deleteCriminalById(criminalId);
		System.out.println("Criminal Details Deleted Successfully !");

	}
//	<!--Admin Functionality Ends here-->
	
//	<!--Public logIn and public functionality starts here-->
	
	public static void publicLogin() { 
		loggedIn = true;
		System.out.println("Login Successfull"); 
	}
	
	public static void viewTotalCrimeByEachPoliceStationUI() {
		// TODO Auto-generated method stub

	}
	
	public static void viewTotalCrimeByCrimeTypeUI() {
		// TODO Auto-generated method stub

	}
	
	public static void searchCriminalByName(Scanner sc) {
		// TODO Auto-generated method stub

	}
	public static void searchCrimeByDescription(Scanner sc) {
		// TODO Auto-generated method stub

	}
	
	
    public static void main( String[] args ) throws NoRecordFoundException, SomeThingWentWrongException, CrimeException {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("🦋🌷🌷🦋"+ "  🕵️👮🏼🕵  "+ "🦋🌷🌷🦋");
    	System.out.println("Crime Information Management System");
    	System.out.println("🦋🌷🌷🦋"+ "  🕵️👮🏼🕵  "+ "🦋🌷🌷🦋");
    	
    	System.out.println("\n"+"Select 1️⃣ for Admin login" +"\n"+ "Select 2️⃣ for Public login");
    	
    	int loginChoice = sc.nextInt();
    	
    	if(loginChoice==1) {
    		System.out.println("Enter UserName");
        	String user = sc.next();
        	System.out.println("Enter Password");
        	String pass = sc.next();
        	AdminlogIn(user, pass);
        	
        	if(loggedIn) {
        		System.out.println("Welcome to Admin side of CIMS...!!!");
        		System.out.println("Please Select below Option...!");
        		
        		System.out.println(" 1 : Add Crime Details");
        		System.out.println(" 2 : Update Crime Details");
        		System.out.println(" 3 : Add Criminal Details");
        		System.out.println(" 4 : Update Criminal Details");
        		System.out.println(" 5 : Assign criminals to crime.");
        		System.out.println(" 6 : remove criminal from crime.");
        		System.out.println(" 7 : delete crime using crime_id");
        		System.out.println(" 8 : delete criminal using criminal_id");
        		System.out.println(" 0 : Log out !!!");
        		
        		int adminChoice = sc.nextInt();
        		do {
        			switch(adminChoice) {
        			case 1 : 
        				addCrimeUI(sc);
        				break;
        			case 2 :
        				updateCrimeById(sc);
        				break;
        			case 3 : 
        				addCriminalUI(sc);
        				break;
        			case 4 :
        				updateCriminalByIdUI(sc);
        				break;
        			case 5 : 
        				assignCriminalToCrimeByIdUI(sc);
        				break;
        			case 6 :
        				removeCriminalFrimCrimeByIdUI(sc);
        				break;
        			case 7 : 
        				deleteCrimeByIdUI(sc);
        				break;
        			case 8 :
        				deleteCriminalByIdUI(sc);
        				break;
        			case 0 :
        				loggedIn = false;
        				System.out.println("Log Out Successfull !!!");
        				break;
        			default:
        				System.out.println("Invalid Selection, please chech again ");
        			}
				} while (adminChoice!=0);
        		
        	}
        	
    	}else if(loginChoice==2) {
    		publicLogin();
    		if(loggedIn) {
        		System.out.println("Welcome to Public side of CIMS...!!!");
        		System.out.println("Please Select below Option...!");
        		
        		System.out.println(" 1 : View Total Crime By Each Police Station Area for a Date Range");
        		System.out.println(" 2 : view total crime for each crime type for a date range.");
        		System.out.println(" 3 : search for criminal by name");
        		System.out.println(" 4 : search for crime by description");
        		System.out.println(" 0 : Exit !!!");
        		
        		int adminChoice = sc.nextInt();
        		do {
        			switch(adminChoice) {
        			case 1 : 
        				viewTotalCrimeByEachPoliceStationUI();
        				break;
        			case 2 :
        				viewTotalCrimeByCrimeTypeUI();
        				break;
        			case 3 : 
        				searchCriminalByName(sc);
        				break;
        			case 4 :
        				searchCrimeByDescription(sc);
        				break;
        			case 0 :
        				loggedIn = false;
        				System.out.println("Thank You !!!");
        				break;
        			default:
        				System.out.println("Invalid Selection, please chech again ");
        			}
				} while (adminChoice!=0);
        		
        	}
    		
    		
    	}else {
    		System.out.println("Please Enter the Valid Option");
    	}
    	sc.close();
    }
}
