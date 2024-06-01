package com.engeto.hotel;

import java.time.LocalDate;

public class Guest {

    private int guestId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public Guest(int guestId, String firstName, String lastName, LocalDate dateOfBirth) {
        this.guestId = guestId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void getInfoAboutGuests() {
        System.out.println(firstName + " " + lastName + " (" + dateOfBirth + ") ");

    }


}
