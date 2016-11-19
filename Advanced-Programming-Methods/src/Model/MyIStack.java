package Model;

public interface MyIStack <T> {
	/*
	 * Adds new statement to stack
	 * @statement-what to add
	 */
	public void push(T element);
	
	/*
	 * removes last element from stack
	 */
	T pop();
	
	/*
	 * Check is empty
	 */
	public boolean isEmpty();
	
	/*
	 * Read the last element
	 */
	T peek();
	
	
}
