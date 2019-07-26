package Element;

import Element.Jobs;

public class InsertJobs {

	Jobs jobs[];
	int index = 0;

	public InsertJobs() {
	}

	public InsertJobs(Jobs[] jobs) {

		this.jobs = jobs;
	}

	public InsertJobs(int size) {

		this.jobs = new Jobs[size];
	}

	public Jobs[] getSelectJobs() {

		return this.jobs;
	}

	public void executeInsertJobs(Jobs jobs) {

		this.jobs[index] = jobs;
		index++;
	}
	
	public Jobs getJobIndex(int index) {
        return this.jobs[index];
     }

	@Override
	public String toString() {

		String x = "";

		for(int i = 0; i < jobs.length; i++) {

			x += jobs[i].getStrJobs() + ";" + jobs[i].getCargo() + ";" + jobs[i].getEmpresa() + ";" + jobs[i].getUF()+"\n";
		}
		return x;
	}

}
