package Model;

public class IfStmt implements Statement {
	
	private Expression exp;
	private Statement thenStatement,elseStatement;
	
	public IfStmt(Expression exp,Statement thenStmt,Statement elseStmt)
	{
		this.exp=exp;
		this.thenStatement=thenStmt;
		this.elseStatement=elseStmt;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "If "+exp.toString()+"then "+ thenStatement + "else " + elseStatement;
	}

	@Override
	public PrgState execute(PrgState state) throws MException {
		// TODO Auto-generated method stub
		try
		{
			if(exp.eval(state.getSymTable()) == 0)
			{
				state.getExeStack().push(elseStatement);
			}
			else
			{
				state.getExeStack().push(thenStatement);
			}
		}
		catch(MException ex)
		{
			throw ex;
		}
		return state;
	}
	

}
