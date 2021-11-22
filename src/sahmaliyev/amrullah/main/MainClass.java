package sahmaliyev.amrullah.main;

import static sahmaliyev.amrullah.print.Print.*;
import java.util.Scanner;
import sahmaliyev.amrullah.model.CanculatorArabic;
import sahmaliyev.amrullah.model.CanculatorRoman;

/**
 *
 * @author Amrullah Sahmaliyev
 */

public class MainClass {
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CanculatorArabic calcArab = new CanculatorArabic();
		CanculatorRoman calcRom = new CanculatorRoman();
        calcArab.headInPrograming();
		int selectCalculator = sc.nextInt();
		sc.nextLine();
		if (selectCalculator == 1) {		
				printL("Ведите операцию по указонному примеру : 45 + 78");
				String numberAndOperation = sc.nextLine();
				calcArab.resultMetodInPrograming(numberAndOperation);

		} else if (selectCalculator == 2) {
				printL("Ведите операцию по указонному примеру : I + V");
				String numberAndOperation = sc.nextLine();
				calcRom.resultMetodInPrograming(numberAndOperation.toUpperCase());
		} else {
			printL("Ведите число выбора канкулятора:");
		}
		sc.close();

	}

}
