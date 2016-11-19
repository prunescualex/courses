package Model;

public class PrintStmt implements Statement {
	
	private Expression exp;
	
	public PrintStmt(Expression e){
		this.exp=e;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Print (" + exp + ")";
	}

	@Override
	public PrgState execute(PrgState state) throws MException {
		// TODO Auto-generated method stub
		IList <Integer> out = state.getOut();
		try
		{
			out.add(exp.eval(state.getSymTable()));
		}
		catch(MException ex)
		{
			throw ex;
		}
		return state;
	}

}
