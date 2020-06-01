package br.com.codenation.calculadora;


public class CalculadoraSalario {

	//public static void main(String[] args) {
	//	int valorSalarioLiquido = (int) calcularSalarioLiquido(5000);
	//	System.out.println("Valor salario liquido para 5000 : " + valorSalarioLiquido);
	//}
	public  long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		if (salarioBase <= 1039) {
			return (0);
		}
		double descontoINSS = calcularInss(salarioBase);
		double descontoIRRF = calcularIrrf(salarioBase - descontoINSS);
		double salarioLiquido = (salarioBase - (descontoINSS + descontoIRRF));

		return Math.round(salarioLiquido);
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private  double calcularInss(double salarioBase) {
		//Faixa salarial	Percentual de desconto
		//Até R$ 1.500,00	8%
		//De R$ 1.500,01 até R$ 4.000,00	9%
		//Acima de R$ 4.000,00	11%
		double valorINSS = 0.0;
		int aliquota= 0 ;

		if (salarioBase <= 1500.00) {
			aliquota = 8;
		} else if (salarioBase > 1500.00 && salarioBase <= 4000.00) {
			aliquota = 9;
		} else if (salarioBase > 4000.00){
			aliquota = 11;
		}
		valorINSS =  ((salarioBase * aliquota) /100);
		return valorINSS;

	}

	private  double calcularIrrf(double salarioBaseComDescontoINSS) {
		//Faixa salarial	Percentual de desconto
		//Até R$ 3.000,00	ISENTO
		//De R$ 3.000,01 até R$ 6.000,00	7.5%
		//Acima de R$ 6.000,00	15%

		double valorIRRF = 0.0;
		double aliquota= 0.0 ;

		if (salarioBaseComDescontoINSS >= 3000.00 && salarioBaseComDescontoINSS <= 6000.00) {
			aliquota = 7.5;
		} else if (salarioBaseComDescontoINSS > 6000.00) {
			aliquota = 15;
		}
		valorIRRF =  ((salarioBaseComDescontoINSS * aliquota) /100);
		return valorIRRF;

	}
}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/