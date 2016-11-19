package Tests;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import Model.MyIStack;
import Model.MyStack;
import Model.Statement;

public class ExeStackTest {
	
	private MyIStack<Integer> exeStack;
	
	@Before
	public void setUp()
	{
		exeStack= new MyStack<>(new Stack<Integer>());
		exeStack.push(1);
		exeStack.push(2);
	}
	
	@Test
	public void test() {
		//peek test
		exeStack.push(3);
		Integer expected=3;
		assertEquals(expected,exeStack.peek());
		
		//pop test
		Integer x,y;
		x=exeStack.pop();
		y=exeStack.pop();
		
		assertEquals(expected,x);
		expected=2;
		assertEquals(expected,y);
		
		//empty test
		exeStack.pop();
		assertTrue(exeStack.isEmpty());
		
	}

}
