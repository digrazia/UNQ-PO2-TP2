package examples;
import java.time.LocalDate;
import java.time.Month;

import Company.Company;
import Empoleyee.*;

public class example1 {

	public static void main(String[] args) {
		Company aCompany = new Company("testCompany", 12345678);
		TemporaryPlantEmpoleyee Francisco = aCompany.addTemporaryPlantEmpoleyee("Francisco", "Balcarce 50", MaritalStatus.DIVORCED, LocalDate.of(1990, Month.DECEMBER, 31), 300.20, LocalDate.of(2024, Month.MARCH, 23));
		Francisco.setOvertime(9);
		showEmpoleyeeData(Francisco);
		showEmpoleyeeData(aCompany.addPermanentPlantEmpoleyee("Carlos", "cochabamba 1234", MaritalStatus.MARRIED, LocalDate.of(1977, Month.JANUARY, 1), 500., 0));
		showEmpoleyeeData(aCompany.addPermanentPlantEmpoleyee("Roberto", "La Rioja 34", MaritalStatus.SINGLE, LocalDate.of(1988, Month.FEBRUARY, 12), 520.44, 2));
		showEmpoleyeeData(aCompany.addTemporaryPlantEmpoleyee("Juan", "La Pampa 333", MaritalStatus.SINGLE, LocalDate.of(1988, Month.MARCH, 9), 300., LocalDate.of(2024, Month.MARCH, 23)));	
		System.out.print(String.format("\n====================================\n%30s:\t$%10.2f\n","TOTAL SUELDOS NETOS", aCompany.getTotalAmountOfNetIncome()));
	}
	
	private static void showEmpoleyeeData(Empoleyee aEmpoleyee) {
		System.out.print(aEmpoleyee.getName() + "\n================\n");
		System.out.print(aEmpoleyee.getSettlementDetails());
	}

}
