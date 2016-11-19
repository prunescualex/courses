package Tests;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import Model.ConstExp;
import Model.IDictionary;
import Model.MException;
import Model.MyDictionary;

public class ConstExpTest {

	@Test
	public void test() {
		IDictionary<String,Integer> symTable=new MyDictionary<>(new HashMap<String,Integer>());
		ConstExp exp1=new ConstExp(10);
		
		assertEquals(10,exp1.eval(symTable));
	}

}
