import java.util.Random;
import java.util.ArrayList;

public class StreetFighter {
    public int code;
    private String name;
    private int health;
    private int minDamage;
    private int maxDamage;


    public static ArrayList<StreetFighter> fighters = new ArrayList<>();
    private static Random r = new Random();

    public StreetFighter(int code, String name, int health, int minDamage, int maxDamage) {
        this.code = code;
        this.name = name;
        this.health = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

//    adding a fighter
    public static void addFighter(StreetFighter fighter) {
        fighters.add(fighter);
    }

//    getting information about fighters
    public void getFighterInfo() {
        System.out.println(code + ": " + name + " | HP: " + health + " | damage range: " + minDamage + "-" + maxDamage);
    }

    public static void getFighters() {
        for (StreetFighter f : fighters){
            f.getFighterInfo();
        }
    }

//    fight
    public static void fight(StreetFighter f1, StreetFighter f2) {

        int hp1 = f1.health;
        int hp2 = f2.health;

        System.out.println("Fight between " + f1.name + " and " + f2.name);

//        who's the first to attack and to defend
        StreetFighter attacker;
        StreetFighter defender;

        if (r.nextBoolean()){
            attacker = f1;
            defender = f2;
        } else {
            attacker = f2;
            defender = f1;
        }

        System.out.println(attacker.name + " is attacking first");

        while (hp1 > 0 && hp2 > 0) {
            int damage = r.nextInt(attacker.minDamage, attacker.maxDamage + 1);

            if (defender == f1){
                hp1 -= damage;
            } else if (defender == f2) {
                hp2 -= damage;
            }
                System.out.println(attacker.name + " makes " + damage + " damage \n" +
                        "HP of " + defender.name + (Math.max((defender == f1 ? hp1 : hp2), 0)));

                if (hp1 <= 0 || hp2 <= 0) {
                    break;
                }

                StreetFighter temp = attacker;
                attacker = defender;
                defender = temp;

            }
            StreetFighter winner = (hp1 > 0) ? f1 : f2;
            System.out.println("And the winner of the loosers game is " + winner.name);
        }


}
