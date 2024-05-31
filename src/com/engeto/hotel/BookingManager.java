package com.engeto.hotel;


import java.util.ArrayList;
import java.util.List;


public class BookingManager {
    private List<Booking> bookings;

    public void addBooking(Booking newBooking) {
        Booking.add(newBooking);
    }

    public Booking getBooking(int index) {
        if (index >= 0 && index < bookings.size()) {
            return bookings.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    public List<Booking> getBookings() {
        return new ArrayList<>(bookings); // Vracíme kopii seznamu pro zachování zapouzdření
    }

    public void clearBookings() {
        bookings.clear();
    }


    public int getNumberOfWorkingBookings () {
        int count = 0;
        for (Booking booking : bookings) {
            if ("Business".equals(booking.getTypeOfVacation())) {
                    count++;
            }
        }
        return count;
    }


    public double getAverageGuests() {
        if (bookings.isEmpty()) {
            return 0;
        }

        int totalGuests = 0;
        for (Booking booking : bookings) {
            totalGuests += booking.getNumberOfGuests();
        }

        return (double) totalGuests / bookings.size();
    }

}