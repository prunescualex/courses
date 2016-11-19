package Tests;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import Model.ArithmExp;
import Model.ConstExp;
import Model.IDictionary;
import Model.MException;
import Model.MyDictionary;
import Model.VarExp;

public class ArithmTest {

	@Test
	public void test() throws MException {
		IDictionary<String,Integer> symTable=new MyDictionary<>(new HashMap<String,Integer>());
		symTable.put("a", 10);
		VarExp exp1=new VarExp("a");
		ConstExp exp2=new ConstExp(5);
		
		ArithmExp test1=new ArithmExp('+',exp1,exp2);
		ArithmExp test2=new ArithmExp('-',exp1,exp2);
		ArithmExp test3=new ArithmExp('*',exp1,exp2);
		ArithmExp test4=new ArithmExp('/',exp1,exp2);
		
		try
		{
			assertEquals(15,test1.eval(symTable));
			assertEquals(5,test1.eval(symTable));
			assertEquals(50,test1.eval(symTable));
			assertEquals(2,test1.eval(symTable));
			assertTrue(false);
		}
		catch(MException ex)
		{
			return;
		}
	}

}
