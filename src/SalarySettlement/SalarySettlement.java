package SalarySettlement;

import java.time.LocalDate;

import Empoleyee.Empoleyee;

public class SalarySettlement {
	private String adress;
	private LocalDate date;
	private Double grossSalary;
	private Double netSalary;
	private String details;
	private Empoleyee empoleyee;
	
	public SalarySettlement(Empoleyee aEmpoleyee) {
		this.empoleyee = aEmpoleyee;
		this.adress = aEmpoleyee.getAdress();
		this.date = LocalDate.now();
		this.grossSalary = aEmpoleyee.getGrossSalary();
		this.netSalary = aEmpoleyee.getNetIncome();
		this.details = aEmpoleyee.getSettlementDetails();
	}
	
	
	public String getAdress() {
		return adress;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public Double getGrossSalary() {
		return grossSalary;
	}
	
	public Double getNetSalary() {
		return netSalary;
	}

	public String getDetails() {
		return details;
	}

	public Empoleyee getEmpoleyee() {
		return empoleyee;
	}
}
