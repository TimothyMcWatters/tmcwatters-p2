import java.util.LinkedList;
/**
 * @author Timothy McWatters
 * @version 1.0
 * 
 * COP 4027 Advanced Computer Programming
 * Project 2
 * File Name: StackManager.java
 * 
 * This Program: Will add and subtract arbitrarily large numbers. When the program starts it 
 * will read in a set of addition and subtraction problems consisting of arbitrarily large integers, 
 * solve these problems, and then display the resultant problem and answer on the display.
 */

public class StackManager {
	LinkedList<Character> ll = new LinkedList<Character>();
	//private Node top = null; //Not needed for LinkedList<Character> implemented project version
	
	/**
	 * Pushes a Character on to the stack
	 * @param characterToPushOnStack
	 */
	public void push(Character characterToPushOnStack) {
		ll.push(characterToPushOnStack);
	}
	
	/**
	 * Pops a Character off the stack and returns it
	 * @return Character from the stack
	 */
	public Character pop() {
		return (Character) ll.pop();
	}
	
	/**
	 * Determines if the LinkedList is empty
	 * @return true if empty
	 */
	public boolean isEmpty() {
		return ll.isEmpty();
	}
}
