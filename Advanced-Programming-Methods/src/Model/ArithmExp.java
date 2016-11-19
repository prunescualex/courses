package Model;

public class ArithmExp extends Expression{
	
	private Expression exp1,exp2;
	
	private int operation;
	
	public ArithmExp(char op,Expression e1,Expression e2) throws MException
	{
		this.exp1=e1;
		this.exp2=e2;
		switch(op)
		{
		case '+' : this.operation=0;break;
		case '-' : this.operation=1;break;
		case '*' : this.operation=2;break;
		case '/' : this.operation=3;break;
		default:
		{
			throw new MException("Invalid operation !");
		}
		}
	}

	@Override
	public int eval(IDictionary<String, Integer> symTable) throws MException {
		// TODO Auto-generated method stub
		int result=0;
		int x,y;
		x=this.exp1.eval(symTable);
		y=this.exp2.eval(symTable);
		switch(operation)
		{
		case 0: result=x+y;break;
		case 1: result=x-y;break;
		case 2: result=x*y;break;
		case 3:
		{
			if(y==0)
				throw new MException("Can not divide by 0 !");
			else
			{
				result=x/y;
				break;
			}
		}
		default:
		{
			throw new MException("Invalid operation!");
		}
		}
		return result;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result=this.exp1.toString();
		switch(operation)
		{
		case 0: result += '+';break;
		case 1: result += '-';break;
		case 2: result += '*';break;
		case 3: result += '/';break;
		}
		result += this.exp2.toString();
		return result;
	}
		
}
