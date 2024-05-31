import com.engeto.hotel.Booking;
import com.engeto.hotel.BookingManager;
import com.engeto.hotel.Guest;
import com.engeto.hotel.Room;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        BookingManager manager = new BookingManager();
        fillBookings(manager);


        // Pro testování - vypsání všech rezervací
        for (Booking booking : manager.getBookings()) {
            System.out.println(booking);
        }

        // Testování dalších metod
        System.out.println("Počet pracovních rezervací: " + manager.getNumberOfWorkingBookings());
        System.out.println("Průměrný počet hostů na rezervaci: " + manager.getAverageGuests());
    }

    public static void fillBookings(BookingManager manager) {
        Guest guest1 = new Guest(1, "Adela", "Malikova", LocalDate.of(1993, 3, 13));
        Guest guest2 = new Guest(2, "Jan", "Dvoracek", LocalDate.of(1995, 5, 5));
        Guest guest3 = new Guest(3, "Karel", "Dvorak", LocalDate.of(1990, 5, 15));
        Guest guest4 = new Guest(4, "Karel", "Dvorak", LocalDate.of(1979, 1, 3));
        Guest guest5 = new Guest(5, "Karolina", "Tmava", LocalDate.of(1985, 7, 20));

        Room room1 = new Room(1, 2, true, true, 1500);
        Room room2 = new Room(2, 2, false, true, 1200);
        Room room3 = new Room(3, 3, true, false, 1800);

        Booking booking1 = new Booking(1, "Business", LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 7), room3, guest3, List.of(guest3));
        Booking booking2 = new Booking(2, "Private", LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 21), room2, guest4, List.of(guest4));
        manager.addBooking(booking1);
        manager.addBooking(booking2);

        int bookingId = 3;
        for (int i = 0; i < 10; i++) {
            LocalDate startDate = LocalDate.of(2023, 8, 1).plusDays(i * 2);
            LocalDate endDate = startDate.plusDays(1);
            Booking booking = new Booking(bookingId++, "Private", startDate, endDate, room2, guest5, List.of(guest5));
            manager.addBooking(booking);
        }

        Booking augustBooking = new Booking(bookingId, "Private", LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), room3, guest5, List.of(guest5));
        manager.addBooking(augustBooking);

    }

}