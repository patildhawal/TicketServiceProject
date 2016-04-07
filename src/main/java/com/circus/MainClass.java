/**
 * 
 */
package com.circus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.circus.Seat;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


/**
 * @author Dhawal Patil
 *
 */
public class MainClass {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	System.out.println("----------Welcome to the Circus Event--------------");
		
	TicketServiceImpl ticketService = new TicketServiceImpl();
	
	 Scanner scan = new Scanner(System.in);
	 try {
		 
		 while(true){
			 int input = callMainMenu(scan);
			 
		  
		 allInnerLoops:
		 switch(input){
		 
		 case 0:
			 System.out.println("Thank you for using the Ticketing System. Have a Great Day ahead!!");
			 System.exit(0);
			 
		 case 1:  
			 
			 while(true) {
			 System.out.println("\n---------Seat Availibility Menu---------");
			 
			 
			 System.out.println("To Check for Seat availability at: \n"
			 		+ "     Orchestra Level:   Press 1\n"
					+ "          Main Level:   Press 2\n"
			 		+ "     Balcony 1 Level:   Press 3\n"
					+ "     Balcony 2 Level:   Press 4\n"
			 		+ "  Total Availibility:   Press 5\n"
					+ "Go back to Main Menu:   Press 0\n");
			 
			String readLine = scan.nextLine();
			 int inputSubMenu = Integer.parseInt(readLine);
				 //System.out.println("You entered: "+readLine+" in Sub Main "+inputSubMenu);
			  
			 if(inputSubMenu == 1)
				 System.out.println("Seats available at Orchestra Level: "+ticketService.numSeatsAvailable(1));
			 else if(inputSubMenu == 2)
				 System.out.println("Seats available at Main Level: "+ticketService.numSeatsAvailable(2));
			 else if(inputSubMenu == 3)
				 System.out.println("Seats available at Balance 1 Level: "+ticketService.numSeatsAvailable(3));
			 else if(inputSubMenu == 4)
				 System.out.println("Seats available at Balance 2 Level: "+ticketService.numSeatsAvailable(4)); 
			 else if(inputSubMenu == 5)
				 System.out.println("Total Seats available: "+ticketService.numSeatsAvailable());
			 else if(inputSubMenu == 0)
				 break allInnerLoops;
			 else 
				 System.out.println("Incorrect input entered, try again ");
			
			 }
			 
		 case 2:
			 
			 while(true) {
			 
				 System.out.println("\n---------	Find and Hold Seats Menu---------");
			 
				 System.out.println("Enter the number of seats you would like to hold:  ");
				 String readLine = scan.nextLine();
				 int numSeats = Integer.parseInt(readLine);
//					 System.out.println("User is booking seats for "+readLine+" in Find and Hold Seats "+numSeats);
					 
				 System.out.println("(Optional) Enter the desired Minimum seating level. Hit Enter to skip this step ");
					 readLine = scan.nextLine();
					 int minLevel = 0;
					 if (readLine.isEmpty()) {
				            System.out.println("You have not chosen any Minimum Level. We will choose the best seats for you");
				        }
					 else {
						 minLevel = Integer.parseInt(readLine);
//					 	System.out.println("User chooses minimum level as "+readLine+" in Minimum level "+minLevel);
					 }
					 
					 	
					 	
			 	System.out.println("(Optional) Enter the desired Maximum seating level. Hit Enter to skip this step");
					 readLine = scan.nextLine();
					 int maxLevel = 0;
					 if (readLine.isEmpty()) {
				            System.out.println("You have not chosen any Maximum Level. We will choose the best seats for you");
				        }
					 else {
					 maxLevel = Integer.parseInt(readLine);
//					 	System.out.println("User chooses Maximum level as "+readLine+" in Maximum level "+maxLevel);
					 }
					 	
			 	System.out.println("Enter your email-id");
					 String customerEmail = scan.nextLine();
					 	System.out.println("Email-id you entered is: "+customerEmail+". We will send details of this ticket to this email id");
				
				SeatHold seatHold = null;
					 	
				if(minLevel==0)
				 seatHold = ticketService.findAndHoldSeats(numSeats, customerEmail);
		 	
				else if(maxLevel==0)
					 seatHold = ticketService.findAndHoldSeats(numSeats, minLevel, customerEmail);	 	
			
				else
				 seatHold = ticketService.findAndHoldSeats(numSeats, minLevel, maxLevel, customerEmail);
				 
				if(null == seatHold || seatHold.getSeats().size()==0){
					 System.out.println("Sorry, all tickets are Sold Out");
					 break allInnerLoops;
				 }
				 
				 seatHold.getSeatInfo();
			 
				 System.out.println("\nWould you like to Continue booking another ticket? \n"
				 		+ "Press 1 for Yes or \n"
				 		+ "2 for No");
				 readLine = scan.nextLine();
				 
				 int nextStep = Integer.parseInt(readLine);
				 	if(nextStep == 1)continue;
				 	else if(nextStep == 2) break allInnerLoops;
				 	else System.out.println("Invalid Input, please retry ");
				 	
			 }
			 
			 
			 
		 case 3:   
			 while(true) {
				 System.out.println("\n---------	Reserve your Seats ---------");
				 
				 System.out.println("Please Enter your SeatHoldId:  ");
				 String readLine = scan.nextLine();
				 int seatHoldId = Integer.parseInt(readLine);
//				 System.out.println("SeatHoldId user entered is "+readLine+" and the int is "+seatHoldId);
			 	
				 System.out.println("Please Enter your EmailId:  ");
				 String customerEmail = scan.nextLine();
				 System.out.println("Email-id you entered is: "+customerEmail+". We will send the confirmation to this email-id");
			 	
				 
				 String reservationConfirmation = ticketService.reserveSeats(seatHoldId, customerEmail); 
				 if(null == reservationConfirmation || reservationConfirmation.equalsIgnoreCase("")){
					 System.out.println("Sorry, you don't have any tickets on Hold");
					 System.out.print("Please have your tickets on hold, then try to Reserve!!\n");
					 break allInnerLoops;
				 }
				 System.out.println("Congratulations!! Your Tickets have been successfully reserved.");
				 System.out.println("Your reservation confirmation code is " +reservationConfirmation);
				 
				 System.out.println("Would you like to Continue Reserving another ticket? \n"
					 		+ "Press 1 for Yes or \n"
					 		+ "2 for No");
					 readLine = scan.nextLine();
					 
					 int nextStep = Integer.parseInt(readLine);
					 	if(nextStep == 1)continue;
					 	else if(nextStep == 2) break allInnerLoops;
					 	else System.out.println("Invalid Input, please retry ");
				 
		 	}
			 
			 
			 default: 
				 System.out.println("Invalid input. Please try again"); break;
		 		 
		 }
		 
		 	  
	}
		
		
	} 
	 catch(ParseException p){
		 System.out.println("Please input valid integers only");
	 }
	 
	 catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Invalid Input, please retry running again");
	}

}

	private static int callMainMenu(Scanner scan) {
		// TODO Auto-generated method stub
		
		System.out.println("\n-------Main Menu-----------");
		 
		 System.out.println("Press 1 to Check for Seat availability: \n"
			 		+ "Press 2 to Hold Seats and\n"
					+ "Press 3 to Reserve Seats held by you\n"
					+ "Press 0 to Exit\n");
		 String readLine = scan.nextLine();
		 
		 int input = Integer.parseInt(readLine);
//		 System.out.println("User entered: "+readLine+" in Main Menu "+input);
		
		 
		return input;
		
	}
}