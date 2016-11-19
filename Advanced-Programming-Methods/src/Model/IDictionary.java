package Model;

import java.util.*;

public interface IDictionary <Key,Value> {
	Value put (Key key,Value value);
	Value get (Key key);
	Collection<Value> values();
	Value remove(Key fileDescriptor);
}
