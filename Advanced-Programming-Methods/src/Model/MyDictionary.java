package Model;

import java.util.*;

public class MyDictionary <Key,Value> implements IDictionary<Key,Value> {
	private HashMap <Key,Value> _map;
	
	public MyDictionary(HashMap <Key,Value> _map){
		this._map=_map;
	}

	@Override
	public Value put(Key key, Value value) {
		// TODO Auto-generated method stub
		return this._map.put(key, value);
	}

	@Override
	public Value get(Key key) {
		return this._map.get(key);
	}
	
	@Override
	public String toString(){
		return this._map.toString();
	}

	@Override
	public Collection<Value> values() {
		// TODO Auto-generated method stub
		return this._map.values();
	}

	@Override
	public Value remove(Key fileDescriptor) {
		// TODO Auto-generated method stub
		return this._map.remove(fileDescriptor);
	}
}
