package Model;

import java.io.BufferedReader;

public class PrgState {
	private MyIStack <Statement> exeStack;
	private IDictionary <String,Integer> symTable;
	private IList <Integer> out;
	private Statement originalProgram;
	
	//fileTable lab5
	private IDictionary<Integer,Tuple<String,BufferedReader>> FileTable;
	
	public PrgState(MyIStack<Statement> exeStack,IDictionary <String,Integer> symTable,IList <Integer> out,Statement program,IDictionary<Integer,Tuple<String,BufferedReader>> fileTable)
	{
		this.exeStack=exeStack;
		this.symTable=symTable;
		this.out=out;
		this.originalProgram=program;
		this.exeStack.push(program);
		this.FileTable=fileTable;
	}
	
	public MyIStack<Statement> getExeStack(){
		return this.exeStack;
	}
	
	public IDictionary<String,Integer> getSymTable(){
		return this.symTable;
	}
	
	public IList<Integer> getOut(){
		return this.out;
	}
	
	public IDictionary<Integer,Tuple<String,BufferedReader>> getFileTable(){
		return this.FileTable;
	}
	

	public String toString()
	{
		String buffer;
		buffer=exeStack.toString()+"  "+ symTable.toString()+ "  " + out.toString() + FileTable.toString() +"\n";
		return buffer;
	}
	

}
