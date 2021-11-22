/**

 *@ClassName :Calculator.java

 *

 *@author :   Amit Dhanorkar

 *

 *@Version :        1.0

 *

 *@Date : 22nd Nov 2021

 *

 */

package com.main.calc;

import java.util.Scanner;

public class Calculator
{
	public static final String ADDITION = "Addition";
	public static final String SUBSTRACTION = "Substraction";
	public static final String MULTIPLICATION = "Multiplication";
	public static final String DIVISION = "Division";
	public static final String ADD = "+";
	public static final String SUBSTRACT = "-";
	public static final String MULTIPLY = "*";
	public static final String DIVIDE = "/";

	Scanner sc;

	//Constructor
	public Calculator() {
		this.sc = new Scanner(System.in);
	}

	/**
	 * Method to show Menu list
	 */
	public void showMenu() {
		System.out.println("-------Arithmetic Calculator-------");
		System.out.println("0.Exit");
		System.out.println("1.Addition");
		System.out.println("2.Subtraction");
		System.out.println("3.Multiplicatin");
		System.out.println("4.Division");
		System.out.println("----------------------------------");
		System.out.print("Enter your choice : ");
	}

	/**
	 * Method written to return entered choice number from Menu list
	 * 
	 * @return choice
	 */
	public int getChoice() {
		final int choice = this.sc.nextInt();
		return choice;
	}

	/**
	 * Method written to return entered value for arithmetic operation
	 * 
	 * @return val
	 */
	public float getValue() {
		float val = 0.0f;
		try {
			System.out.print("Enter the value :");
			final String str = this.sc.next();
			val = Float.parseFloat(str);
		}
		catch (NullPointerException | NumberFormatException e) {
			e.printStackTrace();
		}
		return val;
	}

	/**
	 * Method written to do required arithmetic operation and return the result
	 * 
	 * @param value1
	 * @param value2
	 * @param operation
	 * @return return final result one of arithmetic operation, otherwise -1 if operation not equal to mention list operation 
	 * @throws Exception if {@value2} is zero and trying to divide with zero value
	 */
	public float opeartion(float value1, float value2, String operation) throws Exception {
		if (operation.equals(ADD)) 
			return value1 + value2;
		else if (operation.equals(SUBSTRACT))
			return value1 - value2;
		else if(operation.equals(MULTIPLY))
			return value1 * value2;
		else if (operation.equals(DIVIDE)) {
			if (value2 != 0) {
				return value1 / value2;
			} else {
				throw new Exception("Cannot divide by zero");
			}
		}
		return -1;
	}

	public static void main(final String[] args) {
		final Calculator cal = new Calculator();
		float result = 0;
		String operationName = null;
		float val1, val2;
		try {
			while (true) {
				cal.showMenu();
				final int choice = cal.getChoice();
				if (choice == 0) {
					break;
				}
				if (choice > 4 || choice < 0) {
					System.out.println("You've entered incorrect option!!!\n \t Choose AGAIN...");
				}
				else {
					val1 = cal.getValue();
					val2 = cal.getValue();
					switch (choice) {
					case 1:
						operationName = ADDITION;
						result = cal.opeartion(val1, val2, ADD);
						break;

					case 2: 
						operationName = SUBSTRACTION;
						result = cal.opeartion(val1, val2, SUBSTRACT);
						break;

					case 3:
						operationName = MULTIPLICATION;
						result = cal.opeartion(val1, val2, MULTIPLY);
						break;

					case 4: 
						operationName = DIVISION;
						result = cal.opeartion(val1, val2, DIVIDE);
						break;

					}
					System.out.println(operationName + " of number " + val1 + " and " + val2 + " is : " + result);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
