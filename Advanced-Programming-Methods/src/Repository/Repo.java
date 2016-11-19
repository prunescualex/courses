package Repository;

import Model.PrgState;
import java.io.*;

/*
 * Implementation of Repository
 */

public class Repo implements IRepo {

	private PrgState state;
	
	private String FileLog;
	private PrintWriter writer;
	private boolean first;
	
	public Repo(PrgState state,String fileLog)
	{
		this.state=state;
		this.FileLog=fileLog;
		this.writer=null;
		this.first=true;
	}
	
	
	@Override
	public PrgState getCurrentState() throws RepoException {
		// TODO Auto-generated method stub
		
		try
		{
			return this.state;
		}
		catch(IndexOutOfBoundsException ex)
		{
			throw new RepoException("There are no programs in the repository!");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see Repository.IRepo#logPrgStateExec()
	 * print the log of prg state to a file
	 * throws FileNotFound if file path is invalid
	 */
	@Override
	public void logPrgStateExec() throws IOException {
		// TODO Auto-generated method stub
		
		//for the first team clear the content
		if (first == true)
		{
			try
			{
				PrintWriter writer=new PrintWriter(new File(FileLog));
				writer.print("");
				writer.close();
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			first=false;
		}
	    //initialize printer
		this.writer = new PrintWriter (new FileWriter(FileLog,true));
		
		//print exeStack
		this.writer.println("Execution Stack : ");
		this.writer.println(this.state.getExeStack().toString());
		
		//print symTable
		this.writer.println("Symbol Table : ");
		this.writer.println(this.state.getSymTable().toString());
		
		//print Out
		this.writer.println("Output :");
		this.writer.println(this.state.getOut().toString());
		
		this.writer.close();
		
	}

}
