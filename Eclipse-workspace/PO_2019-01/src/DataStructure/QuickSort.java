package DataStructure;

import Element.Jobs;

public class QuickSort {

	Jobs[] vetor;
	int size;

	public QuickSort() {
	}

	public QuickSort(Jobs[] vetor) {
		
		this.vetor = vetor;
		this.size = vetor.length;
	}

	public void quicksort() {
		
		order(0,this.size-1);
	}

	public Jobs[] getQuickSort() {
		
		return vetor;
	}

	private void order(int left, int right) {

		String pivot;
		int i = left, j = right;

		Jobs temp;

		pivot = this.vetor[(i+j)/2].getStrJobs();

		do {

			while (this.vetor[i].getStrJobs().compareTo(pivot) < 0)
				
				i++;

			while (this.vetor[j].getStrJobs().compareTo(pivot) > 0)
				
				j--;

			if (i <= j) {

				temp = this.vetor[i];
				this.vetor[i] = this.vetor[j];
				this.vetor[j] = temp;
				i++;
				j--;
			}

		} while (i <= j);

		if (left < j)

			order (left, j);

		if (right > i)

			order (i, right);
	}
}