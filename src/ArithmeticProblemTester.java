
/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 2
 * File Name: ArithmeticProblemTester.java
 * 
 * This Program: Will add and subtract arbitrarily large numbers. When the program starts it 
 * will read in a set of addition and subtraction problems consisting of arbitrarily large integers, 
 * solve these problems, and then display the resultant problem and answer on the display.
 */

public class ArithmeticProblemTester {

	public static void main(String[] args) {
		String fileName = "addsAndSubtracts";

		FileOperations fileOps = new FileOperations();
		fileOps.readFile(fileName);
		
		GenerateProblems genProbs = new GenerateProblems();
		genProbs.populateProblemList();
		
		for (int i = 0; i < GenerateProblems.getCollectionOfProblems().size(); i++) {
			Problem problem = GenerateProblems.getCollectionOfProblems().get(i);
			problem.printProblem();
		}
		ArithmeticOperations aOps = new ArithmeticOperations();
		aOps.solveProblem(GenerateProblems.getCollectionOfProblems().get(0));

	}

}
