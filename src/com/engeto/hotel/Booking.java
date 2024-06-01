package com.engeto.hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Booking {

    private int bookingId;
    private String typeOfVacation;
    private LocalDate bookingFromDate;
    private LocalDate bookingToDate;
    private Room room;
    private Guest guest;
    private List<Guest> otherGuests;
    private int numberOfGuests;


    public Booking(int bookingId, String typeOfVacation, LocalDate bookingFromDate, LocalDate bookingToDate, Room room, Guest guest, List<Guest> otherGuests) {
        this.bookingId = bookingId;
        this.typeOfVacation = typeOfVacation;
        this.bookingFromDate = bookingFromDate;
        this.bookingToDate = bookingToDate;
        this.room = room;
        this.guest = guest;
        this.otherGuests = otherGuests;
        this.numberOfGuests = otherGuests.size();
    }

    public static void add(Booking newBooking) {

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

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public LocalDate getStartDate() {
        return bookingFromDate;
    }

    public LocalDate getEndDate() {
        return bookingToDate;
    }

    public Guest getMainGuest() {
        return guest;
    }

    public List<Guest> getGuests() {
        return otherGuests;
    }

    public int calculateTotalPrice() {
        long numberOfNights = ChronoUnit.DAYS.between(bookingFromDate, bookingToDate);
        return (int) (numberOfNights * room.getPricePerNight());
    }

    public long getBookingLength() {
        return ChronoUnit.DAYS.between(bookingFromDate, bookingToDate);
    }

    public int getPrice() {
        long numberOfNights = getBookingLength();
        return (int) (numberOfNights * room.getPricePerNight());
    }


    @Override
    public String toString() {
        return String.format("Rezervace ID: %d, Typ: %s, Od: %s, Do: %s, Hlavní host: %s %s, Počet hostů: %d, Pokoj: %d, Cena: %d Kč",
                bookingId,
                typeOfVacation,
                bookingFromDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                bookingToDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                guest.getFirstName(),
                guest.getLastName(),
                otherGuests.size(),
                room.getRoomId(),
                calculateTotalPrice());
    }
}

