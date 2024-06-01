import com.engeto.hotel.Booking;
import com.engeto.hotel.BookingManager;
import com.engeto.hotel.Guest;
import com.engeto.hotel.Room;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        BookingManager manager = new BookingManager();
        fillBookings(manager);

        printAllBookings(manager);
        printRecreationalBookings(manager, 8);
        printGuestStatistics(manager);
        printBookingDetails(manager);

        for (Booking booking : manager.getBookings()) {
            System.out.println(booking);
        }
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

        Booking booking4 = new Booking(bookingId, "Private", LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), room3, guest5, List.of(guest5));
        manager.addBooking(booking4);

        System.out.println("Počet pracovních rezervací: " + manager.getNumberOfWorkingBookings());
        System.out.println("Průměrný počet hostů na rezervaci: " + manager.getAverageGuests());
    }

    public static void printAllBookings(BookingManager manager) {
        List<Booking> bookings = manager.getBookings();
        System.out.println("Seznam všech rezervací:");
        for (Booking booking : bookings) {
            LocalDate startDate = booking.getStartDate();
            LocalDate endDate = booking.getEndDate();
            Guest mainGuest = booking.getMainGuest();
            int numberOfGuests = booking.getGuests().size();
            String seaView = booking.getRoom().isSeaViewRoom() ? "ano" : "ne";
            int totalPrice = booking.calculateTotalPrice();

            System.out.printf("%s až %s: %s %s (%s)[%d, výhledNaMoře %s] za %d%n",
                    startDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    endDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    mainGuest.getFirstName(), mainGuest.getLastName(),
                    mainGuest.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    numberOfGuests, seaView, totalPrice);
        }
    }

    public static void printRecreationalBookings(BookingManager manager, int numberOfBookings) {
        List<Booking> bookings = manager.getBookings();
        int count = 0;

        System.out.println("Seznam prvních " + numberOfBookings + " rekreačních rezervací:");
        for (Booking booking : bookings) {
            if ("Private".equals(booking.getTypeOfVacation())) {
                LocalDate startDate = booking.getStartDate();
                LocalDate endDate = booking.getEndDate();
                Guest mainGuest = booking.getMainGuest();
                int numberOfGuests = booking.getGuests().size();
                String seaView = booking.getRoom().isSeaViewRoom() ? "ano" : "ne";
                int totalPrice = booking.calculateTotalPrice();

                System.out.printf("%s až %s: %s %s (%s)[%d, výhledNaMoře %s] za %d Kč%n",
                        startDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                        endDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                        mainGuest.getFirstName(), mainGuest.getLastName(),
                        mainGuest.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                        numberOfGuests, seaView, totalPrice);

                count++;
                if (count >= numberOfBookings) {
                    break;
                }
            }
        }

        if (count == 0) {
            System.out.println("Nenalezeny žádné rekreační rezervace.");
        }
    }


    public static void printGuestStatistics(BookingManager manager) {
        int oneGuestCount = 0;
        int twoGuestsCount = 0;
        int moreThanTwoGuestsCount = 0;

        List<Booking> bookings = manager.getBookings();

        for (Booking booking : bookings) {
            int numberOfGuests = booking.getGuests().size();
            if (numberOfGuests == 1) {
                oneGuestCount++;
            } else if (numberOfGuests == 2) {
                twoGuestsCount++;
            } else if (numberOfGuests > 2) {
                moreThanTwoGuestsCount++;
            }
        }

        System.out.println("Statistika hostů:");
        System.out.println("Celkový počet rezervací s jedním hostem: " + oneGuestCount);
        System.out.println("Celkový počet rezervací se dvěma hosty: " + twoGuestsCount);
        System.out.println("Celkový počet rezervací s více než dvěma hosty: " + moreThanTwoGuestsCount);

    }

    public static void printBookingDetails(BookingManager manager) {
        List<Booking> bookings = manager.getBookings();
        System.out.println("Podrobnosti o rezervacích:");
        for (Booking booking : bookings)
            System.out.printf("Rezervace ID: %d, Délka pobytu: %d nocí, Celková cena: %d Kč%n",
                    booking.getBookingId(),
                    booking.getBookingLength(),
                    booking.getPrice());
    }

}
