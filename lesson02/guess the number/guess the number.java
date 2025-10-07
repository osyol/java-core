
// угадай число
import java.util.Scanner;
import java.util.Random;
public class Main
{
	public static void main(String[] args) {
	   // для ввода числа пользователем
		Scanner in = new Scanner(System.in);
		System.out.println("Давай поиграем в игру, я загадываю число от 0 до 10, а ты должен угадать его");
		int guess = -1;
		
// 		для генерации числа
        Random rand = new Random();
        int myNum = rand.nextInt(11);
        
        while (guess != myNum){
            System.out.println("Загадывай");
        	guess = in.nextInt();      
        
            
            if(guess == myNum){
                System.out.println("Угадал, хорош");
            }else {
                System.out.println("Не угадал, давай ещё раз");
            }
            
        }
		
	    
	    
	}
}
