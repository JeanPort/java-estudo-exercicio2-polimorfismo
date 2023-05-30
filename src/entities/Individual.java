package entities;

public class Individual extends TaxPayer{

	private Double healthExpenditures;
	
	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public double tax() {
		double percentTax = 0.15;
		
		if(super.getAnualIncome() >= 20000.0) {
			percentTax = 0.25;
		}
		
		double tax = super.getAnualIncome() * percentTax;
		return tax -= healthExpenditures * 0.50;
	}

}
