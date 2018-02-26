
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
	
	/**
	 * Coordinates the problem solving efforts for a Problem 
	 * @param problemToSolve
	 * @return solution to the Problem in String form
	 */
	public String solveProblem(Problem problemToSolve) {
		String solution = determineOperation(problemToSolve);
		problemToSolve.setSolution(solution);
		return solution;
	}
	
	/**
	 * Determines if subtractOperation() or addOperation() method gets called based on the Problem set up
	 * @param problemToDetermineOperationOf
	 * @return soltion to the problem in String form
	 */
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
				solution = "-" + addOperation(problemToDetermineOperationOf);
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
			} else if (firstOpSign.equalsIgnoreCase("+") && secondOpSign.equalsIgnoreCase("-")) {
				solution = addOperation(problemToDetermineOperationOf);
			} else {
				solution = "-" + addOperation(problemToDetermineOperationOf);
			}
				
		}
		return solution;
	}
	
	/**
	 * performs the addition on a problem by using a StackManager and calling the helper add() method
	 * @param problemToPerformAddOpOn
	 * @return the solution in String form
	 */
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
	
	/**
	 * performs the subtraction on a problem by using a StackManager and calling the helper subtract() method
	 * @param problemToPerformSubtractOpOn
	 * @return the solution in String form
	 */
	private String subtractOperation(Problem problemToPerformSubtractOpOn) {
		String solution = "";
		Boolean firstOpIsBigger = problemToPerformSubtractOpOn.isFirstOperandIsBigger();
		String firstOpSign = problemToPerformSubtractOpOn.getFirstOperandSign();
		String secondOpSign = problemToPerformSubtractOpOn.getSecondOperandSign();
		String operator = problemToPerformSubtractOpOn.getOperator();
		
		StackManager firstOpStack = new StackManager();
		StackManager secondOpStack = new StackManager();
		StackManager resultStack = new StackManager();
		
		String firstOp = problemToPerformSubtractOpOn.getFirstOperand();
		for (int i = 0; i < firstOp.length(); i++) {
			firstOpStack.push(firstOp.charAt(i));
		}
		
		String secondOp = problemToPerformSubtractOpOn.getSecondOperand();
		for (int i = 0; i < secondOp.length(); i++) {
			secondOpStack.push(secondOp.charAt(i));
		}
		
		if (firstOpIsBigger) {
			if ((firstOpSign.equalsIgnoreCase("+") && secondOpSign.equalsIgnoreCase("+") && operator.equalsIgnoreCase("-")) ||
					(firstOpSign.equalsIgnoreCase("+") && secondOpSign.equalsIgnoreCase("-") && operator.equalsIgnoreCase("+"))) {
				while (!firstOpStack.isEmpty()) {
					resultStack.push(subtract(firstOpStack.pop(), secondOpStack.pop()));
				}
				while (!resultStack.isEmpty()) {
					solution += resultStack.pop();
				}
				return solution;
			} else {
				while (!firstOpStack.isEmpty()) {
					resultStack.push(subtract(firstOpStack.pop(), secondOpStack.pop()));
				}
				while (!resultStack.isEmpty()) {
					solution += resultStack.pop();
				}
				return "-" + solution;
			}
		} else {
			if ((firstOpSign.equalsIgnoreCase("+") && secondOpSign.equalsIgnoreCase("+") && operator.equalsIgnoreCase("-")) ||
					(firstOpSign.equalsIgnoreCase("+") && secondOpSign.equalsIgnoreCase("-") && operator.equalsIgnoreCase("+"))) {
				while (!firstOpStack.isEmpty()) {
					resultStack.push(subtract(secondOpStack.pop(), firstOpStack.pop()));
				}
				while (!resultStack.isEmpty()) {
					solution += resultStack.pop();
				}
				return "-" + solution;
			} else {
				while (!firstOpStack.isEmpty()) {
					resultStack.push(subtract(secondOpStack.pop(), firstOpStack.pop()));
				}
				while (!resultStack.isEmpty()) {
					solution += resultStack.pop();
				}
				return solution;
			}
		}
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
	
	/**
	 * Performs subtraction actions on two Characters by converting them to ints and back to Characters
	 * @param firstCharacterToSubtract
	 * @param secondCharacterToSubtract
	 * @return the result of the subtraction
	 */
	private Character subtract(Character firstCharacterToSubtract, Character secondCharacterToSubtract) {
		Integer intFirstCharacterToSubtract = Integer.parseInt(firstCharacterToSubtract.toString());
		Integer intSecondCharacterToSubtract = Integer.parseInt(secondCharacterToSubtract.toString());
		
		if(this.borrowFlag == true) {
			intFirstCharacterToSubtract -= 1;
			this.borrowFlag = false;
		} 
		
		if (intFirstCharacterToSubtract.compareTo(intSecondCharacterToSubtract) < 0) {
			intFirstCharacterToSubtract += 10;
			this.borrowFlag = true;
		}
		int subtractResult = intFirstCharacterToSubtract - intSecondCharacterToSubtract;
		char[] convertedSubtractResult = Character.toChars('0' + subtractResult);
		return convertedSubtractResult[0];
	}
}
