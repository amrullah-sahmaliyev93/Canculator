package sahmaliyev.amrullah.model;

import static sahmaliyev.amrullah.print.Print.*;

/**
 *
 * @author Amrullah Sahmaliyev
 */
public class CanculatorArabic extends MetodAbstractClass {

	/*
	 * ����� ������ �������� ������ �� ������� � ��������� ��� ������ �� ����� ���
	 * ������,����� ����� ���������� ��������:
	 */
	@Override
	public int splitNumber(String number) throws NumberFormatException, ArrayIndexOutOfBoundsException {
		int result = 0;
		String[] splitNumber = number.split("\\s");
		if (splitNumber.length == 3) {
			int numberOne = Integer.parseInt(splitNumber[0]);
			int numberTwo = Integer.parseInt(splitNumber[2]);
			result = calcMetod(numberOne, splitNumber[1], numberTwo);
		} else if (splitNumber.length > 3) {
			throw new ArrayIndexOutOfBoundsException(
					"������ �������������� �������� �� ������������� ������� - ��� �������� � ���� �������� (+, -, /, *)");

		} else {
			throw new ArrayIndexOutOfBoundsException("�.�. ������ �� �������� �������������� ���������");
		}

		return result;
	}

	// ����� ������� �������� � ������������ ���������� ������������ �� ������
	// splitNumber
	@Override
	public void resultMetodInPrograming(String str) {
		try {
			int resultArabicCalc = splitNumber(str);
			print("��������� = " + resultArabicCalc);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			printL(e.getClass()+" �.�. ������������ ������������ ������ ������� ���������");
		} catch (ArrayIndexOutOfBoundsException e) {
			printL(e.toString());
		} catch (ArithmeticException ex) {
			printL(ex.toString());

		} catch (Exception e) {
			printL(e.toString());
		}

	}

}
