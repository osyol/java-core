import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private String phoneNumber;
    private List<String> bookedSeatCodes;

    public Passenger(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.bookedSeatCodes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void addSeat(Seat seat) {
        String code = seat.getRow() + "" + seat.getKey();
        if (!bookedSeatCodes.contains(code)) {
            bookedSeatCodes.add(code);
        }
    }

    public boolean removeSeat(Seat seat) {
        String code = seat.getRow() + "" + seat.getKey();
        return bookedSeatCodes.remove(code);
    }

    public boolean hasSeat(Seat seat) {
        String code = seat.getRow() + "" + seat.getKey();
        return bookedSeatCodes.contains(code);
    }

    public void showMySeats() {
        if (bookedSeatCodes.isEmpty()) {
            System.out.println(name + ", you have no booked seats yet.");
        } else {
            System.out.println("Seats booked by " + name + ":");
            for (String s : bookedSeatCodes) {
                System.out.println("  - Seat " + s);
            }
        }
    }

    // saving
    public String toCSV() {
        return name + "," + phoneNumber + "," + String.join(";", bookedSeatCodes);
    }

    public static Passenger fromCSV(String line) {
        String[] parts = line.split(",", 3);
        Passenger p = new Passenger(parts[0], parts[1]);
        if (parts.length > 2 && !parts[2].isEmpty()) {
            String[] seats = parts[2].split(";");
            for (String s : seats) {
                p.bookedSeatCodes.add(s);
            }
        }
        return p;
    }
}
