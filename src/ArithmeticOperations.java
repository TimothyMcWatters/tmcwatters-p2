
/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 2
 * File Name: ArithmeticOperations.java
 * 
 * This Program: Will add and subtract arbitrarily large numbers. When the program starts it 
 * will read in a set of addition and subtraction problems consisting of arbitrarily large integers, 
 * solve these problems, and then display the resultant problem and answer on the display.
 */

public class ArithmeticOperations {
	private boolean firstOperandIsOnTop = false;
	private boolean carryFlag = false;
	private boolean borrowFlag = false;
	private boolean resultIsNegative = false;
	
	public String solveProblem(Problem problemToSolve) {
		return "";
	}
	
	private String determineOperation(Problem problemToDetermineOperationOf) {
		return "";
	}
	
	private String addOperation(Problem problemToPerformAddOpOn) {
		return "";
	}
	
	private String subtractOperation(Problem problemToPerformSubtractOpOn) {
		return "";
	}
	
	private Character add(Character firstCharacterToAdd, Character secondCharacterToAdd) {
		int carry = 0;
		if (this.carryFlag == true) {
			carry = 1;
		} else {
			carry = 0;
		}
		this.carryFlag = false;
		int addResult = Integer.parseInt(firstCharacterToAdd.toString()) + Integer.parseInt(secondCharacterToAdd.toString()) + carry;
		if (addResult > 9) {
			this.carryFlag = true;
			int lastDigit = (addResult - 10);
			return (char)(lastDigit);
		} else {
			return (char) addResult;
		}
	}
	
	private Character subtract(Character firstCharacterToSubtract, Character secondCharacterToSubtract) {
		boolean borrow = borrowFlag;
		borrowFlag = false;
		
		return ' ';
	}
}
