package sahmaliyev.amrullah.model;

import static sahmaliyev.amrullah.print.Print.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class CanculatorRoman extends MetodAbstractClass {
	/*
	 * метод которы получает данные из консоли и разделяет эту строку на части как
	 * массив,после этого возврашает резултат:
	 */
	@Override
	public int splitNumber(String number)
			throws NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException {
		int resultToArabic = 0;
		String[] splitNumber = number.split("\\s");
		if (splitNumber.length == 3) {
			int numberOne = romanToInteger2(splitNumber[0]);
			int numberTwo = romanToInteger2(splitNumber[2]);
			if (numberOne == 0 || numberTwo == 0) {
				throw new NullPointerException("т.к. используются одновременно разные системы счисления - ");
			}
			int result = calcMetod(numberOne, splitNumber[1], numberTwo);
			if (result < 1) {
				throw new ArithmeticException("т.к. в римской системе нет отрицательных чисел");
			}
			String resultToRomanian = intToRoman(result);
			resultToArabic = romanToInteger2(resultToRomanian);
		} else if (splitNumber.length > 3) {
			throw new ArrayIndexOutOfBoundsException(
					"формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

		} else if (splitNumber.length < 3) {
			throw new ArrayIndexOutOfBoundsException("т.к. строка не является математической операцией");
		}

		return resultToArabic;
	}

	/*
	 * метод получает аргумент в типе стриг и возврашает переобразованного число от
	 * римского числа в инт
	 */
	public int romanToInteger2(String s) {
		Map<Character, Integer> values = new LinkedHashMap<>();
		values.put('I', 1);
		values.put('V', 5);
		values.put('X', 10);
		values.put('L', 50);
		values.put('C', 100);
		values.put('D', 500);
		values.put('M', 1000);

		int number = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i + 1 == s.length() || values.get(s.charAt(i)) >= values.get(s.charAt(i + 1))) {
				number += values.get(s.charAt(i));
			} else {
				number -= values.get(s.charAt(i));
			}
		}
		return number;
	}

	// метод получает аргумен в типе инт и возврашает стринг в типе римского числа
	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		int times = 0;
		String[] romans = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
		int[] ints = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
		for (int i = ints.length - 1; i >= 0; i--) {
			times = num / ints[i];
			num %= ints[i];
			while (times > 0) {
				sb.append(romans[i]);
				times--;
			}
		}

		return sb.toString();
	}

	/*
	 * метод выводит резултат и отрабатывает исключения возврашенные из метода
	 * splitNumber
	 */
	@Override
	public void resultMetodInPrograming(String str) {
		// TODO Auto-generated method stub
		try {
			int result = splitNumber(str);
			printL("Результат = " + intToRoman(result));
		} catch (NullPointerException ex) {
			printL(ex.toString());
		} catch (ArithmeticException ex) {
			printL(ex.toString());
		} catch (ArrayIndexOutOfBoundsException ex) {
			printL(ex.toString());
		} catch (Exception e) {
			printL(e.toString());
		}
	}

}
