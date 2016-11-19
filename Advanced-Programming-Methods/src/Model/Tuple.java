package Model;

public class Tuple<T1, T2> {
	private T1 element1;
	private T2 element2;
	
	public Tuple(T1 newElement1,T2 newElement2)
	{
		this.element1=newElement1;
		this.element2=newElement2;
	}
	
	public T1 getFirst()
	{
		return this.element1;
	}
	
	public T2 getSecond()
	{
		return this.element2;
	}
	
	@Override

    public String toString() {

        return this.element1.toString();

    }

}
