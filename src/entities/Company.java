package entities;

public class Company extends TaxPayer{

	private Integer numberOfEmployees;
	
	public Company(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public double tax() {
		double percentTax = 0.16;
		
		if (numberOfEmployees > 10) {
			percentTax = 0.14;
		}
	
		return super.getAnualIncome() * percentTax;
	}
}
