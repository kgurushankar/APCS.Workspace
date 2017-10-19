package kgurushankar.tax;

import java.util.Scanner;

import kgurushankar.tax.brackets.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		AdvancedTaxCalculator t = new AdvancedTaxCalculator(new Bracket.US2001());
		System.out.print("Enter marital status (" + t.getBracket().getStatusList() + "): ");
		String status = in.nextLine();
		System.out.print("Enter taxable income: $ ");
		String income = in.nextLine();
		double tax = t.calculateTax(status, income);
		if (tax != -1.0) {
			System.out.println("Your Federal tax is $ " + tax);
		} else {
			System.out.println("Please enter valid numbers");
			main(args);
		}
		in.close();
	}

}
