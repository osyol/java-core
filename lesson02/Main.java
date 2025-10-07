// доллар россия доллар
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    
	    final int Som = 12500;
	    System.out.println("Курс доллара на сегодня 12500 сум, введите вашу сумму в долларах");
	    double dollars = in.nextDouble();
	    System.out.println(dollars + " долларов будет " + dollars * Som + " сум");
	       
	}
}