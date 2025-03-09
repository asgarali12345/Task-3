import java.util.Scanner;
class bankAccount{
    private double balance;
    public bankAccount(double initialBalance){
        if(initialBalance>=0){
            this.balance=initialBalance;
        }else{
            this.balance=0;
        }
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Successfully deposited "+amount);
        }else{
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdrow(double amount){
        if(amount>=0 && amount<=balance){
            balance-=amount;
            System.out.println("Successfully withdraw "+amount);
            return true;
        }else if(amount<=0){
            System.out.println("Invalid withdrawal amount.");
        }else{
            System.out.println("Insufficient fund.");
        }
        return false;
    }
}

class ATM{
    private bankAccount account;
    public ATM(bankAccount account){
        this.account=account;
    }
    
    public void checkBalance(){
        System.out.println("Your current balance is : "+account.getBalance());
    }

    public void withdraw(double amount){
        if(!account.withdrow(amount)){
            System.out.println("Withdrawal failed.");
        }
    }
    public void deposit(double amount){
        account.deposit(amount);
    }

    public void displayMenu(){
        System.out.println("\nATM Menu : ");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    public void startATM(){
        Scanner sc=new Scanner(System.in);
        int choice;
        double amount;

        do{
            displayMenu();
            System.out.print("Choose an option : ");
            choice=sc.nextInt();

            switch(choice){
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit :");
                    amount=sc.nextDouble();
                    deposit(amount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw : ");
                    amount=sc.nextDouble();
                    withdraw(amount);
                    break;
                case 4:
                    System.out.println("Exiting ATM, Thankyou for using this ATM.");
                    break;
                default:
                    System.out.println("Invalid choice, Please try again.");
            }
        }while(choice!=4);
        sc.close();
    }
}

public class codsoftTask3{
    public static void main(String args[]){
        bankAccount userAccount=new bankAccount(5000);
        ATM atm=new ATM(userAccount);
        atm.startATM();
    }
}

