package Model;

import java.io.FileNotFoundException;

public class CloseRFileStmt implements Statement{
	
	private Expression exp;
	
	public CloseRFileStmt(Expression newExp)
	{
		this.exp=newExp;
	}
	

	
	@Override
	public String toString()
	{
		return "CloseRFileStmt ("+ this.exp + ")";
	}



	@Override
	public PrgState execute(PrgState state) throws MException, FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
