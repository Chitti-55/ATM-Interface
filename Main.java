import java.util.Scanner;

class BankAccount {
    private int balance;

    public BankAccount(int initialAmount) {
        this.balance = initialAmount;
    }

    public int balance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of " + amount + " Rs was successful.");
        } else {
            System.out.println("Invalid entry! Please enter a number greater than 0.");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + " Rs was successful.");
        } else {
            System.out.println("Invalid entry! Insufficient balance or invalid amount.");
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void display() {
        System.out.println("\nSelect Options");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            display();
            System.out.print("Pick an option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    int depositAmount = sc.nextInt();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmount = sc.nextInt();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + account.balance() + " Rs");
                    break;
                case 4:
                    System.out.println("Thank you for using Jain Bank ATM.");
                    break;
                default:
                    System.out.println("Invalid option! Please select a valid option.");
            }
        } while (option != 4);
        sc.close();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(30000);
        ATM atm = new ATM(userAccount);

        System.out.print("Enter Your PIN: ");
        String pin = sc.nextLine();

        if (pin.equals("1234")) {
            atm.run();
        } else {
            System.out.println("Wrong PIN! Access denied.");
        }
        sc.close();
    }
}
