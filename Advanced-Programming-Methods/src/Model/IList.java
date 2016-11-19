package Model;

public interface IList <T> {
	void add(T element);
	T get(int index);
	boolean remove(T element);
	T remove(int index);
	int size();
}
