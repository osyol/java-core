public class BankAccount {
    private String fio;
    private String  accountNumber;
    private double balance;

    public BankAccount(String fio, String  accountNumber, double balance) {
        this.fio = fio;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

//    класс deposit()
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Баланс пополнен на " +
                    amount + " тенге. Новый баланс " +
                    balance + "\n \n");
        } else {
            System.out.println("Дурак что-ле?");
        }
    }

//    класс withdraw()
    public void withdraw(double amount) {
        if (amount <= balance && amount > 0){
            balance -= amount;
            System.out.println("С вашей карты сняли " + amount
            + " тенге. Осталось " + balance + "\n \n") ;
        } else {
            System.out.println("++++");
        }
    }

//    класс getBalance()
    public double getBalance() {
        return balance;
    }

    public void printInfo() {
        System.out.println("Информация про счёт матча Филадельфия Тайгрз и Самарканд Вулвз");
        System.out.println("ФИО: " + fio);
        System.out.println("Номер карты: " + accountNumber);
        System.out.println("Баланс: " + balance + "\n \n");
    }

}
