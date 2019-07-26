package Element;

public class Office {

	private String strOffice, cargo, uf; 

	public Office(String strOffice, String cargo, String uf) {

		this.setStrOffice(strOffice);
		this.setCargo(cargo);
		this.setUF(uf);
	}

	public Office() {
	}

	public String getStrOffice() {
		
		return strOffice;
	}

	public void setStrOffice(String strOffice) {
		
		this.strOffice = strOffice;
	}

	public String getCargo() {
		
		return cargo;
	}

	public void setCargo(String cargo) {
		
		this.cargo = cargo;
	}

	public String getUF() {
		
		return uf;
	}

	public void setUF(String uf) {
		
		this.uf = uf;
	}	

	@Override
	public String toString() {
		
		return cargo + ";" + uf;

	}
}