package TesteObjetos;

import java.math.BigDecimal;

public class TesteASCII {
	public static void main(String[] args) {


		String x = "H,C,G,A,I,O,E,Y,X,N,M,R,W,F";

		String[] date;
		String temp;
		boolean trade = true;

		date = x.split(",");

		while(trade) {

			int teste = 0;

			for(int k = 0; k < date.length; k++) {

				if((k+1 < date.length) && (date[k].compareTo(date[k+1]) > 0)) {

					temp = date[k];
					date[k] = date[k+1];
					date[k+1] = temp;

					teste++;
				}
			}


			if(teste == 0) {

				trade = false;
			}

		}


		for(int i = 0; i < date.length; i++) {

			System.out.println(date[i].toString());

		}



	}

}







