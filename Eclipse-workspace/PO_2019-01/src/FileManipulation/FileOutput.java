package FileManipulation;

import java.io.*;

public class FileOutput {

	private FileWriter writer;

	private PrintWriter output;

	public FileOutput (String nome) throws IOException {

		try{

			writer = new FileWriter(new File(nome), false);

			output = new PrintWriter (writer);
		}
		catch (IOException e){

			throw new IOException ("ERROR: " + e.getMessage().toUpperCase());
		}
	}

	public void saveInFile (String str) {
		
		this.output.print(str);
		this.output.close();
	}

	public void closeFile ()throws IOException {

		try{

			this.writer.close();
			this.output.close();

		}
		catch (IOException e){

			throw new IOException ("ERROR: " + e.getMessage().toUpperCase());
		}
	}
}
