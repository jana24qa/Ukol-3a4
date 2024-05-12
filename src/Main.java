import com.engeto.hotel.Booking;
import com.engeto.hotel.Guest;
import com.engeto.hotel.ListOfBookings;
import com.engeto.hotel.Room;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Guest guest1 = new Guest(1, "Adela", "Malikova", LocalDate.of(1993, 3, 13));
        Guest guest2 = new Guest(2, "Jan", "Dvoracek", LocalDate.of(1995, 5, 5));

        List<Guest> guestList = new ArrayList<>();

        System.out.println("List of Guests");
        System.out.println("---------------------------");
        guest1.getInfoAboutGuests();
        System.out.println("---------------------------");
        guest2.getInfoAboutGuests();
        System.out.println("---------------------------");
        System.out.println("                           ");

        Room room1 = new Room(1, 1, true, true, 1000);
        Room room2 = new Room(2, 1, true, true,1000);
        Room room3 = new Room(3, 3, false, true, 2400);

        System.out.println("List of Rooms");
        System.out.println("---------------------------");
        room1.getInfoAboutRooms();
        System.out.println("---------------------------");
        room2.getInfoAboutRooms();
        System.out.println("---------------------------");
        room3.getInfoAboutRooms();
        System.out.println("---------------------------");
        System.out.println("                           ");

        Booking booking1 = new Booking(1, "Business", LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 26), room1, guest1, List.of(guest1));
        Booking booking2 = new Booking(2, "Private", LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14), room3, guest1, List.of(guest1, guest2));

        ListOfBookings listOfBookings = new ListOfBookings();
        listOfBookings.addBooking(booking1);
        listOfBookings.addBooking(booking2);

        System.out.println("List of Bookings");
        System.out.println("---------------------------");
        listOfBookings.printAllBookings();

    }
}