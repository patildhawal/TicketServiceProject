/**
 *  SeatHold class is used hold information regarding seats held,
 *  number of seats, level name/id and the duration of hold
 */
package com.circus;

/**
 * @author Dhawal Patil
 *
 */
public class Seat {
	
	// Column number of a seat
	private int seatColNumber;
	
	//Row number of a seat
	private int seatRowNumber;
	
	private double price;
	
	private int level;
	
	private String emailId;
	
	private String seatStatus;

	public int getSeatColNumber() {
		return seatColNumber+1;
	}

	public void setSeatColNumber(int seatColNumber) {
		this.seatColNumber = seatColNumber;
	}

	public int getSeatRowNumber() {
		return seatRowNumber;
	}

	public void setSeatRowNumber(int seatRowNumber) {
		this.seatRowNumber = seatRowNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}

}
