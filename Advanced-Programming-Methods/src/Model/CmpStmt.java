package Model;

public class CmpStmt implements Statement {
	
	private Statement first,second;
	
	public CmpStmt(Statement first,Statement second)
	{
		this.first=first;
		this.second=second;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return '(' + first.toString() + ',' + second.toString() + ')';
	}

	@Override
	public PrgState execute(PrgState state) {
		// TODO Auto-generated method stub
		MyIStack <Statement> stk= state.getExeStack();
		stk.push(second);
		stk.push(first);
		return state;
	}

}
