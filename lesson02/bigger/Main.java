// у кого больше число
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    System.out.println("Введите ваше первое число ");
	    int a = in.nextInt();
	    System.out.println("Введите ваше второе число ");
	    int b = in.nextInt();
	    System.out.println("Введите ваше третье число ");
	    int c = in.nextInt();
	    
	    if (a > b && a > c){
	        System.out.println(a + " самое большое число");    
	    } else if (b > a && b > c){
	        System.out.println(b + " самое большое число");
	    } else if (c > a && c > b){
	        System.out.println(c + " самое большое число");
	    } else if (a == b || a == c || b == c){
	        System.out.println("Так не честно, давай три целых числа с разными значениями");
	    }
	    
	    in.close();
	}
}