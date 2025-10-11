import java.util.List;
import java.util.ArrayList;

public class Seat {
    private int row;
    private char key;
    private double price;
    private String status;
    private String klass;


    public Seat(int row, char key, double price, String status, String klass) {
        this.row = row;
        this.key = key;
        this.price = price;
        this.status = status;
        this.klass = klass;
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

    public void setStatus(String status) {
        this.status = status;
    }

    //    to show information about all seats
    public void showBusinessClassSeatsInfo() {

        if (klass.equals("business")) {
            System.out.println("Seat " + row + key + " is worth " + price + " and is " + status + " now");
        }
    }

    public void ShowEconomyClassSeatsInfo() {
        if (klass.equals("economy")) {
            System.out.println("Seat " + row + key + " is worth " + price + " and is " + status + " now");
        }
    }

    public String toCSV() {
        return row + "," + key + "," + price + "," + status + "," + klass;
    }

    public static Seat fromCSV(String line) {
        try {
            String[] parts = line.split(",");
            if (parts.length < 5) {
                System.out.println("⚠️ Not enough parts in line: " + line);
                return null;
            }

            int row = Integer.parseInt(parts[0].trim());
            char key = parts[1].trim().charAt(0);
            double price = Double.parseDouble(parts[2].trim());
            String status = parts[3].trim();
            String klass = parts[4].trim();

            if (klass.equalsIgnoreCase("business")) {
                return new BusinessClassSeats(row, key, price, status, klass);
            } else {
                return new EconomyClassSeats(row, key, price, status, klass);
            }

        } catch (Exception e) {
            System.out.println("Error parsing line: " + line);
            e.printStackTrace();
            return null;
        }
    }


}
