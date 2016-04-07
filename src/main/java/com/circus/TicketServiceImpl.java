/**
 * 
 */
package com.circus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Dhawal Patil
 *
 */
public class TicketServiceImpl implements TicketService {

	Venue venue=new Venue("circus");



	/* (non-Javadoc)
	 * @see com.circus.TicketService#numSeatsAvailable(int)
	 * Computes the number of the available seats per Level basis
	 */
	@Override
	public int numSeatsAvailable(int venueLevel) {

		int availableSeats = 0;

		if(venueLevel == 1) 
			availableSeats = findAvailablity(venue.orchestraSeats);
		else if(venueLevel == 2)
			availableSeats = findAvailablity(venue.mainSeats);
		else if(venueLevel == 3)
			availableSeats = findAvailablity(venue.balcony1Seats);
		else if(venueLevel == 4)
			availableSeats = findAvailablity(venue.balcony2Seats);

		return availableSeats;
	}


	private int findAvailablity(List<Seat> seats) {
		// TODO Auto-generated method stub
		int availableSeats=0;

		for(int i = 0 ;i < seats.size(); i++) {
			if(seats.get(i).getSeatStatus().equalsIgnoreCase("available"))
				availableSeats++;
		}

		return availableSeats;
	}

	
	//Finds the number of seats available within the venue.
	public int numSeatsAvailable() {
		
		int totalAvailableSeats, orchestraAvailableSeats, mainAvailableSeats, balcony1AvailableSeats, balcony2AvailableSeats = 0;

		orchestraAvailableSeats = findAvailablity(venue.orchestraSeats);
		mainAvailableSeats      = findAvailablity(venue.mainSeats);
		balcony1AvailableSeats  = findAvailablity(venue.balcony1Seats);
		balcony2AvailableSeats  = findAvailablity(venue.balcony2Seats);

		totalAvailableSeats = orchestraAvailableSeats + mainAvailableSeats + balcony1AvailableSeats + balcony2AvailableSeats;
		
		return totalAvailableSeats;
	}

/* (non-Javadoc)
 * @see com.circus.TicketService#findAndHoldSeats(int, int, int, java.lang.String)
 */

@Override
public SeatHold findAndHoldSeats(int numSeats, int minLevel, int maxLevel,
		String customerEmail) {
	// TODO Auto-generated method stub
	
	SeatHold seatHold = new SeatHold();
	
	List<Seat> orchestraSeats=venue.orchestraSeats;
	List<Seat> mainSeats=venue.mainSeats;
	List<Seat> balcony1Seats=venue.balcony1Seats;
	List<Seat> balcony2Seats=venue.balcony2Seats;
	
	Seat seat =null;
	
	if(numSeats > numSeatsAvailable())
		return seatHold;
	
loopSeats:
	for(int i=0; i < numSeats; i++) {
		
		// Hold Orchestra Level seats
		if((minLevel == 1 ||maxLevel==1) && (1 <= maxLevel)) {
			for(int j=0; j < orchestraSeats.size(); j++) {
				if(orchestraSeats.get(j).getSeatStatus().equalsIgnoreCase("available")) {
					
					seat = orchestraSeats.get(j);
					seat.setSeatStatus("Hold");
					
					seatHold.addSeats(seat);
					
					if(seatHold.getSeats().size() == numSeats)
						break loopSeats;
				}
			}
		}

		
		// Hold Main Level seats
		if((minLevel == 2 ||maxLevel==2)&& (2 <= maxLevel )) {
			for(int j=0; j < mainSeats.size(); j++) {
				if(mainSeats.get(j).getSeatStatus().equalsIgnoreCase("available")) {
					seat = mainSeats.get(j);
					seat.setSeatStatus("Hold");
					
					seatHold.addSeats(seat);
					if(seatHold.getSeats().size() == numSeats)
						break loopSeats;
				}
			}
		}
		
		
		// Hold Balcony1 Level seats
		if((minLevel == 3||maxLevel==3) && (3 <= maxLevel)) {
			for(int j=0; j < balcony1Seats.size(); j++) {
				if(balcony1Seats.get(j).getSeatStatus().equalsIgnoreCase("available")) {
					seat = balcony1Seats.get(j);
					seat.setSeatStatus("Hold");
					
					seatHold.addSeats(seat);
					if(seatHold.getSeats().size() == numSeats)
						break loopSeats;
				}
			}
		}
				
				
		// Hold Balcony2 Level seats
		if((minLevel == 4||maxLevel==4) && (4 <= maxLevel)) {
			for(int j=0; j < balcony2Seats.size(); j++) {
				if(balcony2Seats.get(j).getSeatStatus().equalsIgnoreCase("available")) {
					seat = balcony2Seats.get(j);
					seat.setSeatStatus("Hold");
					
					seatHold.addSeats(seat);
					if(seatHold.getSeats().size() == numSeats)
						break loopSeats;
				}
			}
		}
	}
	
	if(seatHold.getSeats().size() < numSeats) {
		System.out.println("Seathold size is: "+seatHold.getSeats().size());
		return null;
	}
	
	seatHold.setEmailId(customerEmail);
	seatHold.setseatHoldId();
	
	String holdConfirmation = seatHold.getseatHoldId() + customerEmail;
	
	venue.getHoldTickets().put(holdConfirmation, seatHold);
		
	return seatHold;
}

//If there is no maximum level, assume the user can book at any seating level
public SeatHold findAndHoldSeats(int numSeats, int minLevel, String customerEmail) {
	// TODO Auto-generated method stub
	
	SeatHold seatHold = new SeatHold();
	
	List<Seat> orchestraSeats=venue.orchestraSeats;
	List<Seat> mainSeats=venue.mainSeats;
	List<Seat> balcony1Seats=venue.balcony1Seats;
	List<Seat> balcony2Seats=venue.balcony2Seats;
	
	Seat seat =null;
	int maxLevel=4;
	
	if(numSeats > numSeatsAvailable())
		return seatHold;
	
loopSeats:
	for(int i=0; i < numSeats; i++) {
		
		// Hold Orchestra Level seats
		if((minLevel <= 1) && (1 <= maxLevel)) {
			for(int j=0; j < orchestraSeats.size(); j++) {
				if(orchestraSeats.get(j).getSeatStatus().equalsIgnoreCase("available")) {
					
					seat = orchestraSeats.get(j);
					seat.setSeatStatus("Hold");
					
					seatHold.addSeats(seat);
					
					if(seatHold.getSeats().size() == numSeats)
						break loopSeats;
				}
			}
		}

		
		// Hold Main Level seats
		if((minLevel <= 2) && (2 <= maxLevel )) {
			for(int j=0; j < mainSeats.size(); j++) {
				if(mainSeats.get(j).getSeatStatus().equalsIgnoreCase("available")) {
					seat = mainSeats.get(j);
					seat.setSeatStatus("Hold");
					
					seatHold.addSeats(seat);
					if(seatHold.getSeats().size() == numSeats)
						break loopSeats;
				}
			}
		}
		
		
		// Hold Balcony1 Level seats
		if((minLevel <= 3) && (3 <= maxLevel)) {
			for(int j=0; j < balcony1Seats.size(); j++) {
				if(balcony1Seats.get(j).getSeatStatus().equalsIgnoreCase("available")) {
					seat = balcony1Seats.get(j);
					seat.setSeatStatus("Hold");
					
					seatHold.addSeats(seat);
					if(seatHold.getSeats().size() == numSeats)
						break loopSeats;
				}
			}
		}
				
				
		// Hold Balcony2 Level seats
		if((minLevel <= 4) && (4 <= maxLevel)) {
			for(int j=0; j < balcony2Seats.size(); j++) {
				if(balcony2Seats.get(j).getSeatStatus().equalsIgnoreCase("available")) {
					seat = balcony2Seats.get(j);
					seat.setSeatStatus("Hold");
					
					seatHold.addSeats(seat);
					if(seatHold.getSeats().size() == numSeats)
						break loopSeats;
				}
			}
		}
	}
	
	if(seatHold.getSeats().size() < numSeats) {
		System.out.println("Seathold size is: "+seatHold.getSeats().size());
		return null;
	}
	
	seatHold.setEmailId(customerEmail);
	seatHold.setseatHoldId();
	
	String holdConfirmation = seatHold.getseatHoldId() + customerEmail;
	
	venue.getHoldTickets().put(holdConfirmation, seatHold);
		
	return seatHold;
}



/* (non-Javadoc)
 * @see com.circus.TicketService#findAndHoldSeats(int, java.lang.String)
 */

public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {
	// TODO Auto-generated method stub
	
	return findAndHoldSeats(numSeats, 1, 4, customerEmail);

}


	/* (non-Javadoc)
	 * @see com.circus.TicketService#reserveSeats(int, java.lang.String)
	 */
	@Override
	public String reserveSeats(int seatHoldId, String customerEmail) {
		// TODO Auto-generated method stub
		
		SeatHold seatHold = new SeatHold();
		
		Map holdTickets = venue.getHoldTickets();
		
		String reservationConfirmation = seatHoldId + customerEmail;
		
		seatHold = (SeatHold) holdTickets.get(reservationConfirmation);
		if(null==seatHold) {
			return null;
		}
		
		List<Seat> seats=seatHold.getSeats();
		Seat seat = new Seat();
		
		for(int i = 0; i < seats.size(); i++ ) {
			seat = seats.get(i);
			seat.setSeatStatus("Reserved");
		}
		
		holdTickets.remove(reservationConfirmation);
		venue.setHoldTickets(holdTickets);
		venue.getReservedTickets().put(reservationConfirmation, seatHold);	
			
		return reservationConfirmation;
		
	}

}
