package Model;

public class ConstExp extends Expression {
	int value;
	
	public ConstExp(int value){
		this.value=value;
	}

	@Override
	public int eval(IDictionary<String, Integer> symTable) {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(value);
	}
}
