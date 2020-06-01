package br.com.codenation.desafio.classes;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {

    private Long id;     //* Identificador do Jogador
    private Long idTime; //* Identificador do time
    private String nome; //* Nome do Jogador
    private LocalDate dataNascimento; //* Data de nascimento do Jogador
    private Integer nivelHabilidade; //* Nível de habilidade do jogador (0 a 100)
    private BigDecimal salario; //* Salário do jogador

    public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        setId(id);
        setIdTime(idTime);
        setNome(nome);
        setDataNascimento(dataNascimento);
        setNivelHabilidade(nivelHabilidade);
        setSalario(salario);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id < 0L) throw new IllegalArgumentException("Id do jogador obrigatório");
        this.id = id;
    }

    public Long getIdTime() {
        return this.idTime;
    }

    public void setIdTime(Long idTime) {
        if (idTime <0L) throw new IllegalArgumentException("Id do time obrigatório");
        this.idTime = idTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.equals("")) throw new IllegalArgumentException("O nome é obrigatório.");
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento == null) throw new IllegalArgumentException("Data de nascimento obrigatória.");
        this.dataNascimento = dataNascimento;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    public void setNivelHabilidade(Integer nivelHabilidade) {
        if (nivelHabilidade < 0 || nivelHabilidade > 100) throw new IllegalArgumentException();
        this.nivelHabilidade = nivelHabilidade;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        if (salario.intValue() < 0) throw new IllegalArgumentException();
        this.salario = salario;
    }
}
