package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class OpenRFileStmt implements Statement {

	private static int fileDescriptor;
	private String id,fileName;
	
	public OpenRFileStmt(String id, String fileName)
	{
		this.id=id;
		this.fileName=fileName;
	}
	
	//
	@Override
	public PrgState execute(PrgState state) throws MException, FileNotFoundException {
		// TODO Auto-generated method stub
		for(Tuple<String,BufferedReader> actual: state.getFileTable().values())
			if(actual.getFirst()==this.fileName)
			{
				throw new FileNotFoundException("Exception at : " +this.toString() + "\n file : " + this.fileName + " is already open ");
			}
		
		File f=new File(this.fileName);
		
		if(!f.exists())
			throw new FileNotFoundException("\n file : " + this.fileName + " does not exists ");
		
		int actFileDescriptor = OpenRFileStmt.fileDescriptor;
		state.getFileTable().put(actFileDescriptor, new Tuple<String,BufferedReader>(this.fileName,new BufferedReader(new FileReader(this.fileName))));
		state.getSymTable().put(this.id,actFileDescriptor);
		
		return state;
		
	}
	
	@Override
	public String toString()
	{
		return "OpenRFile ("+this.id +this.fileName +")";
	}

}
