import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        StreetFighter.addFighter(new StreetFighter(1, "Ryu", 120, 10, 20));
        StreetFighter.addFighter(new StreetFighter(2, "Ken", 100, 12, 25));
        StreetFighter.addFighter(new StreetFighter(3, "Chun-Li", 90, 14, 26));
        StreetFighter.addFighter(new StreetFighter(4, "Takbir", 150, 8, 17));
        StreetFighter.addFighter(new StreetFighter(5, "Mike", 80, 16, 30));

        System.out.println("Choose your fighter: ");
        StreetFighter.getFighters();

        System.out.print("Your fighter: ");
        int c1 = in.nextInt();

        System.out.print("Your rival: ");
        int c2 = in.nextInt();

        StreetFighter f1 = null, f2 = null;
        for(StreetFighter f : StreetFighter.fighters) {
            if (f.code == c1) {
                f1 = f;
            } else if (f.code == c2){
                f2 = f;
            }
            if (f1 == null || f2 == null || f1 == f2) {
                System.out.println("Invalid!");
            } else {
                StreetFighter.fight(f1, f2);
            }
        }

        in.close();
    }
}