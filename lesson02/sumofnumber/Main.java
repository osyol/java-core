// вывод суммы числа
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	   // ввод числа
        Scanner in = new Scanner(System.in);
        System.out.println("Введите своё число ");
        int Nword = in.nextInt();


        // вывод суммы числа
        int sum = 0;
        while(Nword != 0){
            sum += (Nword % 10);
            Nword /= 10;
        }
        System.out.println("Сумма вашего введённого числа: " + sum);
        

	}
}