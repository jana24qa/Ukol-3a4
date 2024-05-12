package com.engeto.hotel;

import java.time.LocalDate;
import java.util.List;

public class Booking {

    private int bookingId;
    private String typeOfVacation;
    private LocalDate bookingFromDate;
    private LocalDate bookingToDate;
    private Room room;
    private Guest guest;
    private List<Guest> otherGuests;


    public Booking(int bookingId, String typeOfVacation, LocalDate bookingFromDate, LocalDate bookingToDate, Room room, Guest guest, List<Guest> otherGuests) {
        this.bookingId = bookingId;
        this.typeOfVacation = typeOfVacation;
        this.bookingFromDate = bookingFromDate;
        this.bookingToDate = bookingToDate;
        this.room = room;
        this.guest = guest;
        this.otherGuests = otherGuests;
    }

    public List<Guest> getOtherGuests() {
        return otherGuests;
    }

    public void setOtherGuests(List<Guest> otherGuests) {
        this.otherGuests = otherGuests;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getTypeOfVacation() {
        return typeOfVacation;
    }

    public void setTypeOfVacation(String typeOfVacation) {
        this.typeOfVacation = typeOfVacation;
    }

    public LocalDate getBookingFromDate() {
        return bookingFromDate;
    }

    public void setBookingFromDate(LocalDate bookingFromDate) {
        this.bookingFromDate = bookingFromDate;
    }

    public LocalDate getBookingToDate() {
        return bookingToDate;
    }

    public void setBookingToDate(LocalDate bookingToDate) {
        this.bookingToDate = bookingToDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
