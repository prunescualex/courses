package View;

import Model.*;
import Repository.*;
import Controller.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.*;

//Main class for View package

public class Main {

	public static void main(String[] args) throws MException, FileNotFoundException {
		// TODO Auto-generated method stub
		
		MyIStack<Statement> exeStack= new MyStack<>(new Stack<Statement>());
		IDictionary<String,Integer> symTable=new MyDictionary<>(new HashMap<String,Integer>());
		IList <Integer> out = new MyList<>(new ArrayList<Integer>());
		IDictionary<Integer,Tuple<String,BufferedReader>> fileTable = new MyDictionary<>(new HashMap<Integer,Tuple<String,BufferedReader>>());
		
		// v=2;print(v)
		Statement s1=new CmpStmt(new AssignStmt("v",new ConstExp(2)), new PrintStmt(new VarExp("v")));
		
		
		// a=2+3*5;b=a+1;Print(b)
		Statement s2= new CmpStmt(new AssignStmt("a", new ArithmExp('+',new ConstExp(2),
					  new ArithmExp('*',new ConstExp(3), new ConstExp(5)))),
					  new CmpStmt(new AssignStmt("b",new ArithmExp('+',new VarExp("a"), new
				      ConstExp(1))), new PrintStmt(new VarExp("b"))));
		
		// a=2-2;
        //(If a Then v=2 Else v=3);
        //Print(v)
		Statement s3= new CmpStmt(new AssignStmt("a", new ArithmExp('-',new ConstExp(2), new ConstExp(2))),
					  new CmpStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ConstExp(2)), new
					  AssignStmt("v", new ConstExp(3))), new PrintStmt(new VarExp("v"))));
		
		//a=a/0;print(a);
		
		//PrgState prgState = new PrgState(exeStack, symTable, out,s1);
		PrgState prgState = new PrgState(exeStack, symTable, out,s3,fileTable);

        IRepo repository = new Repo(prgState,"log.txt");

        Controller ctrl = new Controller(repository);
        try
        {
        	ctrl.allStep();
        }
        catch(RepoException ex)
        {
        	System.out.println(ex);
        }
	}

}
