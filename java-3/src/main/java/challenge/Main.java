package challenge;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

   private static String arquivoCSV = "data.csv";
   private static String separadorDeCampos = ",";

   private static List<String[]> jogadoresFIFA;
   static {
		try {
			jogadoresFIFA = lerJogadores(arquivoCSV,separadorDeCampos);
		} catch (IOException e) {
			e.printStackTrace();
		}
   }

   private static List<String> cabecalhos = Arrays.asList(jogadoresFIFA.get(0));
   static {
       jogadoresFIFA.remove(0);
   }


   public static void main(String[] args) throws IOException {

        // Pega o arquivo CSV e joga  para a lista jogadoresFIFA
        //jogadoresFIFA = lerJogadores(arquivoCSV,separadorDeCampos);
        // Pega a primeira linha da lista (que contém os nomes das colunas) e joga no array cabecalhos
        //cabecalhos = Arrays.asList(jogadoresFIFA.get(0));
        //Remove a primeira linha da Array de jogadores fifa (o cabeçalho)
        //jogadoresFIFA.remove(0);
        //for (String[] jogador : jogadoresFIFA) {
        //    System.out.println("jogadores lidos : " + jogador[0]);
       // }
        //System.out.println("Numero de jogadores lidos : " + jogadoresFIFA.size());

        //for (int i = 0; i < cabecalhos.size();i++){
         //   System.out.println("cabecalho " + i + " : " + cabecalhos.get(i));
       // }

        //int numeroNacinalidades = q1();
        //int numeroClubes = q2();
        //List<String> listaDos20primeiros = q3();

        //System.out.println("resultado da q1 : " + numeroNacinalidades);
        //System.out.println("resultado da q2 : " + numeroClubes);
        //for (int i = 0; i < listaDos20primeiros.size();i++){
        //   System.out.println("o  " + i + " : " + listaDos20primeiros.get(i));
        //}


    }

    public static List<String[]> lerJogadores(String arquivoCSV, String separadorDeCampos) throws IOException {
		List<String[]> listaJogadores = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(Main.class.getClassLoader().getResource(arquivoCSV).getFile())));
			br.lines().forEach(s -> listaJogadores.add(s.split(separadorDeCampos)));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			}  catch (IOException e) {
				e.printStackTrace();
			}
		}

		//--------------
		//return Files.readAllLines(new File(arquivoCSV).toPath(),StandardCharsets.UTF_8)
        //        .stream()
          //      .map(s -> s.split(separadorDeCampos))
          //      .collect(Collectors.toList());
//        return Files.readAllLines(new File(arquivoCSV).toPath(), StandardCharsets.UTF_8)
		return listaJogadores;
   }

    // Quantas nacionalidades (coluna `nationality`) diferentes existem no arquivo?
	public  int q1() {
        return jogadoresFIFA.stream().collect(Collectors.groupingBy(n ->  n[cabecalhos.indexOf("nationality")])).size();
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public  int q2() {
        return jogadoresFIFA.stream()
                .filter(c -> !c[cabecalhos.indexOf("club")].isEmpty())
                .collect(Collectors.groupingBy(c ->  c[cabecalhos.indexOf("club")])).size();
	}

	// Liste o nome completo (coluna `full_name`) dos 20 primeiros jogadores.
	public static List<String> q3() {
		return jogadoresFIFA.stream()
                .map(c -> c[cabecalhos.indexOf("full_name")])
                .limit(20).collect(Collectors.toList());
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {
        List<String> jogadoresTop10 =  jogadoresFIFA.stream()
                .filter(j -> !j[cabecalhos.indexOf("eur_release_clause")].isEmpty())
                .sorted(Comparator.comparing(j -> Double.parseDouble(j[cabecalhos.indexOf("eur_release_clause")])))
                .map(j -> j[cabecalhos.indexOf("full_name")])
                .collect(Collectors.toList());
        Collections.reverse(jogadoresTop10);
        return jogadoresTop10.stream().limit(10).collect(Collectors.toList());
	}

	// Quem são os 10 jogadores mais velhos (use como critério de desempate o campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() {
		return jogadoresFIFA.stream()
                .filter(c -> !c[cabecalhos.indexOf("birth_date")].isEmpty())
                .sorted(Comparator.comparing(c -> LocalDate.parse(c[cabecalhos.indexOf("birth_date")])))
                .map(c -> c[cabecalhos.indexOf("full_name")])
                .limit(10).collect(Collectors.toList());
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {
		return jogadoresFIFA.stream()
				.collect(Collectors.groupingBy(c -> Integer.parseInt(c[cabecalhos.indexOf("age")]),Collectors.reducing(0,e -> 1, Integer ::sum)));
	}

}
