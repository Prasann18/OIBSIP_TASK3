package app;

import java.util.ArrayList;
import java.util.Scanner;

class Withdrwal {

	public int withdrawAmount(int currentBalance, TransactionHistory history) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the amount you want to Withdraw = ");
		int withdrawAmount = scanner.nextInt();

		if (withdrawAmount != 0) {
			if (withdrawAmount > currentBalance) {
				System.out.println("You don't have sufficent Balance");
			} else {
				currentBalance = currentBalance - withdrawAmount;
				history.saveHistory("Withdraw : " + withdrawAmount);
				System.out.println("\n Amount : " + withdrawAmount + " has been debited");
				System.out.println("*********************************************************************");
			}

		} else {
			System.out.println("Amount should be greater than 0");
		}
		return currentBalance;
	}
};

class Deposit {

	public int depositAmount(int currentBalance, TransactionHistory history) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n Enter the amount you want to deposite in your account=");
		int depositAmount = scanner.nextInt();
		if (depositAmount != 0) {
			if (depositAmount > 100000) {
				System.out.println("You can't deposit more than Rs. 100000");
			} else {
				currentBalance = currentBalance + depositAmount;
				history.saveHistory("Deposit : " + depositAmount);
				System.out.println("\n Amount : " + depositAmount + " has been deposited in your account");
				System.out.println("*********************************************************************");
			}

		} else {
			System.out.println("Amount should be greater than 0");
		}
		return currentBalance;
	}
};

class Transfer {

	public int transferAmount(int currentBalance, TransactionHistory history) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n Enter the account Number = ");
		int accountNumber = scanner.nextInt();
		if (accountNumber != 0) {
			System.out.println("\n Enter transfer ammount = ");
			int transferAmount = scanner.nextInt();
			if (transferAmount > 100000) {
				System.out.println("You can't transfer more than Rs. 100000");
			} else {
				currentBalance = currentBalance - transferAmount;
				history.saveHistory("Transfer (" + accountNumber + ") : " + transferAmount);
				System.out.println(
						"\n Amount : " + transferAmount + " has been transferred to account - " + accountNumber);
				System.out.println("*********************************************************************");
			}

		} else {
			System.out.println("Enter valid account number");
		}
		return currentBalance;
	}
};

class TransactionHistory {

	ArrayList<String> transactionHistoryArrayList = new ArrayList<String>();

	public void saveHistory(String transactionEntry) {
		transactionHistoryArrayList.add(transactionEntry);
	}

	public void showHistory() {
		if (transactionHistoryArrayList.size() == 0) {
			System.out.println("No Transaction history available for the account.");
			System.out.println("*********************************************************************");
		} else {
			System.out.println("Account Transaction history : ");
			for (int i = 0; i < transactionHistoryArrayList.size(); i++) {
				System.out.println("\n" + transactionHistoryArrayList.get(i));
			}
			System.out.println("*********************************************************************");
		}
	}
};
