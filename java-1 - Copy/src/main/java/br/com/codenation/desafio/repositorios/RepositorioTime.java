package br.com.codenation.desafio.repositorios;

import br.com.codenation.desafio.classes.Jogador;
import br.com.codenation.desafio.classes.Time;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioTime {

    private List<Time> times = new ArrayList<>();

    public void add(Time time){
        this.times.add(time);
    }

    public void delete(Time time){
        this.times.remove(time);
    }

    public Time search(Long id){
        for (Time time:times) {
            if (time.getId().equals(id)){
                return  time;
            }
        }
        return null;
    }

    public List<Long> findAll(){
        return this.times.stream().sorted((t1,t2) -> t1.getId().compareTo(t2.getId())).map(t -> t.getId()).collect(Collectors.toList());
    }

}
