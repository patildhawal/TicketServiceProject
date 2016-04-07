package com.circus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class SeatHold{
	
	public String emailId = null;
	public int seatHoldId;
	
	List<Seat> seats=new ArrayList<Seat>();

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void addSeats(Seat seat) {
		this.seats.add(seat);
	}

	public int getseatHoldId() {
		return seatHoldId;
	}

	public void setseatHoldId() {
		Random rand=new Random();
		int randInt = rand.nextInt(10000)+1;
		this.seatHoldId = randInt;
	} 
	
	public void getSeatInfo() {
	
		System.out.println("Your Seat Booking for "+this.seats.size()+" tickets is on Hold");
		System.out.println("Number of seats on Hold: "+this.seats.size());
		
		Seat seat = new Seat();
		double totalPrice=0;
		
		for(int i=0; i<this.seats.size(); i ++){
			seat=this.seats.get(i);
			System.out.println("\nTicket# "+(i+1)+" details...");
			
			System.out.println("Seating Level: "+seat.getLevel());
			System.out.println("Row: "+"ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(seat.getSeatRowNumber()));
			System.out.println("Column number: "+seat.getSeatColNumber());
			System.out.println("Price: "+seat.getPrice());
			totalPrice = totalPrice+seat.getPrice();
			
			
		}
		
		System.out.println("\nHold Confirmation number: "+this.seatHoldId);
		System.out.println("Total price of your tickets: "+totalPrice);
		System.out.println("Hold details have been emailed to your EmailId: "+this.emailId);		
		
	}
	

}
