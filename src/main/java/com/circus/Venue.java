/**
 * 
 */
package com.circus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dhawal Patil
 *
 */
public class Venue {
	
	//Build seats at All Level
		public List<Seat> orchestraSeats=new ArrayList<Seat>();
		public List<Seat> mainSeats=new ArrayList<Seat>();
		public List<Seat> balcony1Seats=new ArrayList<Seat>();
		public List<Seat> balcony2Seats=new ArrayList<Seat>();
		
		public Map<String, SeatHold> holdTickets = new HashMap<String, SeatHold>();
		public Map<String, SeatHold> reservedTickets = new HashMap<String, SeatHold>();
		
		Venue(String eventType){
			orchestraSeats =  buildSeats(1, 100.00, 25, 50);
			mainSeats      =  buildSeats(2, 75.00, 20, 100);
			balcony1Seats  =  buildSeats(3, 50.00, 15, 100);
			balcony2Seats  =  buildSeats(4, 40.00, 15, 100);
			
		}
		
		private static List<Seat> buildSeats(int id, double price, int rows, int seatsInRow) {
			
			List<Seat> seats=new ArrayList<Seat>();
			
					//Number of rows for each level
					for(int i = 0; i < rows; i++) 	{
					
						//Number of seats in each row in this level
						for(int j = 0; j < seatsInRow; j++)	{
					
							//Create a new Seat Object and initialize the required features
							Seat seatHold = new Seat();
							seatHold.setLevel(id);
							seatHold.setPrice(price);
							seatHold.setSeatColNumber(j);
							seatHold.setSeatRowNumber(i);
							seatHold.setSeatStatus("Available");
					
							//Add the seat object to the respective Levels
							seats.add(seatHold);
						}
					}	
					
				return seats;				
		}

		public Map<String, SeatHold> getHoldTickets() {
			return holdTickets;
		}

		public void setHoldTickets(Map<String, SeatHold> holdTickets) {
			this.holdTickets = holdTickets;
		}

		public Map<String, SeatHold> getReservedTickets() {
			return reservedTickets;
		}

		public void setReservedTickets(Map<String, SeatHold> reservedTickets) {
			this.reservedTickets = reservedTickets;
		}	


}
