package Element;

public class Jobs {

	private String strJobs, strOffice, cargo, empresa, uf; 

	public Jobs(String strJobs, String strOffice, String cargo, String empresa, String uf) {

		this.setStrJobs(strJobs);
		this.setStrOffice(strOffice);
		this.setCargo(cargo);
		this.setEmpresa(empresa);
		this.setUF(uf);
	}

	public Jobs() {
	}

	public String getStrJobs() {
		
		return strJobs;
	}

	public void setStrJobs(String strJobs) {
		
		this.strJobs = strJobs;
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

	public String getEmpresa() {
		
		return empresa;
	}

	public void setEmpresa(String empresa) {
		
		this.empresa = empresa;
	}

	public String getUF() {
		
		return uf;
	}

	public void setUF(String uf) {
		
		this.uf = uf;
	}	

	@Override
	public String toString() {
		
		return cargo + ";" + empresa + ";" + uf;
	}
}
