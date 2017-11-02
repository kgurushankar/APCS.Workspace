package kgurushankar.checkmail;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter 1st Dimension: ");
		int dim1 = in.nextInt();
		System.out.print("Enter 2nd Dimension: ");
		int dim2 = in.nextInt();
		System.out.print("Enter 3rd Dimension: ");
		int dim3 = in.nextInt();
		System.out.print("Enter Weight: ");
		int weight = in.nextInt();
		in.close();
		System.out.println(new Package(dim1, dim2, dim3, weight).firstClass());
	}
}