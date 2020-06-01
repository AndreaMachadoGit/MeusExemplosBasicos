package br.com.codenation;

import br.com.codenation.DesafioMeuTimeApplication;
//import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

import java.math.BigDecimal;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        DesafioMeuTimeApplication app = new DesafioMeuTimeApplication();

        app.incluirTime(1L, "Internacional", LocalDate.now(), "vermelho", "branco");
        app.incluirJogador(3L, 1L, "Dalessandro", LocalDate.now(), 99, new BigDecimal(150000));
        app.incluirJogador(2L, 1L, "Guerreiro", LocalDate.now(), 89, new BigDecimal(160000));
        app.incluirJogador(4L, 1L, "Marcelo Lomba", LocalDate.now(), 67, new BigDecimal(200000));

        app.incluirTime(2L, "Gremio", LocalDate.now(), "azul", "preto");
        app.incluirJogador(1L, 2L, "Cebolinha", LocalDate.now(), 75, new BigDecimal(800000));

        app.definirCapitao(3L);
        app.definirCapitao(1L);

        //System.out.println("Capitão do " + app.buscarNomeTime(1L) + " = " + app.buscarCapitaoDoTime(1L));
        //System.out.println("Jogadores do " + app.buscarNomeTime(1L) + " = " + app.buscarJogadoresDoTime(1L));
        //System.out.println("Melhor jogador do " + app.buscarNomeTime(1L) + " = " + app.buscarMelhorJogadorDoTime(1L));
        //System.out.println("Times Cadastrados: " + app.buscarTimes());
        //System.out.println("O maior salário do " + app.buscarNomeTime(1L) + " é " + app.buscarJogadorMaiorSalario(1L));
        //System.out.println("Salário do jogador: " + app.buscarNomeJogador(3L) + " é R$ " + app.buscarSalarioDoJogador(3L));
        //System.out.println("Lista de melhores jogadores = " + app.buscarTopJogadores(4));
        //System.out.println("Cor camisa time de fora que é o : " + app.buscarNomeTime(2L) + " , "  + app.buscarCorCamisaTimeDeFora(1L,2L));

    }
}
