import java.sql.SQLOutput;
import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount bank1 = new BankAccount("Abc","123");
        bank1.showMenu();
    }

}
class BankAccount{
    int balance;
    int previousTransaction;
    String customerName;
    String accountNumber;

    BankAccount(String cname, String accountno){
       customerName = cname;
       accountNumber = accountno;
    }

    void deposit(int amount){
        if (amount != 0){
            balance = balance + amount;
            previousTransaction = amount;

        }
    }
    void withdraw(int amount){
        if (amount <= balance){
            balance = balance- amount;
            previousTransaction = - amount;
        }
    }

void getPreviousTransaction(){
        if (previousTransaction>0) {
            System.out.println("Deposited :" + previousTransaction);
        }
        else if(previousTransaction<0){
            System.out.println("Withdrawn :" + Math.abs(previousTransaction));
        }
        else{
            System.out.println("No Transaction is occured");
        }
   }

   void showMenu(){
        char option ='\0';
        Scanner sc = new Scanner(System.in);

       System.out.println("Welcome " + customerName);
       System.out.println("Your Bank Account number is: " + accountNumber);
       System.out.println();
       System.out.println("A. Check balance");
       System.out.println("B. deposit");
       System.out.println("C. Withdraw");
       System.out.println("D. Check Previous Transaction");
       System.out.println("E. Exit");

       do {
           System.out.println();
           System.out.println("Select an option");
           System.out.println();

          option = sc.next().charAt(0); // get 1st charactor

           switch (option){
               case 'A':
                   System.out.println();
                   System.out.println("Balance is:n" + balance);
                   System.out.println();
                   break;

               case 'B':
                   System.out.println();
                   System.out.println("Enter deposit amount");
                   int amount = sc.nextInt();
                   deposit(amount);
                   System.out.println();
                   break;

               case 'C':
                   System.out.println();
                   System.out.println("Enter withdraw amount");
                   int amount2 = sc.nextInt();
                   withdraw(amount2);
                   System.out.println();
                   break;

               case 'D':
                   System.out.println();
                   getPreviousTransaction();
                   System.out.println();
                   break;

               case 'E':
                   break;

               default:
                   System.out.println("Invalid option");
           }
       }while (option != 'E');

   }


}
