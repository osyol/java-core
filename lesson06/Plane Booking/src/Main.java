import java.io.*;
import java.util.*;

public class Main {
    private static final String SEATS_FILE = "seats.txt";
    private static final String PASSENGERS_FILE = "passengers.txt";

    public static void main(String[] args) {
        List<Seat> seats = loadSeats(); // загрузка из файла или создание новых
        List<Passenger> passengers = loadPassengers(); // загрузка пассажиров
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("\nWhat do you want?");
            System.out.println("1. Show information about seats");
            System.out.println("2. Book a seat");
            System.out.println("3. Show my booked seats");
            System.out.println("4. Cancel my booking");
            System.out.println("5. Exit");

            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("1. Business class seats");
                    System.out.println("2. Economy class seats");
                    int choice1 = in.nextInt();
                    in.nextLine();
                    switch (choice1) {
                        case 1:
                            System.out.println("\nBusiness Class Seats:");
                            for (Seat seat : seats)
                                seat.showBusinessClassSeatsInfo();
                            break;
                        case 2:
                            System.out.println("\nEconomy Class Seats:");
                            for (Seat seat : seats)
                                seat.ShowEconomyClassSeatsInfo();
                            break;
                        default:
                            System.out.println("Invalid input");
                            break;
                    }
                    break;

                case 2:
                    System.out.print("Choose a seat to book (e.g., 9E): ");
                    String s = in.nextLine();
                    Booking booking = new Booking(s, seats, in, passengers);
                    booking.extractingS();
                    saveSeats(seats);
                    savePassengers(passengers);
                    break;

                case 3:
                    System.out.print("Enter your phone number to view your booked seats: ");
                    String phone = in.nextLine();
                    boolean found = false;
                    for (Passenger p : passengers) {
                        if (p.getPhoneNumber().equals(phone)) {
                            p.showMySeats();
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        System.out.println("No passenger found with that phone number.");
                    break;

                case 4:
                    Booking cancel = new Booking("", seats, in, passengers);
                    cancel.cancelBooking();
                    saveSeats(seats);
                    savePassengers(passengers);
                    break;

                case 5:
                    saveSeats(seats);
                    savePassengers(passengers);
                    System.out.println("Exiting program...");
                    in.close();
                    return;

                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    // ---------- Сохранение и загрузка мест ----------
    private static List<Seat> loadSeats() {
        List<Seat> seats = new ArrayList<>();
        File file = new File(SEATS_FILE);

        if (!file.exists()) {
            // создаём новые места, если файла нет
            for (int row = 1; row <= 5; row++)
                for (char key = 'A'; key <= 'D'; key++)
                    seats.add(new BusinessClassSeats(row, key, 300, "free", "business"));
            for (int row = 6; row <= 21; row++)
                for (char key = 'A'; key <= 'F'; key++)
                    seats.add(new EconomyClassSeats(row, key, 100, "free", "economy"));
            return seats;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null)
                seats.add(Seat.fromCSV(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return seats;
    }

    private static void saveSeats(List<Seat> seats) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SEATS_FILE))) {
            for (Seat seat : seats) {
                bw.write(seat.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ---------- Сохранение и загрузка пассажиров ----------
    private static List<Passenger> loadPassengers() {
        List<Passenger> passengers = new ArrayList<>();
        File file = new File(PASSENGERS_FILE);

        if (!file.exists()) return passengers;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null)
                passengers.add(Passenger.fromCSV(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passengers;
    }

    private static void savePassengers(List<Passenger> passengers) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PASSENGERS_FILE))) {
            for (Passenger p : passengers) {
                bw.write(p.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
