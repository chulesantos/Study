package Engine;

import java.io.FileNotFoundException;
import java.io.IOException;

import DataStructure.AVLTree;
import DataStructure.BinarySearch;
import DataStructure.BinarySearchTree;
import DataStructure.Hashing;
import Element.Jobs;
import Element.Office;
import FileManipulation.FileInput;
import FileManipulation.FileOutput;

public class Mechanism {

	public static String showUF(String uf) {

		String str = "";

		switch(uf) {

		case "AC": str = "Acre"; break;

		case "AL": str = "Alagoas"; break;

		case "AP": str = "Amapá"; break;

		case "AM": str = "Amazonas"; break;

		case "BA": str = "Bahia"; break;

		case "CE": str = "Ceará"; break;

		case "DF": str = "Distrito Federal"; break;

		case "ES": str = "Espírito Santo"; break;

		case "GO": str = "Goiás"; break;

		case "MA": str = "Maranhão"; break;

		case "MT": str = "Mato Grosso"; break;

		case "MS": str = "Mato Grosso do Sul"; break;

		case "MG": str = "Minas Gerais"; break;

		case "PA": str = "Pará"; break;

		case "PB": str = "Paraíba"; break;

		case "PR": str = "Paraná"; break;

		case "PE": str = "Pernambuco"; break;

		case "PI": str = "Piauí"; break;

		case "RJ": str = "Rio de Janeiro"; break;

		case "RN": str = "Rio Grande do Norte"; break;

		case "RS": str = "Rio Grande do Sul"; break;

		case "RO": str = "Rondônia"; break;

		case "RR": str = "Roraima"; break;

		case "SC": str = "Santa Catarina"; break;

		case "SP": str = "São Paulo"; break;

		case "SE": str = "Sergipe"; break;

		case "TO": str = "Tocantins"; break;

		}
		return str;
	}

	public static FileInput FileDirectoryInput(String nameFile) throws FileNotFoundException {

		FileInput fileInput = new FileInput("Files\\"+nameFile+".txt");

		return fileInput;
	}

	public static FileOutput FileDirectoryOutput(String nameFile) throws IOException {

		FileOutput fileOutPut = new FileOutput("Files\\"+nameFile+".txt");

		return fileOutPut;
	}

	public static String showJobs(Jobs[] vetor) {

		String str = "";

		for (int i = 0; i < vetor.length; i++) {

			str += vetor[i].toString() + "\n";
		}
		return str;
	}

	public static String showOffice(Office[] vetor) {

		String str = "";

		for(int i = 0; i < vetor.length; i++) {

			str += vetor[i].toString() + "\n";
		}
		return str;
	}

	public static String JobsOfferBinarySearch(Office[] vetorOffice, Jobs[] vetorJobs) {

		String str = "";

		for(int i = 0; i < vetorOffice.length; i++) {

			String x =  BinarySearch.Execute(vetorOffice[i].getStrOffice(), vetorJobs);

			if(x.isEmpty()) {

				str += "Não existe registro do cargo: " + vetorOffice[i].getCargo() + " no estado do(a) " + showUF(vetorOffice[i].getUF()) + "\n\n";

			} else {

				str += "Cargo: " + vetorOffice[i].getCargo() + " - " + showUF(vetorOffice[i].getUF()) + "\n";

				str += "Empresa(s): " + x.substring(0, x.length() - 2);

				str += "\n\n";
			}
		} 
		return str;
	}

	public static String JobsOfferAVLTree(Office[] vetorOffice, AVLTree AVL) {

		String str = "";

		for(int i = 0; i < vetorOffice.length; i++) {

			String x =  AVL.Search(vetorOffice[i].getStrOffice());

			if(x.isEmpty()) {

				str += "Não existe registro do cargo: " + vetorOffice[i].getCargo() + " no estado do(a) " + showUF(vetorOffice[i].getUF()) + "\n\n";

			} else {

				str += "Cargo: " + vetorOffice[i].getCargo() + " - " + showUF(vetorOffice[i].getUF()) + "\n";

				str += "Empresa(s): " + x.substring(0, x.length() - 2);

				str += "\n\n";
			}
		} 
		return str;
	}

	public static String JobsOfferBinarySearchTree(Office[] vetorOffice, BinarySearchTree BinaryTree) {

		String str = "";

		for(int i = 0; i < vetorOffice.length; i++) {

			String x =  BinaryTree.SearchJobsOffice(vetorOffice[i].getStrOffice());

			if(x.isEmpty()) {

				str += "Não existe registro do cargo: " + vetorOffice[i].getCargo() + " no estado do(a) " + showUF(vetorOffice[i].getUF()) + "\n\n";

			} else {

				str += "Cargo: " + vetorOffice[i].getCargo() + " - " + showUF(vetorOffice[i].getUF()) + "\n";

				str += "Empresa(s): " + x.substring(0, x.length() - 2);

				str += "\n\n";
			}
		} 
		return str;
	}

	public static String JobsOfferHashing(Office[] vetorOffice, Hashing Hash) {

		String str = "";

		for(int i = 0; i < vetorOffice.length; i++) {

			String x = Hash.Search(vetorOffice[i].getStrOffice());

			if(x.isEmpty()) {

				str += "Não existe registro do cargo: " + vetorOffice[i].getCargo() + " no estado do(a) " + showUF(vetorOffice[i].getUF()) + "\n\n";

			} else {

				str += "Cargo: " + vetorOffice[i].getCargo() + " - " + showUF(vetorOffice[i].getUF()) + "\n";

				x.substring(0, x.length() - 2);

				String[] data;
				String temp;
				boolean swap = true;

				data = x.split(",");

				while(swap) {

					int s = 0;

					for(int k = 0; k < data.length; k++) {

						if((k+1 < data.length) && (data[k].compareToIgnoreCase(data[k+1]) > 0)) {

							temp = data[k];
							data[k] = data[k+1];
							data[k+1] = temp;

							s++;
						}
					}

					if(s == 0) {

						swap = false;
					}
				}

				String y = "";

				for(int o = 0; o < data.length; o++) {

					y += data[o].toString().trim() + ", ";	
				}
				
				y.trim();
				

				str += "Empresa(s): " + y.substring(2, x.length());

				str += "\n\n";
			}
		} 
		return str;
	}
	
}
