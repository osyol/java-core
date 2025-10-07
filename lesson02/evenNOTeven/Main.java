
// любит-не любит-любит-не любит
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Введите ваше число чтобы узнать чётное оно или нечётно");
		int num = in.nextInt();
		
		if(num == 0){
		    System.out.println("0");
		} else if (num < 0){
		    System.out.println("Оно в себя растёт");
		} else if (num % 2 == 0){
		    System.out.println("Ваше число чётное");
		} else if (num % 2 == 1){
		    System.out.println("Ваше число нечётное");
		}
	    
	    in.close();
	}
}
