import java.util.Scanner;

public class Main {

    public static void main(
            String[] args) {

        Scanner sc =
                new Scanner(System.in);

        Hotel hotel =
                new Hotel();

        while(true) {

            System.out.println(
                    "\n===== HOTEL RESERVATION SYSTEM =====");

            System.out.println(
                    "1. Search Rooms");

            System.out.println(
                    "2. Book Room");

            System.out.println(
                    "3. Cancel Booking");

            System.out.println(
                    "4. View Bookings");

            System.out.println(
                    "5. Exit");

            System.out.print(
                    "Enter Choice: ");

            int choice =
                    sc.nextInt();

            switch(choice) {

                case 1:

                    hotel.displayRooms();
                    break;

                case 2:

                    sc.nextLine();

                    System.out.print(
                            "Customer Name: ");

                    String name =
                            sc.nextLine();

                    System.out.print(
                            "Room Number: ");

                    int roomNo =
                            sc.nextInt();

                    hotel.bookRoom(
                            name,
                            roomNo);
                    break;

                case 3:

                    System.out.print(
                            "Room Number: ");

                    int cancelRoom =
                            sc.nextInt();

                    hotel.cancelBooking(
                            cancelRoom);
                    break;

                case 4:

                    hotel.viewBookings();
                    break;

                case 5:

                    System.out.println(
                            "Thank You!");

                    System.exit(0);
            }
        }
    }
}