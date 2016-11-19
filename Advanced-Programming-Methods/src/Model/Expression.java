package Model;

public abstract class Expression {

	abstract public int eval(IDictionary<String,Integer> symTable) throws MException;
	abstract public String toString();
}
