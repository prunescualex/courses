package Tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import org.junit.Test;

import Model.AssignStmt;
import Model.CmpStmt;
import Model.ConstExp;
import Model.IDictionary;
import Model.IList;
import Model.MException;
import Model.MyDictionary;
import Model.MyIStack;
import Model.MyList;
import Model.MyStack;
import Model.PrgState;
import Model.PrintStmt;
import Model.Statement;
import Model.Tuple;
import Model.VarExp;

public class CmpTest {

	@Test
	public void test() throws FileNotFoundException {
		MyIStack<Statement> exeStack= new MyStack<>(new Stack<Statement>());
		IList<Integer> out =new MyList<>(new ArrayList<Integer>());
		IDictionary<String,Integer> symTable=new MyDictionary<>(new HashMap<String,Integer>());
		IDictionary<Integer,Tuple<String,BufferedReader>> fileTable=new MyDictionary<>(new HashMap<Integer,Tuple<String,BufferedReader>>());
		
		Statement s1=new AssignStmt("a",new ConstExp(5));
		Statement s2=new PrintStmt(new VarExp("a"));
		
		Statement s3;
		Statement s4;
		
		PrgState state=new PrgState(exeStack,symTable,out,s1,fileTable);
		try
		{
			Statement compound=new CmpStmt(s1,s2);
			state=compound.execute(state);
			exeStack=state.getExeStack();
			s3=exeStack.pop();
			s4=exeStack.pop();
			
			
			assertEquals(new AssignStmt("a",new ConstExp(5)), s3);
			assertEquals(new PrintStmt(new VarExp("a")), s4);
			
			
		}
		catch(MException ex)
		{
			return;
		}
	}

}
