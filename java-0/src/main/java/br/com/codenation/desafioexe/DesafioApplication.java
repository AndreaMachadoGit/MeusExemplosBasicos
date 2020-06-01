package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		List listaRetorno = new ArrayList();
		int numFib=1;
		int numAnt = 0;
		listaRetorno.add(numAnt);
		listaRetorno.add(numFib);

		while (numFib <= 350)
		{
			//listaRetorno.add(numFib);
			//if (numFib==0){
			//	numFib =1;
			//} else {
				numFib = numFib + numAnt;
     			listaRetorno.add(numFib);
				numAnt = numFib - numAnt;
			//}
		}

		return listaRetorno;

	}

	public static Boolean isFibonacci(Integer a) {
		if (fibonacci().contains(a)) {
			return true;
		}

		return false;

 	}

}