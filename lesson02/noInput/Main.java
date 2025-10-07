// таблица умножения
import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Введите ваше число для вывода таблицы умножения от 1 до 10");
		int num = in.nextInt();
		
		if(num > 10 || num <= 0){
		    System.out.println("What I've done");
		} else{
		    for(int i = 1; i <= 10; i++){
		        System.out.println(num + " * " + i + " = " + (num * i));
		    
    		}
		}
		
		in.close();
	}	
}