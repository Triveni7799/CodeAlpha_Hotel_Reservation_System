public class Booking {

    private String customerName;
    private Room room;

    public Booking(String customerName,
                   Room room) {
        this.customerName = customerName;
        this.room = room;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return customerName +
                " booked Room "
                + room.getRoomNumber()
                + " (" + room.getCategory() + ")";
    }
}