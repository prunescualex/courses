package Model;

public class VarExp extends Expression{
	
	private String id;
	
	public VarExp(String id)
	{
		this.id=id;
	}

	@Override
	public int eval(IDictionary<String, Integer> symTable) {
		// TODO Auto-generated method stub
		return symTable.get(id);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id;
	}

}
