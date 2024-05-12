package com.engeto.hotel;

import java.util.List;

public class Room {

    private int roomId;
    private int numberOfBeds;
    private boolean balconyRoom;
    private boolean seaViewRoom;
    private int pricePerNightInCzk;
    private Guest guest;

    public Room(int roomId, int numberOfBeds, boolean balconyRoom, boolean seaViewRoom, int pricePerNight) {
        this.roomId = roomId;
        this.numberOfBeds = numberOfBeds;
        this.balconyRoom = balconyRoom;
        this.seaViewRoom = seaViewRoom;
        this.pricePerNightInCzk = pricePerNight;
    }

    public Room(Guest guest) {
        this.guest = guest;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean isBalconyRoom() {
        return balconyRoom;
    }

    public void setBalconyRoom(boolean balconyRoom) {
        this.balconyRoom = balconyRoom;
    }

    public boolean isSeaViewRoom() {
        return seaViewRoom;
    }

    public void setSeaViewRoom(boolean seaViewRoom) {
        this.seaViewRoom = seaViewRoom;
    }

    public int getPricePerNight() {
        return pricePerNightInCzk;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNightInCzk = pricePerNight;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void getInfoAboutRooms() {
        System.out.println("Room Number: " + roomId);
        System.out.println("Number of Beds: " + numberOfBeds);
        System.out.println("Price per Night in CZK: " +pricePerNightInCzk );
        System.out.println("Room with Balcony: " + (balconyRoom ? "yes" : "no"));
        System.out.println("Room with Sea View: " + (seaViewRoom ? "yes" : "no"));

    }
}
