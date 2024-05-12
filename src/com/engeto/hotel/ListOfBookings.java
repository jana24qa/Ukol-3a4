package com.engeto.hotel;

import java.util.ArrayList;
import java.util.List;

public class ListOfBookings {
    private List<Booking> bookings;

    public ListOfBookings() {
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void printAllBookings() {
        for (Booking booking : bookings) {
            System.out.println("Booking ID: " + booking.getBookingId());
            System.out.println("Type of vacation: " + booking.getTypeOfVacation());
            System.out.println("Start date: " + booking.getBookingFromDate());
            System.out.println("End date: " + booking.getBookingToDate());
            System.out.println("Room number: " + booking.getRoom().getRoomId());
            System.out.println("Guests:");
            for (Guest guest : booking.getOtherGuests()) {
                System.out.println(" - " + guest.getFirstName() + " " + guest.getLastName());
            }
            System.out.println("---------------------------");
        }
    }
}