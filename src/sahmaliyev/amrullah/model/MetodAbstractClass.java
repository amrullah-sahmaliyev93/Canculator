package sahmaliyev.amrullah.model;

import static sahmaliyev.amrullah.print.Print.printL;

public abstract class MetodAbstractClass {
	// метод печатает данную строку
	public void headInPrograming() {
		printL("Добро пожаловать в нашу Канкульятор программу!");
		printL("Консольная программа канкульятор работает с двумя форматами чисел арабскими и римскими.\nДля работы с арабскими числами:ведите число 1\nДля работы с римскими числами: ведите число 2 ");
	}

	// метод которы выполняет все операций (+,-,*,/)
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
				throw new ArithmeticException("Делит на 0 нельзя.");
			}
			resultMetodtoReturn = a / b;
			break;
		default:
			printL("Вели неверную операцию");
			break;
		}
		return resultMetodtoReturn;
	}

	// абстрактные методы которые переопределяются в подклассах.
	abstract int splitNumber(String number) throws Exception;

	abstract void resultMetodInPrograming(String str);

}
