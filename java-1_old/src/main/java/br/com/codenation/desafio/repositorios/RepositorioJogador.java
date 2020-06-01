package br.com.codenation.desafio.repositorios;

import br.com.codenation.desafio.classes.Jogador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioJogador {

    private List<Jogador> jogadores = new ArrayList<>();

    public void add(Jogador jogador){
        this.jogadores.add(jogador);
    }

    public void delete(Jogador jogador){
        this.jogadores.remove(jogador);
    }

    public Jogador search(Long id){
        for (Jogador jogador:jogadores) {
            if (jogador.getId().equals(id)){
                return  jogador;
            }
        }
        return null;
    }

    public List<Long> buscarJogadoresDoTime(Long idTime){

        return  jogadores.stream().filter(jogador -> jogador.getIdTime().equals(idTime)).map(Jogador::getId).sorted().collect(Collectors.toList());

    }

    public Long buscarMelhorJogadorDoTime(Long idTime){

        Long melhorJogador = null;
        Integer nivelHabilidade = 0;
        Integer maiorNivelHabilide = 0;

        for (Jogador jogador:jogadores) {
            if (jogador.getNivelHabilidade() > maiorNivelHabilide){
                maiorNivelHabilide = jogador.getNivelHabilidade();
                melhorJogador = jogador.getId();
            }
        }
        return  melhorJogador;
    }

    public Long buscarJogadorMaisVelho(Long idTime){
        return jogadores.stream()
                .filter(t -> t.getIdTime() == idTime)
                .sorted(Comparator.comparing(Jogador::getDataNascimento).thenComparing(Jogador::getId))
                .findFirst()
                .get()
                .getId();
    }

    public Long buscarJogadorMaiorSalario(Long idTime){

        return jogadores.stream()
                .filter(t -> t.getIdTime() == idTime)
                .max((Comparator.comparing(Jogador::getSalario)))
                .get()
                .getId();

    }

    public List<Long> buscarTopJogadores(Integer top){
        return jogadores.stream()
                .sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed().thenComparing(Jogador::getId))
                .limit(top)
                .map(l -> l.getId())
                .collect(Collectors.toList());
    }

}
