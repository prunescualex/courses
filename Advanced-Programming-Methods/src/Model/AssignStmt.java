package Model;

public class AssignStmt implements Statement {
	private String id;
	private Expression exp;
	
	public AssignStmt(String id,Expression e){
		this.id=id;
		this.exp=e;
	}
	
	@Override
	public String toString(){
		return this.id + '=' + exp.toString();
	}
	
	@Override
	public PrgState execute(PrgState state) throws MException
	{
		 IDictionary<String, Integer> symTable = state.getSymTable();
		 try
		 {
			 symTable.put(this.id, this.exp.eval(symTable));
		 }
		 catch(MException ex)
		 {
			 throw ex;
		 }
	      return state;
	}

}
