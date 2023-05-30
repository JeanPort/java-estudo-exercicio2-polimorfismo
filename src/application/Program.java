package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		List<TaxPayer> taxPayers = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int numberTax = scanner.nextInt();
		
		for (int i = 1; i <= numberTax; i++) {
			System.out.println("Tax payer #" + i + " data: ");
			System.out.print("Individual or company (i/c)? ");
			char resp = scanner.next().charAt(0);
			
			System.out.print("Name: ");
			scanner.nextLine();
			String name = scanner.nextLine();
			
			System.out.print("Anual income: ");
			double anualIncome = scanner.nextDouble();
			
			if (resp == 'i') {
				System.out.print("Health expenditures: ");
				double health = scanner.nextDouble();
				taxPayers.add(new Individual(name, anualIncome, health));
			}else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = scanner.nextInt();
				taxPayers.add(new Company(name, anualIncome, numberOfEmployees));
			}
			
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		double totalTaxes = 0.00;
		for (TaxPayer taxPayer : taxPayers) {
			System.out.println(taxPayer);
			totalTaxes += taxPayer.tax();
		}
		
		System.out.println("TOTAL TAXES: $" + String.format("%.2f", totalTaxes));
		
		scanner.close();
	}

}
