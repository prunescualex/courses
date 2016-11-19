package Model;
import java.util.*;
import java.util.Stack;

public class MyStack <T> implements MyIStack <T> {
	private Stack <T> stk;
	
	
	public MyStack (Stack <T> stack)
	{
		this.stk=stack;
	}
	@Override
	public void push(T element) {
		// TODO Auto-generated method stub
		this.stk.push(element);
		
	}
	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return this.stk.pop();
	}
	@Override
	public boolean isEmpty() {
		return this.stk.isEmpty();
	}
	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return this.stk.peek();
	}
	
	@Override

    public String toString() {
        return this.stk.toString();

    }
}

