package examples;

import java.time.LocalDate;
import java.time.Month;

import Company.Company;
import Empoleyee.*;
import SalarySettlement.SalarySettlement;

public class example2 {

	public static void main(String[] args) {
		Company aCompany = new Company("testCompany", 12345678);
		TemporaryPlantEmpoleyee Francisco = aCompany.addTemporaryPlantEmpoleyee("Francisco", "Balcarce 50", MaritalStatus.DIVORCED, LocalDate.of(1990, Month.DECEMBER, 31), 300.20, LocalDate.of(2024, Month.MARCH, 23));
		Francisco.setOvertime(9);
		payOffAndShow(Francisco);
		payOffAndShow(aCompany.addPermanentPlantEmpoleyee("Carlos", "cochabamba 1234", MaritalStatus.MARRIED, LocalDate.of(1977, Month.JANUARY, 1), 500., 0));
		payOffAndShow(aCompany.addPermanentPlantEmpoleyee("Roberto", "La Rioja 34", MaritalStatus.SINGLE, LocalDate.of(1988, Month.FEBRUARY, 12), 520.44, 2));
		payOffAndShow(aCompany.addTemporaryPlantEmpoleyee("Juan", "La Pampa 333", MaritalStatus.SINGLE, LocalDate.of(1988, Month.MARCH, 9), 300., LocalDate.of(2024, Month.MARCH, 23)));	
		payOffAndShow(aCompany.addContractEmpoleyee("Marcos", "Santa FE 77", MaritalStatus.WIDOWER, LocalDate.of(1990, Month.JULY, 22), 400., 443242, "Paypal"));
	}
	
	public static void payOffAndShow(Empoleyee aEmpoleyee) {
		SalarySettlement aSalarySettlement = aEmpoleyee.PayOff();
		System.out.print(aSalarySettlement.getEmpoleyee().getName() + "\n================\n");
		System.out.print(String.format("%30s:\t %s\n","FECHA DE LIQUIDACION", aSalarySettlement.getDate().toString()));
		System.out.print(String.format("%30s:\t %s\n\n","DIRECCION", aSalarySettlement.getAdress()));
		System.out.print(String.format("%30s:\t$%10.2f\n","SUELDO BRUTO", aSalarySettlement.getGrossSalary()));
		System.out.print(String.format("%30s:\t$%10.2f\n\n","SUELDO NETO", aSalarySettlement.getNetSalary()));
		System.out.print(aSalarySettlement.getDetails());
	}

}
