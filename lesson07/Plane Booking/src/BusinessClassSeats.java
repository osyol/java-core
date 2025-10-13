public class BusinessClassSeats extends Seat {
    private String klass;

    public BusinessClassSeats (int row, char key, double price, String status, String klass) {
        super(row, key, price, status, klass);
    }



//    public void showBusinessClassInfo() {
//        System.out.println("Seat " + row + key + " is worth " + price + " and is " + status + " now");
//    }

}
