package challenge;

import static java.lang.Integer.parseInt;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        //Decifrar o texto de acordo com 3 casas

        if (texto.equals(null) || texto.isEmpty())  {
            throw new IllegalArgumentException();
        }

        int posicaoNaStringDeLetras = 0;
        int novaPosicaoNaString = 0;
        int tamanhoDoTexto = texto.length();
        char letraAtual;
        String textoDecifrado = "";
        final int NUMERO_CASAS = 3;
        final String letrasAlfabeto = "abcdefghijklmnopqrstuvwxyz";
        final String valoresMantidos = "1234567890., ";

        texto = texto.toLowerCase();

        for (int i = 0; i < tamanhoDoTexto; i++) {

            letraAtual = texto.charAt(i);

            if (valoresMantidos.indexOf(letraAtual) != -1){
                //para manter números, pontos e espaços
                textoDecifrado = textoDecifrado + letraAtual;
            } else {
                //posicaoNaStringDeLetras = letrasAlfabeto.indexOf(texto[i]); //letraAtual
                posicaoNaStringDeLetras = letrasAlfabeto.indexOf(letraAtual); //letraAtual
                novaPosicaoNaString =  posicaoNaStringDeLetras + NUMERO_CASAS;
                if (novaPosicaoNaString < 0) {
                    novaPosicaoNaString +=26;
                }

                textoDecifrado +=  letrasAlfabeto.charAt(novaPosicaoNaString);
            }
        }

        return textoDecifrado;

        //throw new UnsupportedOperationException("esse method nao esta implementado aainda");

    }

    @Override
    public String descriptografar(String texto) {
        //Decifrar o texto de acordo com 3 casas

        if (texto.equals(null) || texto.isEmpty())  {
            throw new IllegalArgumentException();
        }
        int posicaoNaStringDeLetras = 0;
        int novaPosicaoNaString = 0;
        int tamanhoDoTexto = texto.length();
        final int NUMERO_CASAS = 3;
        final String valoresMantidos = "1234567890., ";
        final String letrasAlfabeto = "abcdefghijklmnopqrstuvwxyz";
        String textoDecifrado = "";
        char letraAtual;
        texto = texto.toLowerCase();

        for (int i = 0; i < tamanhoDoTexto; i++) {

            letraAtual = texto.charAt(i);

            if (valoresMantidos.indexOf(letraAtual) != -1){
                //para manter números, pontos e espaços
                textoDecifrado = textoDecifrado + letraAtual;
            } else {
                //posicaoNaStringDeLetras = letrasAlfabeto.indexOf(texto[i]); //letraAtual
                posicaoNaStringDeLetras = letrasAlfabeto.indexOf(letraAtual); //letraAtual
                novaPosicaoNaString =  posicaoNaStringDeLetras - NUMERO_CASAS;
                if (novaPosicaoNaString < 0) {
                    novaPosicaoNaString +=26;
                }

                textoDecifrado +=  letrasAlfabeto.charAt(novaPosicaoNaString);
            }
        }

        return textoDecifrado;
        //trow new UnsupportedOperationException("esse method nao esta implementado aainda");

    }
}
