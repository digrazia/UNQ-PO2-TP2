package Company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Function;

import Empoleyee.*;


public class Company {
	private String name;
	private Integer cuit;
	protected ArrayList <Empoleyee> empoleyees = new ArrayList<Empoleyee>();
	
	public Company(String aName, Integer aCuit) {
		this.name = aName;
		this.cuit = aCuit;
	}

	public String getName() {
		return name;
	}

	public Integer getCuit() {
		return cuit;
	}
	
	public PermanentPlantEmpoleyee addPermanentPlantEmpoleyee(String aName, String aAdress, MaritalStatus aMaritalStatus, LocalDate aBirthDate, Double aBasicSalary, Integer aNumberOfChildrens) {
		return (PermanentPlantEmpoleyee) this.addEmpoleyee(new PermanentPlantEmpoleyee(aName, aAdress, aMaritalStatus, aBirthDate, aBasicSalary, aNumberOfChildrens));
	}
	
	public TemporaryPlantEmpoleyee addTemporaryPlantEmpoleyee(String aName, String aAdress, MaritalStatus aMaritalStatus, LocalDate aBirthDate, Double aBasicSalary, LocalDate aEndDate) {
		return (TemporaryPlantEmpoleyee) this.addEmpoleyee(new TemporaryPlantEmpoleyee(aName, aAdress, aMaritalStatus, aBirthDate, aBasicSalary, aEndDate));
	}
	public ContractEmpoleyee addContractEmpoleyee(String aName, String aAdress, MaritalStatus aMaritalStatus, LocalDate aBirthDate, Double aBasicSalary, Integer aContractNumber, String aPayMethod) {
		return (ContractEmpoleyee) this.addEmpoleyee(new ContractEmpoleyee(aName, aAdress, aMaritalStatus, aBirthDate, aBasicSalary, aContractNumber, aPayMethod));
	}
	
	private Empoleyee addEmpoleyee(Empoleyee newEmpoleyee) {
		this.empoleyees.add(newEmpoleyee);
		return newEmpoleyee;
	}

	private Double empoleyeesAmmountReductor(Function<Empoleyee, Double> getter) {
		return this.empoleyees.stream().map(getter).reduce(0., (x,y) -> x + y);
	}
	
	public Double getTotalAmountOfNetIncome() {
		return this.empoleyeesAmmountReductor(e -> e.getNetIncome());
	}		
	
	public Double getTotalAmountOfGrossSalary() {
		return this.empoleyeesAmmountReductor(e -> e.getGrossSalary());
	}
	
	public Double getTotalAmountOfRetentions() {
		return this.empoleyeesAmmountReductor(e -> e.getRetentions());
	}	
	
}
