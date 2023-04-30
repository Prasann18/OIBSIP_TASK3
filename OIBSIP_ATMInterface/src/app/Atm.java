package app;

import java.util.ArrayList;
import java.util.Scanner;

public class Atm {

	ArrayList<String> ar = new ArrayList<String>();

	public static void main(String[] args) {
		int userId, userPin;
		// Initial account balance for the user will be 60000
		int currentBalance = 60000;
		Scanner scanner = new Scanner(System.in);
		TransactionHistory history = new TransactionHistory();

		// User ID will be 123
		System.out.println("Enter your ID:");
		userId = scanner.nextInt();
		while (userId != 123) {
			System.out.println("\nPlease Enter valid ID");
			System.out.println("Enter your ID:");
			userId = scanner.nextInt();
		}

		// User PIN will be 000
		System.out.println("\nEnter your Pin:");
		userPin = scanner.nextInt();
		while (userPin != 000) {
			System.out.println("\nPlease Enter valid PIN");
			System.out.println("\nEnter your PIN:");
			userPin = scanner.nextInt();
		}

		System.out.println("*****Welcome to Atm Machine*****");

		int choice;
		boolean quit = false;
		do {
			System.out.println("-----Enter your choice-----");
			System.out.println("Enter 1 for Transaction history");
			System.out.println("Enter 2 for Withdraw");
			System.out.println("Enter 3 for Deposit");
			System.out.println("Enter 4 for Transfer");
			System.out.println("Press 5 to see your Account balance");
			System.out.println("Enter 6 for quit");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				history.showHistory();
				break;

			case 2:

				Withdrwal withDrwal = new Withdrwal();
				currentBalance = withDrwal.withdrawAmount(currentBalance, history);
				break;

			case 3:
				Deposit deposit = new Deposit();
				currentBalance = deposit.depositAmount(currentBalance, history);
				break;

			case 4:
				Transfer transfer = new Transfer();
				currentBalance = transfer.transferAmount(currentBalance, history);
				break;

			case 5:
				System.out.println("Your Current Account balance is = " + currentBalance);
				System.out.println("*********************************************************************");
				break;

			case 6:
				System.out.println("Thank you for using our ATM service!!");
				System.out.println("*********************************************************************");
				quit = true;
				break;

			default:
				System.out.println("\nPlease Enter correct choice");
				break;

			}
		} while (!quit);
		return;
	}

}
