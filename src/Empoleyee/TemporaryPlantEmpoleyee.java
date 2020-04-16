package Empoleyee;
import java.time.LocalDate;

public class TemporaryPlantEmpoleyee extends Empoleyee{

	private static Double OVERTIME_ALLOWANCE = 40.;
	private static Double PERCENT_UNION_WORKS_CONTRIBUTION = 0.1;
	private static Integer UNION_WORKS_AGE_EXTRA_CONTRIBUTION_MIN_AGES = 50;
	private static Double UNION_WORKS_AGE_EXTRA_CONTRIBUTION = 25.;
	private static Double PERCENT_RETIREMENT_CONTRIBUTION = 0.1;
	private static Double RETIREMENT_OVERTIME_EXTRA_CONTRIBUTION = 5.;
	
	
	private LocalDate endDate;
	private Integer overtime = 0;
	
	public TemporaryPlantEmpoleyee(String aName, String aAdress, MaritalStatus aMaritalStatus, LocalDate aBirthDate, Double aBasicSalary, LocalDate aEndDate) {
		super(aName, aAdress, aMaritalStatus, aBirthDate, aBasicSalary);
		this.endDate = aEndDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Integer getOvertime() {
		return overtime;
	}

	public void setOvertime(Integer overtime) {
		this.overtime = overtime;
	}
	
	private Double getUnionWorksAgeExtraContribution() {
		return (UNION_WORKS_AGE_EXTRA_CONTRIBUTION_MIN_AGES < this.getAge())
			? (this.getAge() * UNION_WORKS_AGE_EXTRA_CONTRIBUTION)
			: 0;
	}
	
	private Double getOvertimeAllowance() {
		return OVERTIME_ALLOWANCE * this.getOvertime();
	}
	
	@Override
	protected Double calculateRetirementContribution() {
		return (RETIREMENT_OVERTIME_EXTRA_CONTRIBUTION + this.getOvertime())
			+ (PERCENT_RETIREMENT_CONTRIBUTION * this.getBasicSalary());
	}

	@Override
	protected Double calculateUnionWorksContribution() {
		return this.getUnionWorksAgeExtraContribution() 
			+ (PERCENT_UNION_WORKS_CONTRIBUTION * this.getBasicSalary());
	}

	@Override
	public String getSettlementDetails() {
		return this.getDescriptionLine("SALARIO BASICO", this.getBasicSalary())
			+ this.getDescriptionLine("HORAS EXTRA", this.getOvertimeAllowance())
			+ this.getDescriptionLine("OBRA SOCIAL", - this.calculateUnionWorksContribution())
			+ this.getDescriptionLine("JUBILACION", - this.calculateRetirementContribution());
	}

	@Override
	public Double getGrossSalary() {
		return this.getBasicSalary() + this.getOvertimeAllowance();
	}

	@Override
	public Double getRetentions() {
		return this.calculateRetirementContribution() + this.calculateUnionWorksContribution();
	}

}
