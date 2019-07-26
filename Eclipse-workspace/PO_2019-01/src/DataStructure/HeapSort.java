package DataStructure;

import Element.Jobs;

public class HeapSort {

	int size;

	Jobs[] vetor;

	public HeapSort(Jobs[] vetor) {

		this.vetor = vetor;
		this.size = vetor.length;
	}

	public void heapSort() {

		int right = size - 1;
		int left = (right - 1) / 2;
		Jobs temp;

		while (left >= 0) {

			remakeHeap(left, this.size - 1);
			left--;
		}

		while (right > 0) {

			temp = this.vetor[0];
			this.vetor[0] = this.vetor[right];
			this.vetor[right] = temp;
			right--;

			remakeHeap(0, right);
		}
	}

	public void remakeHeap(int left, int right) {

		int i = left;
		int maxSun = 2 * i + 1;
		Jobs root = this.vetor[i];
		boolean heap = false;

		while ((maxSun <= right) && (!heap)) {

			if (maxSun < right) {

				if (this.vetor[maxSun].getStrJobs().compareToIgnoreCase(this.vetor[maxSun + 1].getStrJobs()) < 0) {

					maxSun++;
				}
			}

			if (root.getStrJobs().compareToIgnoreCase(this.vetor[maxSun].getStrJobs()) < 0) {

				this.vetor[i] = this.vetor[maxSun];
				i = maxSun;
				maxSun = 2 * i + 1;

			} else {

				heap = true;
			}
		}

		this.vetor[i] = root;
	}

	public Jobs[] getHeapSort() {

		return vetor;
	}

}