package Empoleyee;

import java.time.LocalDate;

public class ContractEmpoleyee extends Empoleyee{

	private static Double ADMINISTRATIVE_RETENTIONS = 50.; 
	
	private Integer contractNumber;
	private String payMethod;
	
	public ContractEmpoleyee(String aName, String aAdress, MaritalStatus aMaritalStatus, LocalDate aBirthDate, Double aBasicSalary, Integer aContractNumber, String aPayMethod) {
		super(aName, aAdress, aMaritalStatus, aBirthDate, aBasicSalary);
		this.contractNumber = aContractNumber;
		this.payMethod = aPayMethod;
	}

	@Override
	protected Double calculateRetirementContribution() {
		return 0.;
	}

	@Override
	protected Double calculateUnionWorksContribution() {
		return 0.;
	}

	@Override
	public String getSettlementDetails() {
		return this.getDescriptionLine("SALARIO BASICO", this.getBasicSalary())
		+ this.getDescriptionLine("GASTOS ADMINISTRATIVOS",  - ADMINISTRATIVE_RETENTIONS);
	}

	@Override
	public Double getGrossSalary() {
		return this.getBasicSalary();
	}

	@Override
	public Double getRetentions() {
		return ADMINISTRATIVE_RETENTIONS;
	}

	public Integer getContractNumber() {
		return contractNumber;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

}
