package DataStructure;

import Element.Jobs;

public class OrderVector {

	private Jobs[] vector;
	private int index;

	public OrderVector(int size) {

		vector = new Jobs[size];
		index = 0;
	}

	public Jobs[] getVector() {

		return vector;
	}

	public void setVector(Jobs[] vectorJobs) {

		this.vector = vectorJobs;
	}

	public void Insert(Jobs jobs) {

		vector[index] = jobs;
		index++;
	}

	public int getSize() {
		return this.vector.length;
	}

	public Jobs getJobs(int index) {

		return this.vector[index];
	}

	public String toString() {

		String str = "";

		for (int i = 0; i < vector.length; i++) {

			str = str + vector[i] + "\n";
		}
		return str;
	}
}
