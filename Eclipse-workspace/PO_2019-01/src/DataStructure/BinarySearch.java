package DataStructure;

import Element.Jobs;

public class BinarySearch  {

	public static String Execute(String key, Jobs[] vetorJobs) {

		int size = vetorJobs.length;

		String str = "";

		int mid;
		int left = 0;
		int right = size -1;

		while (left <= right) {

			mid = (left + right) / 2;

			if (vetorJobs[mid].getStrOffice().compareToIgnoreCase(key) < 0) {

				left = mid + 1;

			} else if (vetorJobs[mid].getStrOffice().compareToIgnoreCase(key) > 0) {

				right = mid - 1;

			} else {

				vetorJobs[mid].setStrOffice("");

				str += vetorJobs[mid].getEmpresa() + ", ";

				left = 0;
				right = size -1;
			}
		}
		return str;

	}

}
