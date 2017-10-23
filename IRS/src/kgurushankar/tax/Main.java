package kgurushankar.tax;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		AdvancedTaxCalculator t = new AdvancedTaxCalculator(new Bracket.US2017());
		System.out.print("Enter marital status (" + t.getBracket().getStatusList() + "): ");
		String status = in.nextLine();
		System.out.print("Enter taxable income: $ ");
		String income = in.nextLine();
		String tax = t.calculateTax(status, income);
		if (!tax.equals("-1")) {
			System.out.println("Your Federal tax is " + tax);
		} else {
			System.out.println("Please enter valid numbers");
			main(args);
		}
		in.close();
	}

}
