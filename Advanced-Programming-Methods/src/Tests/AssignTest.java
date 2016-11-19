package Tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import org.junit.Test;

import Model.AssignStmt;
import Model.ConstExp;
import Model.IDictionary;
import Model.IList;
import Model.MException;
import Model.MyDictionary;
import Model.MyIStack;
import Model.MyList;
import Model.MyStack;
import Model.PrgState;
import Model.Statement;
import Model.Tuple;

public class AssignTest {

	@Test
	public void test() throws FileNotFoundException {
		
		MyIStack<Statement> exeStack= new MyStack<>(new Stack<Statement>());
		IList<Integer> out =new MyList<>(new ArrayList<Integer>());
		IDictionary<String,Integer> symTable=new MyDictionary<>(new HashMap<String,Integer>());
		IDictionary<Integer,Tuple<String,BufferedReader>> fileTable=new MyDictionary<>(new HashMap<Integer,Tuple<String,BufferedReader>>());
		Statement s2=new AssignStmt("b",new ConstExp(10));
		PrgState state=new PrgState(exeStack,symTable,out,s2,fileTable);
		
		try
		{
			Statement s1=new AssignStmt("a",new ConstExp(5));
			PrgState state1=s1.execute(state);
			symTable=state1.getSymTable();
			
			Integer exp=5;
			assertEquals(exp,symTable.get("a"));
		}
		catch(MException ex)
		{
			return;
		}
		
		
	}

}