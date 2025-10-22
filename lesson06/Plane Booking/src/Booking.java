import java.util.List;
import java.util.Scanner;

public class Booking {
    private String seatCode;
    private List<Seat> seats;
    private Scanner input;
    private List<Passenger> passengers;

    public Booking(String seatCode, List<Seat> seats, Scanner input, List<Passenger> passengers) {
        this.seatCode = seatCode.toUpperCase();
        this.seats = seats;
        this.input = input;
        this.passengers = passengers;
    }

    public void enterInfo(Seat seat) {
        System.out.println("Before booking this seat, we'd like to get information about you so that we could contact you in some unexpected situations.");

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter your phone number: ");
        String phoneNumber = input.nextLine();

        // checking if a passenger exists
        Passenger currentPassenger = null;
        for (Passenger p : passengers) {
            if (p.getPhoneNumber().equals(phoneNumber)) {
                currentPassenger = p;
                break;
            }
        }

        // creating new if doesn't
        if (currentPassenger == null) {
            currentPassenger = new Passenger(name, phoneNumber);
            passengers.add(currentPassenger);
        }

        // saving booking
        seat.setStatus("booked");
        currentPassenger.addSeat(seat);

        System.out.println("Alright, " + name + ", your seat is booked. Your contact info is saved too!");
    }

    public void extractingS() {
        int row;
        char key;

        try {
            String numberPart = seatCode.substring(0, seatCode.length() - 1);
            String keyPart = seatCode.substring(seatCode.length() - 1);
            row = Integer.parseInt(numberPart);
            key = keyPart.charAt(0);
        } catch (Exception e) {
            System.out.println("Invalid input, enter something like 9E");
            return;
        }

        boolean found = false;
        for (Seat seat : seats) {
            if (seat.getRow() == row && seat.getKey() == key) {
                if (seat.getStatus().equalsIgnoreCase("free")) {
                    enterInfo(seat);
                } else {
                    System.out.println("Seat " + row + key + " is already booked.");
                }
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Seat not found.");
        }
    }


//    to cancel booking
    public void cancelBooking() {
        System.out.print("Enter your phone number in order to cancel your booking: ");
        String phone = input.nextLine();

        Passenger currentPassenger = null;
        for (Passenger p : passengers) {
            if (p.getPhoneNumber().equals(phone)) {
                currentPassenger = p;
                break;
            }
        }

        if (currentPassenger == null) {
            System.out.println("There is no passenger with this phone number");
            return;
        }

//        show seats of a passenger
        currentPassenger.showMySeats();

        System.out.print("Enter a seat booking of which you want to cancel: ");
        String cancelCode = input.nextLine().toUpperCase();

        int row;
        int key;

        try {
            String numberPart = cancelCode.substring(0, cancelCode.length() - 1);
            String keyPart = cancelCode.substring(cancelCode.length() - 1);
            row = Integer.parseInt(numberPart);
            key = keyPart.charAt(0);
        } catch (Exception e) {
            System.out.println("Invalid input, you know what to enter");
            return;
        }

        boolean found = false;
        for (Seat seat : seats) {
            if (seat.getRow() == row && seat.getKey() == key) {
                if (seat.getStatus().equalsIgnoreCase("booked") && currentPassenger.hasSeat(seat)) {
                    seat.setStatus("free");
                    currentPassenger.removeSeat(seat);
                    System.out.println("Your booking is canceled");
                } else {
                    System.out.println("You do not own this seat");
                }
                found = true;
                break;
            }

            if (!found) {
                System.out.println("Seat not found");
            }
        }

    }
}
