package Repository;
import java.io.FileNotFoundException;
import java.io.IOException;

import Model.PrgState;

/*
 * Interface used for repository
 */
public interface IRepo {
	//current state of the repository
	PrgState getCurrentState() throws RepoException;
	
	//writes log of execution to log file
	void logPrgStateExec() throws FileNotFoundException, IOException;
}
