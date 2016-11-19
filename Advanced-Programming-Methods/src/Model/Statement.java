package Model;

import java.io.FileNotFoundException;

public interface Statement {
	/*
	 	Basic function used for overriding in child classes
	 	@Return string
	 */
	public String toString();
	PrgState execute(PrgState state) throws MException, FileNotFoundException;
}
