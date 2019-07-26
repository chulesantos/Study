package Engine;

import java.io.IOException;
import java.util.NoSuchElementException;
import DataStructure.*;
import Element.*;

public class Gear {

	static String folderInput = "Input\\Jobs\\";
	static String folderOuput = "Output\\Jobs\\";
	static String nameFile = "emprego";

	public static long ExecuteHeapSortBinarySearch(int size, String typeFile) throws ArrayIndexOutOfBoundsException, NoSuchElementException, IOException {

		long time = 0;

		for(int i = 0; i < 5; i++) {

			long timeBegin = System.currentTimeMillis();

			InsertJobs arrayJobs = Mechanism.FileDirectoryInput(folderInput+nameFile+size+typeFile).openFileJobs(size);

			HeapSort heapSort = new HeapSort(arrayJobs.getSelectJobs());

			heapSort.heapSort();

			Jobs[] vetorJobs = heapSort.getHeapSort();

			Mechanism.FileDirectoryOutput(folderOuput+"HeapSort-"+size+typeFile).saveInFile(Mechanism.showJobs(vetorJobs));

			InsertOffice arrayOffice = Mechanism.FileDirectoryInput(folderInput+nameFile).openFileOffice(400);

			Office[] vetorOffice = arrayOffice.getSelectOffice();

			InsertJobs arrayJobsHeap = Mechanism.FileDirectoryInput(folderOuput+"HeapSort-"+size+typeFile).openFileJobs(size);

			Jobs[] vetorJobsHeap = arrayJobsHeap.getSelectJobs();

			Mechanism.FileDirectoryOutput(folderOuput+"JobOffer-HeapSort-BinarySearch-"+size).saveInFile(Mechanism.JobsOfferBinarySearch(vetorOffice, vetorJobsHeap));

			long timeEnd = System.currentTimeMillis();

			time += (timeEnd - timeBegin);

		}
		return (time / 5);
	}

	public static long ExecuteQuickSortBinarySearch(int size, String typeFile) throws ArrayIndexOutOfBoundsException, NoSuchElementException, IOException {

		long time = 0;

		for(int i = 0; i < 5; i++) {

			long timeBegin = System.currentTimeMillis();

			InsertJobs arrayJobs = Mechanism.FileDirectoryInput(folderInput+nameFile+size+typeFile).openFileJobs(size);

			QuickSort quickSort = new QuickSort(arrayJobs.getSelectJobs());

			quickSort.quicksort(); 

			Jobs[] vetorJobs = quickSort.getQuickSort();

			Mechanism.FileDirectoryOutput(folderOuput+"QuickSort-"+size+typeFile).saveInFile(Mechanism.showJobs(vetorJobs));

			InsertOffice arrayOffice = Mechanism.FileDirectoryInput(folderInput+nameFile).openFileOffice(400);

			Office[] vetorOffice = arrayOffice.getSelectOffice();

			InsertJobs arrayJobsQuick = Mechanism.FileDirectoryInput(folderOuput+"QuickSort-"+size+typeFile).openFileJobs(size);

			Jobs[] vetorJobsQuick = arrayJobsQuick.getSelectJobs();

			Mechanism.FileDirectoryOutput(folderOuput+"JobOffer-QuickSort-BinarySearch-"+size).saveInFile(Mechanism.JobsOfferBinarySearch(vetorOffice, vetorJobsQuick));

			long timeEnd = System.currentTimeMillis();

			time += (timeEnd - timeBegin);
		}
		return (time / 5);
	}

	public static long ExecuteAVLTree(int size, String typeFile) throws ArrayIndexOutOfBoundsException, NoSuchElementException, IOException {

		long time = 0;

		for(int i = 0; i < 5; i++) {

			long timeBegin = System.currentTimeMillis();

			InsertJobs arrayJobs = Mechanism.FileDirectoryInput(folderInput+nameFile+size+typeFile).openFileJobs(size);

			AVLTree AVLTree= new AVLTree();

			for (int j = 0; j < arrayJobs.getSelectJobs().length; j++) {

				AVLTree.InsertRoot(arrayJobs.getJobIndex(j));
			}     

			InsertOffice arrayOffice = Mechanism.FileDirectoryInput(folderInput+nameFile).openFileOffice(400);

			Office[] vetorOffice = arrayOffice.getSelectOffice();

			Mechanism.FileDirectoryOutput(folderOuput+"JobOffer-AVLTree-"+size).saveInFile(Mechanism.JobsOfferAVLTree(vetorOffice, AVLTree));

			long timeEnd = System.currentTimeMillis();

			time += (timeEnd - timeBegin);
		}
		return (time / 5);
	}

	public static long ExecuteBinaryTree(int size, String typeFile) throws ArrayIndexOutOfBoundsException, NoSuchElementException, IOException {

		long time = 0;

		for(int i = 0; i < 5; i++) {

			long timeBegin = System.currentTimeMillis();

			InsertJobs arrayJobs = Mechanism.FileDirectoryInput(folderInput+nameFile+size+typeFile).openFileJobs(size);

			BinarySearchTree TreeBinary = new BinarySearchTree();

			OrderVector vectorOrdered = new OrderVector(size);

			for (int j = 0; j < arrayJobs.getSelectJobs().length; j++) {

				vectorOrdered.Insert((arrayJobs.getJobIndex(j)));

				TreeBinary.Insert(arrayJobs.getJobIndex(j));
			}

			TreeBinary = TreeBinary.TreeBalanced(vectorOrdered);

			InsertOffice arrayOffice = Mechanism.FileDirectoryInput(folderInput+nameFile).openFileOffice(400);

			Office[] vetorOffice = arrayOffice.getSelectOffice();

			Mechanism.FileDirectoryOutput(folderOuput+"JobOffer-BinaryTree-"+size).saveInFile(Mechanism.JobsOfferBinarySearchTree(vetorOffice, TreeBinary));

			long timeEnd = System.currentTimeMillis();

			time += (timeEnd - timeBegin);
		}
		return (time / 5);
	}
	
	public static long ExecuteHashing(int size, String typeFile) throws ArrayIndexOutOfBoundsException, NoSuchElementException, IOException {

		long time = 0;

		for(int i = 0; i < 5; i++) {

			long timeBegin = System.currentTimeMillis();

			InsertJobs arrayJobs = Mechanism.FileDirectoryInput(folderInput+nameFile+size+typeFile).openFileJobs(size);

			Hashing Hash = new Hashing(size);

			for (int j = 0; j < arrayJobs.getSelectJobs().length; j++) {

				Hash.Insert(arrayJobs.getJobIndex(j));

			}

			InsertOffice arrayOffice = Mechanism.FileDirectoryInput(folderInput+nameFile).openFileOffice(400);

			Office[] vetorOffice = arrayOffice.getSelectOffice();

			Mechanism.FileDirectoryOutput(folderOuput+"JobOffer-Hashing-"+size).saveInFile(Mechanism.JobsOfferHashing(vetorOffice, Hash));

			long timeEnd = System.currentTimeMillis();

			time += (timeEnd - timeBegin);
		}
		return (time / 5);
	}
}



