package Controller;

import Model.Statement;

import java.io.FileNotFoundException;
import java.io.IOException;

import Model.MException;
import Model.PrgState;
import Repository.IRepo;
import Repository.RepoException;


/*
 * Implementation of Controller class
 */
public class Controller {
	
	IRepo repository;
	
	public Controller(IRepo repository)
	{
		this.repository=repository;
	}
	
	//iterates through execution stack one stept
	public PrgState oneStep(PrgState state) throws MException, FileNotFoundException{
		Statement current = state.getExeStack().pop();
		try
		{
			return current.execute(state);
		}
		catch(MException ex)
		{
			throw ex;
		}
		
	}
	
	//iterates through execution stack until the end
	public void allStep() throws RepoException, MException, FileNotFoundException{
		try
		{
			PrgState current=repository.getCurrentState();
			while(!current.getExeStack().isEmpty())
			{
				oneStep(current);
				//System.out.println("TEST");
				//System.out.println("Exe stack \t| \tsymbol talbe \t| \tout");
				//System.out.println(current.toString());
				try
				{
					repository.logPrgStateExec();
				}
				catch (IOException e)
				{
					 System.out.println("Cannot log program state to file.");
		             return ;
				}
			}
		}
		catch(RepoException ex)
		{
			throw ex;
		}
	}

}
