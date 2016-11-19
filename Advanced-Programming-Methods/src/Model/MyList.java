package Model;
import java.util.*;

public class MyList <T> implements IList <T>{
	private List <T> _list;
	
	public MyList(List <T> _list)
	{
		this._list=_list;
	}
	
	@Override
	public void add(T element) {
		// TODO Auto-generated method stub
		this._list.add(element);
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return this._list.get(index);
	}

	@Override
	public boolean remove(T element) {
		// TODO Auto-generated method stub
		return this._list.remove(element);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return this._list.remove(index);
	}
	
	public String toString()
	{
	        return this._list.toString();
	}

}
