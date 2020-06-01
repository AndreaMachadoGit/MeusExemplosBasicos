package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements) {
		if (elements.length > 0) {
			int somaElementos = 0;
			for (int numero: elements ) {
				somaElementos +=numero;
			}
			return (somaElementos / elements.length);
		} else {
			return 0;
		}
	}

	public static int mode(int[] elements) {
		int valorModa = 0;

		if (elements.length > 0) {
			int[] numerosDeRepeticoes = new int[elements.length];
			int cont;
			for (int i = 0; i < elements.length ; i++) {
				cont = 0;
				for (int j = 0; j < elements.length; j++) {
					if (elements[j] == elements[i]) {
						cont++;
						numerosDeRepeticoes[i] = cont;
					}
				}
			}

			// Pega o maior número dos elementos repetidos
			int maiorNumeroRepeticoes = 0;
			for (int i = 0; i < elements.length; i++) {
				if (numerosDeRepeticoes[i] > maiorNumeroRepeticoes) {
					maiorNumeroRepeticoes = numerosDeRepeticoes[i];
					valorModa = elements[i];
				}
			}
		}
		return valorModa;
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);
		int mediana = 0;
		if ((elements.length % 2) ==0){ // Array par - soma os dois elementos do meio e divide por dois
			mediana = (((elements[((int)(elements.length/2))]) + (elements[((int)(elements.length/2))-1]))/ 2);
		} else { // Array ímpar - pega o elemento do meio
			mediana =  (elements[((int)(elements.length/2))]);
		}
		return mediana;
	}
}