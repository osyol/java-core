import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Duration;

public class Seat {
    private int row;
    private char key;
    private double price;
    private String status;
    private String klass;
    private LocalDate flightDate;
    private LocalDateTime bookingTime;


    public Seat(int row, char key, double price, String status, String klass) {
        this.row = row;
        this.key = key;
        this.price = price;
        this.status = status;
        this.klass = klass;
        this.flightDate = LocalDate.now().plusDays(7);
        this.bookingTime = null;
    }

    public int getRow() {
        return row;
    }

    public char getKey() {
        return key;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public String getKlass() {
        return klass;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

//related to status
    public void setStatus(String status) {
        this.status = status;
        if (status.equalsIgnoreCase("booked")){
            this.bookingTime = LocalDateTime.now();
        } else if (status.equalsIgnoreCase("free")){
            this.bookingTime = null;
        }
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

//    in order to check whether booking expired or not
    public boolean isBookingExpired() {
        if (!"booked".equalsIgnoreCase(status) || bookingTime == null) {
            return false;
        }
            Duration diff = Duration.between(bookingTime, LocalDateTime.now());
            return diff.toMinutes() > 24;
    }

    public void resetBooking() {
        if (isBookingExpired()) {
            System.out.println("Your " + row + key + " seat's booking time is expired");
            setStatus("free");
        }
    }


    //    to show information about all seats
    public void showBusinessClassSeatsInfo() {

        if (klass.equals("business")) {
            resetBooking();
            System.out.println("Seat " + row + key + " is worth " + price + " and is " + status + " now");
        }
    }

    public void ShowEconomyClassSeatsInfo() {
        if (klass.equals("economy")) {
            resetBooking();
            System.out.println("Seat " + row + key + " is worth " + price + " and is " + status + " now");
        }
    }

    public String toCSV() {
        return row + "," + key + "," + price + "," + status + "," + klass;
    }

    public static Seat fromCSV(String line) {
        try {
            String[] parts = line.split(",");
            int row = Integer.parseInt(parts[0].trim());
            char key = parts[1].trim().charAt(0);
            double price = Double.parseDouble(parts[2].trim());
            String status = parts[3].trim();
            String klass = parts[4].trim();

            Seat seat;
            if (klass.equalsIgnoreCase("business")) {
                seat = new BusinessClassSeats(row, key, price, status, klass);
            } else {
                seat = new EconomyClassSeats(row, key, price, status, klass);
            }

            if (parts.length > 5 && !parts[5].isEmpty())
                seat.setFlightDate(LocalDate.parse(parts[5].trim()));

            if (parts.length > 6 && !parts[6].isEmpty())
                seat.bookingTime = LocalDateTime.parse(parts[6].trim());

            seat.resetBooking();

            return seat;
        } catch (Exception e) {
            System.out.println("Error parsing seat: " + line);
            return null;
        }

    }
}
