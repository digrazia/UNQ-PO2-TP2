package Empoleyee;
import java.time.LocalDate;
import java.util.ArrayList;
import SalarySettlement.SalarySettlement;

public abstract class Empoleyee {
	
	protected static String DESCRIPTION_FORMAT = "%30s:\t$%10.2f\n";
	
	protected String name;
	protected String adress;
	protected MaritalStatus maritalStatus;
	protected LocalDate birthDate;
	protected Double basicSalary;
	protected ArrayList <SalarySettlement> salarySettlements = new ArrayList<SalarySettlement>();
	
	public Empoleyee(String aName, String aAdress, MaritalStatus aMaritalStatus, LocalDate aBirthDate, Double aBasicSalary) {
		this.name = aName;
		this.adress = aAdress;
		this.maritalStatus = aMaritalStatus;
		this.birthDate = aBirthDate;
		this.basicSalary = aBasicSalary;
	}
	
	public String getName() {
		return name;
	}

	public String getAdress() {
		return adress;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}


	public Double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(Double basicSalary) {
		this.basicSalary = basicSalary;
	}
	
	public SalarySettlement PayOff() {
		SalarySettlement aSettlement = new SalarySettlement(this);
		this.salarySettlements.add(aSettlement);
		
		return aSettlement;
	}
	
	public Integer getAge() {
		return LocalDate.now().getYear() - this.getBirthDate().getYear();
	}
	
	public Double getNetIncome() {
		return this.getGrossSalary() - this.getRetentions();
	}
	
	protected String getDescriptionLine(String category, Double amount) {
		return String.format(DESCRIPTION_FORMAT, category, amount);
	}
	
	protected abstract Double calculateRetirementContribution();
	
	protected abstract Double calculateUnionWorksContribution();
	
	public abstract String getSettlementDetails();
	
	public abstract Double getGrossSalary();
	
	public abstract Double getRetentions();
}