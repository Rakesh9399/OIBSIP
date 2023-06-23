import java.util.Scanner;

class Account{
	
	Scanner sc = new Scanner(System.in);
	String accountNo = "46418100006070";
	int pin = 1234;
	float accountBalance = 250000.2f;
	int transactions = 0;
	String transactionHistory = "";

	public boolean login() {
		boolean isLogin = false;
		System.out.println("Enter Your Account Number");
		String UserAccNo = sc.nextLine();
		
		if(accountNo.equals(UserAccNo)) {
			System.out.println("Enter PIN");
			int userPin = sc.nextInt();
			if(pin == userPin) {
				isLogin = true;
			}
			else {
			    System.out.println("Incorrect PIN");
			    isLogin = false;
	    	}
		}
		else {
			System.out.println("Incorrect Account Number...");
			 isLogin = false;
		}
		return isLogin;
	}
	
	public void transactionHistory(){
		if(transactions == 0) {
			System.out.println("No transactions.\n");
		}
		else {
			System.out.println(transactionHistory);
		}
		
	}
	
	public void withdraw() {
		System.out.println("Enter amount to withdraw ");
		float amount = sc.nextFloat();
		
		if(accountBalance >= amount) {
			if(amount <= 10000) {
				accountBalance -= amount;
				transactions++;
				String str = "Rs "+amount + " Withdrawn Succesfully\n";
				transactionHistory = transactionHistory + str;				
				System.out.println(str);	
			}
			else {
				System.out.println("Limit is 10000.00.\n");
			}
		}
		else {
			System.out.println("Insufficient Balance.\n");
		}	
	}
	
	public void deposit() {
		System.out.println("Enter amount to deposit:");
		float amount = sc.nextFloat();
		
		if(amount <= 10000f) {
			accountBalance += amount;
			transactions++;
			String str = "Rs "+amount + " Deposited.\n";
			transactionHistory = transactionHistory + str;
			System.out.println(str);
		}
		else {
			System.out.println("Limit is 10000.00.\n");
		}
	}
	
	public void transfer() {
		System.out.println("Enter Account Number of Receipent:");
		String AccNumberR = sc.next();
		
		System.out.println("Enter amount to transfer:");
		sc.nextLine();
		float amount = sc.nextFloat();
		
		if(accountBalance >= amount) {
			if(amount <= 15000f) {
				System.out.println("\nAmount transfered Successfully.\n");
				accountBalance -= amount;
				transactions++;
				String str = "Rs "+amount + " transfered to " + AccNumberR + "\n";
				transactionHistory = transactionHistory + str;				
		    }
			else {
				System.out.println("Limit is 15000.00.\n");
			}
		}
		else {
			System.out.println("Insufficient Balance.\n");
		}
	}

	public void checkBalance() {
		System.out.println("Rs." + accountBalance + "\n");
	}

}

public class AtmInterface {
    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account a = new Account();
		System.out.println("------------- WELCOME to ATM -------------");
		System.out.println("\nPlease Insert your card\n");
		
		if(a.login()) {
			boolean flag = false;
		    while(!flag) {
		    	System.out.println("Enter your choice");
				System.out.println("1.Transactions History\n2.Withdraw\n3.Deposit\n4.Transfer Money\n5.Check Balance\n6.Exit\n");
				int choice = sc.nextInt();
				
				switch(choice){
					case 1:
						a.transactionHistory();
						break;
					case 2:
						a.withdraw();
						break;
					case 3:
						a.deposit();
						break;
					case 4:
						a.transfer();
						break;
					case 5:
						a.checkBalance();
						break;
					case 6:
						flag = true;
						System.out.println("\nThankyou for Using Atm");
						break;
					default:
						System.out.println("Please Enter correct choice ");				
				}
			}
		}
		
	}
}
