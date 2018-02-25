
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
		String solution = determineOperation(problemToSolve);
		problemToSolve.setSolution(solution);
		return solution;
	}
	
	private String determineOperation(Problem problemToDetermineOperationOf) {
		String solution = "";
		String firstOpSign = problemToDetermineOperationOf.getFirstOperandSign();
		String secondOpSign = problemToDetermineOperationOf.getSecondOperandSign();
		String operator = problemToDetermineOperationOf.getOperator();
		
		if (operator.equalsIgnoreCase("+")) {
			if (firstOpSign.equalsIgnoreCase("+") && secondOpSign.equalsIgnoreCase("+")) {
				solution = addOperation(problemToDetermineOperationOf);
			}
			else if (firstOpSign.equalsIgnoreCase("-") && secondOpSign.equalsIgnoreCase("-")) {
				solution = addOperation(problemToDetermineOperationOf);
			} else {
				solution = subtractOperation(problemToDetermineOperationOf);
			}
		}
		if (operator.equalsIgnoreCase("-")) {
			if (firstOpSign.equalsIgnoreCase("+") && secondOpSign.equalsIgnoreCase("+")) {
				solution = subtractOperation(problemToDetermineOperationOf);
			}
			else if (firstOpSign.equalsIgnoreCase("-") && secondOpSign.equalsIgnoreCase("-")) {
				solution = subtractOperation(problemToDetermineOperationOf);
			} else {
				solution = addOperation(problemToDetermineOperationOf);
			}
		}
		return solution;
	}
	
	private String addOperation(Problem problemToPerformAddOpOn) {
		String solution = "";
		StackManager firstOpStack = new StackManager();
		StackManager secondOpStack = new StackManager();
		StackManager resultStack = new StackManager();
		
		String firstOp = problemToPerformAddOpOn.getFirstOperand();
		for (int i = 0; i < firstOp.length(); i++) {
			firstOpStack.push(firstOp.charAt(i));
		}
		
		String secondOp = problemToPerformAddOpOn.getSecondOperand();
		Character[] secondOpCharacterArray;
		for (int i = 0; i < secondOp.length(); i++) {
			secondOpStack.push(secondOp.charAt(i));
		}

		while (!firstOpStack.isEmpty()) {
			resultStack.push(add(firstOpStack.pop(), secondOpStack.pop()));
		}

		while (!resultStack.isEmpty()) {
			solution += resultStack.pop();
		}
		return solution;
	}
	
	private String subtractOperation(Problem problemToPerformSubtractOpOn) {
		return "";
	}
	
	/**
	 * Performs addition on two character representations of int's
	 * will return the last digit of the result, and if result is > 9 will update carryFlag to true
	 * @param firstCharacterToAdd
	 * @param secondCharacterToAdd
	 * @return a character representation of the last digit of the addition performed
	 */
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
			char[] convertedAddResult = Character.toChars('0' + lastDigit);
			return convertedAddResult[0];
		} else {
			char[] convertedAddResult = Character.toChars('0' + addResult);
			return convertedAddResult[0];
		}
	}
	
	private Character subtract(Character firstCharacterToSubtract, Character secondCharacterToSubtract) {
		this.borrowFlag = false;
		Integer intFirstCharacterToSubtract = Integer.parseInt(firstCharacterToSubtract.toString());
		Integer intSecondCharacterToSubtract = Integer.parseInt(secondCharacterToSubtract.toString());
		if (intFirstCharacterToSubtract.compareTo(intSecondCharacterToSubtract) < 0) {
			intFirstCharacterToSubtract += 10;
			this.borrowFlag = true;
		}
		int subtractResult = intFirstCharacterToSubtract - intSecondCharacterToSubtract;
		char[] convertedSubtractResult = Character.toChars('0' + subtractResult);
		return convertedSubtractResult[0];
	}
}
