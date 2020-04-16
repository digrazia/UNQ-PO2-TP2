package Empoleyee;
import java.time.LocalDate;

public class PermanentPlantEmpoleyee extends Empoleyee {


	private static Double CHILD_ALLOWANCE = 150.;
	private static Double SPOUSAL_ALLOWANCE = 100.;
	private static Double ANTIQUITY_ALLOWANCE = 50.;
	private static Double UNION_WORKS_SONS_EXTRA_CONTRIBUTION = 20.;
	private static Double PERCENT_UNION_WORKS_CONTRIBUTION = 0.1;
	private static Double PERCENT_RETIREMENT_CONTRIBUTION = 0.15;
	
	private Integer childrens;
	private LocalDate startDate;
	
	public PermanentPlantEmpoleyee(String aName, String aAdress, MaritalStatus aMaritalStatus, LocalDate aBirthDate, Double aBasicSalary, Integer aNumberOfChildrens) {
		super(aName, aAdress, aMaritalStatus, aBirthDate, aBasicSalary);
		this.childrens = aNumberOfChildrens;
		this.startDate = LocalDate.now();
	}
	
	public Integer getChildrens() {
		return childrens;
	}

	public void setChildrens(Integer childrens) {
		this.childrens = childrens;
	}

	public LocalDate getStartDate() {
		return startDate;
	}
	
	public Integer getAntiquity() {
		return LocalDate.now().getYear() - this.getStartDate().getYear(); 
	}
	
	private Double calculateChildAllowance() {
		return CHILD_ALLOWANCE * this.getChildrens();
	}
	
	private Double calculateSpousalAllowance() {
		return (this.getMaritalStatus() == MaritalStatus.MARRIED) ? (SPOUSAL_ALLOWANCE) : 0;
	}
	
	private Double calculateAntiquityAllowance() {
		return ANTIQUITY_ALLOWANCE * this.getAntiquity();
	}
	
	@Override
	protected Double calculateRetirementContribution() {
		return PERCENT_RETIREMENT_CONTRIBUTION * this.getGrossSalary();
	}

	@Override
	protected Double calculateUnionWorksContribution() {
		return (UNION_WORKS_SONS_EXTRA_CONTRIBUTION * this.getChildrens()) 
			+ (PERCENT_UNION_WORKS_CONTRIBUTION * this.getGrossSalary()); 
	}

	@Override
	public String getSettlementDetails() {
		return this.getDescriptionLine("SALARIO BASICO", this.getBasicSalary())
			+ this.getDescriptionLine("ASIGNACION POR HIJO", this.calculateChildAllowance())
			+ this.getDescriptionLine("ASIGNACION POR CONYUGUE", this.calculateSpousalAllowance())
			+ this.getDescriptionLine("OBRA SOCIAL", - this.calculateUnionWorksContribution())
			+ this.getDescriptionLine("JUBILACION", - this.calculateRetirementContribution())
		;
	}

	@Override
	public Double getGrossSalary() {
		return  this.getBasicSalary()
			+ this.calculateChildAllowance()
			+ this.calculateAntiquityAllowance()
			+ this.calculateSpousalAllowance();	
	}

	@Override
	public Double getRetentions() {
		return this.calculateRetirementContribution()
			+ this.calculateUnionWorksContribution();
	}

}
