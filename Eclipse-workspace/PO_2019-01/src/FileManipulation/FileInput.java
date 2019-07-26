package FileManipulation;

import Element.*;

import java.io.*;

import java.util.*;

public class FileInput {

	private Scanner input;

	public FileInput(String fileDirectory) throws FileNotFoundException {

		try {

			this.input = new Scanner(new File(fileDirectory));

		} catch (FileNotFoundException e) {

			throw new FileNotFoundException("ERROR: " + e.getMessage().toUpperCase());
		}
	}

	public Jobs splitDateJobs(String line) throws
	NoSuchElementException {

		String[] date;
		String strJobs, strOffice, cargo, empresa, uf;

		try {

			date = line.split(";");

			strJobs = date[0].trim() + date[2].trim() + date[1].trim();
			
			strOffice = date[0].trim() + date[2].trim();

			cargo = date[0].trim();
			
			empresa = date[1].trim();
			
			uf = date[2].trim();

			return (new Jobs(strJobs, strOffice, cargo, empresa, uf));

		} catch (NoSuchElementException e) {

			throw new NoSuchElementException("ERROR: " + e.getMessage().toUpperCase());
		}
	}

	public Office splitDateOffice(String line) throws
	NoSuchElementException {

		String[] date;
		String strOffice, cargo, uf;

		try {

			date = line.split(";");

			strOffice = date[0].trim() + date[1].trim();

			cargo = date[0].trim();
			
			uf = date[1].trim();

			return (new Office(strOffice, cargo, uf));

		} catch (NoSuchElementException e) {

			throw new NoSuchElementException("ERROR: " + e.getMessage().toUpperCase());
		}
	}

	public InsertJobs openFileJobs(int size) throws NoSuchElementException,
	ArrayIndexOutOfBoundsException {

		InsertJobs insert = new InsertJobs(size);
		
		String line;

		try {

			while (this.input.hasNext()) {

				line = this.input.nextLine();

				Jobs register = splitDateJobs(line);

				insert.executeInsertJobs(register);

			}
			return insert;

		} catch (ArrayIndexOutOfBoundsException e) {

			throw new ArrayIndexOutOfBoundsException("ERROR: " + e.getMessage().toUpperCase());
		}
	}
	
	public InsertOffice openFileOffice(int size) throws NoSuchElementException,
	ArrayIndexOutOfBoundsException {

		InsertOffice insert = new InsertOffice(size);
		String line;

		try {

			while (this.input.hasNext()) {

				line = this.input.nextLine();

				Office register = splitDateOffice(line);

				insert.executeInsertOffice(register);

			}
			return insert;

		} catch (ArrayIndexOutOfBoundsException e) {

			throw new ArrayIndexOutOfBoundsException("ERROR: " + e.getMessage().toUpperCase());
		}
	}

	public void closeFile() throws IllegalStateException {

		try {
			this.input.close();

		} catch (IllegalStateException e) {

			throw new IllegalStateException("ERROR: " + e.getMessage().toUpperCase());
		}
	}

}
