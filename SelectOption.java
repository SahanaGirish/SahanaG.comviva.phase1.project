package sahana.g.comviva.phase1.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SelectOption {
	    //input data 
		private static Scanner keyboard = new Scanner(System.in);
		private static Scanner input = new Scanner(System.in);
		private static Scanner lockerInput = new Scanner(System.in);
		private static String filename = null;
		//output data 
			private static PrintWriter output=new PrintWriter(System.out);
			private static PrintWriter lockerOutput = new PrintWriter(System.out);
			static String option;
			
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			LockedMe user = new LockedMe();
			String userID = null;
			String confirmPassword = null;
			
			do {
				System.out.println("*--------------------------------------*");
				System.out.println("!!!GREETINGS, WELCOME TO LOCKEDME.COM!!!");
				System.out.println("*--------------------------------------*");
				System.out.println("Kindly choose one of the below mentioned options");
				System.out.println("1. Registration");
				System.out.println("2. Login");
				System.out.println("3. Exit");
				
				Scanner input = new Scanner(System.in);
				 String option = input.nextLine();
				if(option.equals("1")) {
					System.out.println("ENTER YOUR FIRST NAME:");
					String Name = user.setFirstName(input.next());
					System.out.println("ENTER YOUR LAST NAME:");
					String last = user.setLastName(input.next());
					System.out.println("ENTER YOUR EMAIL-ID:");
					String email =  user.setEmailID(input.next());
					System.out.println("ENTER YOUR USER NAME:");
					 userID = user.setUserName(input.next());
					System.out.println("ENTER YOUR PASSWORD:");
					String newPassword = (String) user.setNewpassword(input.next());
					System.out.println("CONFIRM YOUR PASSWORD:");
					 confirmPassword = user.setConpassword(input.next());
					 
					filename = Name;
					
					if(newPassword.equals(confirmPassword)) {
						System.out.println("*------------------------------------------------*");
						System.out.println("CONGRATULATIONS, YOUR REGISTRATION IS SUCCESSFULL!");
						System.out.println("*------------------------------------------------*");
					}else {
						System.out.println("*---------------------------*");
						System.out.println("SORRY, PASSWORD MISS MATCH :(");
						System.out.println("*---------------------------*");
					}
				}
				else if(option.equals("2")) {
					System.out.println("ENTER YOUR USER NAME:");
					String ID = user.setUserName(input.next());
					
					System.out.println("ENTER YOUR PASSWORD:");
					String pass = user.setPassword(input.next());
					
					if(pass.equals(confirmPassword) && ID.equals(userID)) {
						System.out.println("YOUR LOGIN IS SUCCESSFUL!");
						lockerOptions(ID);
						
					}else {
						System.out.println("INVALID USER ID OR PASSWORD :(");
					}
				}
				else if(option.equals("3")) {
					System.out.println("THANK YOU, DO VISIT US AGAIN!!! :)");
					System.exit(0);
				}
				else {
					System.out.println("Please choose the correct option");
				}
			}
			while(true);
		}
				public static void lockerOptions(String inpUsername) {
					System.out.println("1. STORE CREDENTIALS ");
					System.out.println("2. FETCH CREDENTIALS ");
					System.out.println("3. DELETE CREDENTIALS");
					int option = keyboard.nextInt();
					switch(option) {
						case 1 : 
							storeCredentials(inpUsername);
							break;
						case 2 :
							fetchCredentials(inpUsername);
							break;
						case 3:
							deleteCredentials(inpUsername);
							break;
						default :
							System.out.println("Please choose the correct option");
							break;
					}
			}
				
				public static void storeCredentials(String loggedInUser) {
					System.out.println("*------------------------------------------------------*");
					System.out.println("* WELCOME TO LOCKEDME.COM, ENTER YOUR CREDENTIALS HERE *");
					System.out.println("*------------------------------------------------------*");
					
	                 UserCredentials.setLoggedInUser(loggedInUser);
					
					System.out.println("Enter Site Name :");
					String siteName = keyboard.next();
					UserCredentials.setSiteName(siteName);
					
					System.out.println("Enter User ID :");
					String userID = keyboard.next();
					UserCredentials.setUserID(userID);
					
					System.out.println("Enter Password :");
					String password = keyboard.next();
					UserCredentials.setPassword(password);
					
					lockerOutput.println(UserCredentials.getLoggedInUser());
					lockerOutput.println(UserCredentials.getSiteName());
					lockerOutput.println(UserCredentials.getUserID());
					lockerOutput.println(UserCredentials.getPassword());
					//lockerOutput.close();
					List<String> list = new ArrayList<String>();
					Map<String, String> map = new HashMap<>();
					list.add(loggedInUser);
					list.add(siteName);
					list.add(userID);
					list.add(password);
					
					map.put("User Name", loggedInUser);
					map.put("Webite Name", siteName);					
					map.put("User-ID", userID);
					map.put("Password", password);
					
					System.out.println(map);
					filename = filename.concat(".");
					filename = filename.concat(siteName);
					FileOutputStream file = null;
					try {
						 file = new FileOutputStream(filename);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					ObjectOutputStream out = null;
					try {
						out = new ObjectOutputStream(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						out.writeObject(list);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						out.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						file.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					System.out.println("YOUR CREDENTIALS ARE SUCCESSFULLY STORED IN THE FILE!!!");
				
					lockerOptions(loggedInUser);
					
				}
				
				//fetch credentials
				public static void fetchCredentials(String inpUsername) {
					System.out.println("*------------------------------------*");
					System.out.println("* GREETINGS, WELCOME TO LOCKEDME.COM *");
					System.out.println("* YOUR CREDENTIALS ARE LISTED BELOW! *");
					System.out.println("*------------------------------------*");
					System.out.println(inpUsername);
					
					System.out.println("Site Name: "+ UserCredentials.getSiteName());
					System.out.println("User-ID: "+ UserCredentials.getUserID());
					System.out.println("Password: "+ UserCredentials.getPassword());		
						
					}
				
				//delete credentials
				private static void deleteCredentials(String inpUsername) {
					// TODO Auto-generated method stub
					
					File myObj = new File(filename); 
				    if (myObj.delete()) { 
				      System.out.println("Deleted the file: " + myObj.getName());
				    } 
				    else {
				      System.out.println("Failed to delete the file");
				    } 
		   } 
	}


