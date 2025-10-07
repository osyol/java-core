import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введи своё ФИО: ");
        String fio = in.nextLine();

        System.out.print("Введи данные карты: ");
        String accountNumber = in.nextLine();

        BankAccount account = new BankAccount(fio, accountNumber, 0);

        while (true) {
            System.out.println("Выбери что делать:");
            System.out.println("1. Пополнить счёт");
            System.out.println("2.Снять деньги");
            System.out.println("3.Проверить баланс");
            System.out.println("4.Показать данные аккаунта");
            System.out.println("0.Выйти");
            System.out.print("И что? ");

            int choice = in.nextInt();


            if (choice == 1){
//                пополнение счёта
                System.out.print("Сколько хочешь задонатить? ");
                double amount = in.nextDouble();
                account.deposit(amount);
            } else if (choice == 2) {
//                снятие денег
                System.out.print("Сколько хочешь снять денег? ");
                double amount = in.nextDouble();
                account.withdraw(amount);
            } else if (choice == 3){
//                баланс карты
                System.out.println("Текущий баланс: " + account.getBalance());
            } else if (choice == 4) {
//                информация о карте
                account.printInfo();
            } else if (choice == 0) {
                System.out.println("Прощай, не надо больше слов.\n" +
                        "Спасибо за любовь...твою");
                break;
            } else {
                System.out.println("Давай заново");
            }

        }


    in.close();
    }
}