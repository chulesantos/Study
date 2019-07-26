package Element;

import Element.Office;

public class InsertOffice {

	Office office[];
	int i = 0;

	public InsertOffice() {
	}

	public InsertOffice(Office[] office) {

		this.office = office;
	}

	public InsertOffice(int size) {

		this.office = new Office[size];
	}

	public Office[] getSelectOffice() {

		return this.office;
	}

	public void executeInsertOffice(Office office) {

		this.office[i] = office;
		i++;
	}

	@Override
	public String toString() {

		String x = "";

		for(int i = 0; i < office.length; i++) {

			x += office[i].getStrOffice() + ";" + office[i].getCargo() + ";" + office[i].getUF() +"\n";
		}
		return x;
	}

}
