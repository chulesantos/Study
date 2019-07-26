package Engine;

import java.io.IOException;
import java.util.NoSuchElementException;

public class Main {

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException, NoSuchElementException, IOException {
		
		String time = "milissegundos";

		/* HEAPSORT + PESQUISA BINARIA */

	/*	System.out.print("HEAPSORT + PESQUISA BINARIA\n\n");
		
		System.out.println("500 Aleatorio => " + Gear.ExecuteHeapSortBinarySearch(500, "alea") + " " + time +"\n");

		System.out.println("500 Invertido => " + Gear.ExecuteHeapSortBinarySearch(500, "inv") + " " + time +"\n");

		System.out.println("500 Ordenado => " + Gear.ExecuteHeapSortBinarySearch(500, "ord") + " " + time +"\n\n");


		System.out.println("1000 Aleatorio => " + Gear.ExecuteHeapSortBinarySearch(1000, "alea") + " " + time +"\n");

		System.out.println("1000 Invertido => " + Gear.ExecuteHeapSortBinarySearch(1000, "inv") + " " + time +"\n");

		System.out.println("1000 Ordenado => " + Gear.ExecuteHeapSortBinarySearch(1000, "ord") + " " + time +"\n\n");


		System.out.println("5000 Aleatorio => " + Gear.ExecuteHeapSortBinarySearch(5000, "alea") + " " + time +"\n");

		System.out.println("5000 Invertido => " + Gear.ExecuteHeapSortBinarySearch(5000, "inv") + " " + time +"\n");

		System.out.println("5000 Ordenado => " + Gear.ExecuteHeapSortBinarySearch(5000, "ord") + " " + time +"\n\n");


		System.out.println("10000 Aleatorio => " + Gear.ExecuteHeapSortBinarySearch(10000, "alea") + " " + time +"\n");

		System.out.println("10000 Invertido => " + Gear.ExecuteHeapSortBinarySearch(10000, "inv") + " " + time +"\n");

		System.out.println("10000 Ordenado => " + Gear.ExecuteHeapSortBinarySearch(10000, "ord") + " " + time +"\n\n"); */


	//	System.out.println("50000 Aleatorio => " + Gear.ExecuteHeapSortBinarySearch(50000, "alea") + " " + time +"\n");

	//	System.out.println("50000 Invertido => " + Gear.ExecuteHeapSortBinarySearch(50000, "inv") + " " + time +"\n");

	//	System.out.println("50000 Ordenado => " + Gear.ExecuteHeapSortBinarySearch(50000, "ord") + " " + time +"\n\n"); 


		/* QUICKSORT + PESQUISA BINARIA */
		
	/*	System.out.print("QUICKSORT + PESQUISA BINARIA\n\n");

		System.out.println("500 Aleatorio => " + Gear.ExecuteQuickSortBinarySearch(500, "alea") + " " + time +"\n");

		System.out.println("500 Invertido => " + Gear.ExecuteQuickSortBinarySearch(500, "inv") + " " + time +"\n");

		System.out.println("500 Ordenado => " + Gear.ExecuteQuickSortBinarySearch(500, "ord") + " " + time +"\n\n");


		System.out.println("1000 Aleatorio => " + Gear.ExecuteQuickSortBinarySearch(1000, "alea") + " " + time +"\n");

		System.out.println("1000 Invertido => " + Gear.ExecuteQuickSortBinarySearch(1000, "inv") + " " + time +"\n");

		System.out.println("1000 Ordenado => " + Gear.ExecuteQuickSortBinarySearch(1000, "ord") + " " + time +"\n\n");


		System.out.println("5000 Aleatorio => " + Gear.ExecuteQuickSortBinarySearch(5000, "alea") + " " + time +"\n");

		System.out.println("5000 Invertido => " + Gear.ExecuteQuickSortBinarySearch(5000, "inv") + " " + time +"\n");

		System.out.println("5000 Ordenado => " + Gear.ExecuteQuickSortBinarySearch(5000, "ord") + " " + time +"\n\n");


		System.out.println("10000 Aleatorio => " + Gear.ExecuteQuickSortBinarySearch(10000, "alea") + " " + time +"\n");

		System.out.println("10000 Invertido => " + Gear.ExecuteQuickSortBinarySearch(10000, "inv") + " " + time +"\n");

		System.out.println("10000 Ordenado => " + Gear.ExecuteQuickSortBinarySearch(10000, "ord") + " " + time +"\n\n"); */


	//	System.out.println("50000 Aleatorio => " + Gear.ExecuteQuickSortBinarySearch(50000, "alea") + " " + time +"\n");

	//	System.out.println("50000 Invertido => " + Gear.ExecuteQuickSortBinarySearch(50000, "inv") + " " + time +"\n");

	//	System.out.println("50000 Ordenado => " + Gear.ExecuteQuickSortBinarySearch(50000, "ord") + " " + time +"\n\n"); 



		/* ARVORE BINARIA DE BUSCA */
		
	/*	System.out.print("ARVORE BINARIA DE BUSCA\n\n");

		System.out.println("500 Aleatorio => " + Gear.ExecuteBinaryTree(500, "alea") + " " + time +"\n");

		System.out.println("500 Invertido => " + Gear.ExecuteBinaryTree(500, "inv") + " " + time +"\n");

		System.out.println("500 Ordenado => " + Gear.ExecuteBinaryTree(500, "ord") + " " + time +"\n\n");


		System.out.println("1000 Aleatorio => " + Gear.ExecuteBinaryTree(1000, "alea") + " " + time +"\n");

		System.out.println("1000 Invertido => " + Gear.ExecuteBinaryTree(1000, "inv") + " " + time +"\n");

		System.out.println("1000 Ordenado => " + Gear.ExecuteBinaryTree(1000, "ord") + " " + time +"\n\n");


		System.out.println("5000 Aleatorio => " + Gear.ExecuteBinaryTree(5000, "alea") + " " + time +"\n");

		System.out.println("5000 Invertido => " + Gear.ExecuteBinaryTree(5000, "inv") + " " + time +"\n");

		System.out.println("5000 Ordenado => " + Gear.ExecuteBinaryTree(5000, "ord") + " " + time +"\n\n");


		System.out.println("10000 Aleatorio => " + Gear.ExecuteBinaryTree(10000, "alea") + " " + time +"\n");

		System.out.println("10000 Invertido => " + Gear.ExecuteBinaryTree(10000, "inv") + " " + time +"\n");

		System.out.println("10000 Ordenado => " + Gear.ExecuteBinaryTree(10000, "ord") + " " + time +"\n\n"); */


	//	System.out.println("50000 Aleatorio => " + Gear.ExecuteBinaryTree(50000, "alea") + " " + time +"\n"); 

	//	System.out.println("50000 Invertido => " + Gear.ExecuteBinaryTree(50000, "inv") + " " + time +"\n");

	//	System.out.println("50000 Ordenado => " + Gear.ExecuteBinaryTree(50000, "ord") + " " + time +"\n\n"); 



		/* ARVORE AVL */

	/*	System.out.print("ARVORE AVL\n\n");

		System.out.println("500 Aleatorio => " + Gear.ExecuteAVLTree(500, "alea") + " " + time +"\n");

		System.out.println("500 Invertido => " + Gear.ExecuteAVLTree(500, "inv") + " " + time +"\n");

		System.out.println("500 Ordenado => " + Gear.ExecuteAVLTree(500, "ord") + " " + time +"\n\n");


		System.out.println("1000 Aleatorio => " + Gear.ExecuteAVLTree(1000, "alea") + " " + time +"\n");

		System.out.println("1000 Invertido => " + Gear.ExecuteAVLTree(1000, "inv") + " " + time +"\n");

		System.out.println("1000 Ordenado => " + Gear.ExecuteAVLTree(1000, "ord") + " " + time +"\n\n");


		System.out.println("5000 Aleatorio => " + Gear.ExecuteAVLTree(5000, "alea") + " " + time +"\n");

		System.out.println("5000 Invertido => " + Gear.ExecuteAVLTree(5000, "inv") + " " + time +"\n");

		System.out.println("5000 Ordenado => " + Gear.ExecuteAVLTree(5000, "ord") + " " + time +"\n\n");


		System.out.println("10000 Aleatorio => " + Gear.ExecuteAVLTree(10000, "alea") + " " + time +"\n");

		System.out.println("10000 Invertido => " + Gear.ExecuteAVLTree(10000, "inv") + " " + time +"\n");

		System.out.println("10000 Ordenado => " + Gear.ExecuteAVLTree(10000, "ord") + " " + time +"\n\n"); */


	//	System.out.println("50000 Aleatorio => " + Gear.ExecuteAVLTree(50000, "alea") + " " + time +"\n");

	//	System.out.println("50000 Invertido => " + Gear.ExecuteAVLTree(50000, "inv") + " " + time +"\n");

	//	System.out.println("50000 Ordenado => " + Gear.ExecuteAVLTree(50000, "ord") + " " + time +"\n\n"); 



		/* HASHING */

	/*	System.out.print("HASHING\n\n");

		System.out.println("500 Aleatorio => " + Gear.ExecuteHashing(500, "alea") + " " + time +"\n");

		System.out.println("500 Invertido => " + Gear.ExecuteHashing(500, "inv") + " " + time +"\n");

		System.out.println("500 Ordenado => " + Gear.ExecuteHashing(500, "ord") + " " + time +"\n\n");


		System.out.println("1000 Aleatorio => " + Gear.ExecuteHashing(1000, "alea") + " " + time +"\n");

		System.out.println("1000 Invertido => " + Gear.ExecuteHashing(1000, "inv") + " " + time +"\n");

		System.out.println("1000 Ordenado => " + Gear.ExecuteHashing(1000, "ord") + " " + time +"\n\n");


		System.out.println("5000 Aleatorio => " + Gear.ExecuteHashing(5000, "alea") + " " + time +"\n");

		System.out.println("5000 Invertido => " + Gear.ExecuteHashing(5000, "inv") + " " + time +"\n");

		System.out.println("5000 Ordenado => " + Gear.ExecuteHashing(5000, "ord") + " " + time +"\n\n"); */


		System.out.println("10000 Aleatorio => " + Gear.ExecuteHashing(10000, "alea") + " " + time +"\n");

		System.out.println("10000 Invertido => " + Gear.ExecuteHashing(10000, "inv") + " " + time +"\n");

		System.out.println("10000 Ordenado => " + Gear.ExecuteHashing(10000, "ord") + " " + time +"\n\n"); 


	//	System.out.println("50000 Aleatorio => " + Gear.ExecuteHashing(50000, "alea") + " " + time +"\n");

	//	System.out.println("50000 Invertido => " + Gear.ExecuteHashing(50000, "inv") + " " + time +"\n");

	//	System.out.println("50000 Ordenado => " + Gear.ExecuteHashing(50000, "ord") + " " + time +"\n\n"); 




		System.out.printf("\nCompiled Successfully\n");

	}

}
