package DataStructure;

import Element.Jobs;

public class Hashing {

	private ThreadedList[] list;
	private int size;

	public Hashing(int x) {

		this.size = NextCousin(x);

		list = new ThreadedList[size];
	}

	/* INSERCAO */
	public void Insert(Jobs jobs) { 

		int x = HashKey(jobs.getStrOffice());

		int pos = x % size; //=> CRIA A POSICAO K MOD M

		ThreadedList newList = new ThreadedList();

		if(list[pos] == null) { //=> SE O VETOR ESTIVER VAZIO, CRIA UMA NOVA LISTA

			newList.InsertFirst(jobs); 
			list[pos] = newList; 

		} else {

			ThreadedListNode newNode = 	new ThreadedListNode(jobs);

			if(list[pos].getFirst().getNext() == null) { //=> SE O PROXIMO DA LISTA FOR NULO, SETPROX COM O NOVO NODE

				list[pos].getFirst().setNext(newNode);

			} else {

				boolean loop = true;

				ThreadedListNode temp1 = list[pos].getFirst().getNext();
				ThreadedListNode temp2 = list[pos].getFirst().getNext();;

				while(loop) { //=> LOOP PARA SEMPRE DAR SETPROX NO PROXIMO NODE NULO

					if(temp1.getNext() == null) { 

						temp1.setNext(newNode);
						loop = false;

					} else {

						temp1 = temp2.getNext();
						temp2 = temp1;
					}
				}

			}

		}

	}

	/* BUSCA NO VETOR DE LISTA ENCADEADA */
	public String Search(String key) {

		String str = "";

		int x = HashKey(key);

		int pos = x % size; //=> CRIA A POSICAO K MOD M (POSICAO DA CHAVE EM STRING)

		if(list[pos] != null) { //=> SE A POSICAO DO VETOR NAO FOR NULO, OU SEJA, EXISTE LISTA, FAZ A BUSCA NA LISTA

			ThreadedListNode content = list[pos].getFirst();

			while (content != null) {

				if(content.getJobs().getStrOffice().compareTo(key) == 0) {

					str += content.getJobs().getEmpresa() + ", ";
				}	

				content = content.getNext();
			}
		}
		return str;
	}

	/* PRIMO MAIS PROXIMO */
	public int NextCousin(int size)	{

		int temp = size;

		while(Cousin(temp) == false) {

			temp++;	
		}
		return temp;	
	}	

	/* VERIFICA SE O NUMERO E PRIMO OU NAO */
	public boolean Cousin(int num) {

		for (int i = 2; i < num; i++) {

			if (num % i == 0)

				return false;   
		}
		return true;
	}

	/* CADA ELEMENTO DA STRING EM UMA SOMA DE INTEIROS */
	public int HashKey(String strJobs) {

		char x;
		int numberKey = 0;

		for(int i = 0; i < strJobs.length(); i++) {

			x = strJobs.charAt(i);
			numberKey += Character.getNumericValue(x);
		}
		return numberKey;
	}

}
