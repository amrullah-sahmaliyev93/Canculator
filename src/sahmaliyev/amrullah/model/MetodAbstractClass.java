package sahmaliyev.amrullah.model;

import static sahmaliyev.amrullah.print.Print.printL;

public abstract class MetodAbstractClass {
	// ����� �������� ������ ������
	public void headInPrograming() {
		printL("����� ���������� � ���� ����������� ���������!");
		printL("���������� ��������� ����������� �������� � ����� ��������� ����� ��������� � ��������.\n��� ������ � ��������� �������:������ ����� 1\n��� ������ � �������� �������: ������ ����� 2 ");
	}

	// ����� ������ ��������� ��� �������� (+,-,*,/)
	public int calcMetod(int a, String operation, int b) {
		int resultMetodtoReturn = 0;
		switch (operation) {
		case "+":
			resultMetodtoReturn = a + b;
			break;
		case "-":
			resultMetodtoReturn = a - b;
			break;
		case "*":
			resultMetodtoReturn = a * b;
			break;
		case "/":
			if (b == 0) {
				throw new ArithmeticException("����� �� 0 ������.");
			}
			resultMetodtoReturn = a / b;
			break;
		default:
			printL("���� �������� ��������");
			break;
		}
		return resultMetodtoReturn;
	}

	// ����������� ������ ������� ���������������� � ����������.
	abstract int splitNumber(String number) throws Exception;

	abstract void resultMetodInPrograming(String str);

}
