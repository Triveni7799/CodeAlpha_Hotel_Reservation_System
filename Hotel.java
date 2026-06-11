import java.util.*;
import java.io.*;

public class Hotel {

    ArrayList<Room> rooms =
            new ArrayList<>();

    ArrayList<Booking> bookings =
            new ArrayList<>();

    public Hotel() {

        rooms.add(new Room(101,
                "Standard",2000));

        rooms.add(new Room(102,
                "Deluxe",3500));

        rooms.add(new Room(103,
                "Suite",5000));
    }

    public void displayRooms() {

        System.out.println("\nAvailable Rooms");

        for(Room room : rooms) {

            if(room.isAvailable()) {

                System.out.println(
                        room.getRoomNumber()
                        + " - "
                        + room.getCategory()
                        + " - ₹"
                        + room.getPrice());
            }
        }
    }

    public void bookRoom(
            String customer,
            int roomNumber) {

        for(Room room : rooms) {

            if(room.getRoomNumber()
                    == roomNumber
                    && room.isAvailable()) {

                room.setAvailable(false);

                Booking booking =
                        new Booking(
                                customer,
                                room);

                bookings.add(booking);

                saveBooking(booking);

                System.out.println(
                        "Payment Successful!");

                System.out.println(
                        "Room Booked Successfully!");
                return;
            }
        }

        System.out.println(
                "Room Not Available!");
    }

    public void cancelBooking(
            int roomNumber) {

        Iterator<Booking> iterator =
                bookings.iterator();

        while(iterator.hasNext()) {

            Booking booking =
                    iterator.next();

            if(booking.getRoom()
                    .getRoomNumber()
                    == roomNumber) {

                booking.getRoom()
                        .setAvailable(true);

                iterator.remove();

                System.out.println(
                        "Booking Cancelled!");

                return;
            }
        }

        System.out.println(
                "Booking Not Found!");
    }

    public void viewBookings() {

        System.out.println(
                "\nBooking Details");

        for(Booking booking :
                bookings) {

            System.out.println(
                    booking);
        }
    }

    public void saveBooking(
            Booking booking) {

        try {

            FileWriter fw =
                    new FileWriter(
                            "bookings.txt",
                            true);

            fw.write(
                    booking.toString()
                    + "\n");

            fw.close();

        } catch(Exception e) {

            System.out.println(
                    e.getMessage());
        }
    }
}