package com.challenge;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ClasseTeste {

    private String nome;
    @Somar
    private BigDecimal salario;

    @Subtrair
    private BigDecimal valorDescontos;

    @Somar
    private long score;

    @Somar
    private BigDecimal valorCredito;

    @Subtrair
    private BigDecimal valorDebito;

    @Subtrair
    private long valorEmprestimo;

    public ClasseTeste(String nome, BigDecimal salario, BigDecimal valorDescontos, long score, BigDecimal valorCredito, BigDecimal valorDebito, long valorEmprestimo) {
        this.nome = nome;
        this.salario = salario;
        this.valorDescontos = valorDescontos;
        this.score = score;
        this.valorCredito = valorCredito;
        this.valorDebito = valorDebito;
        this.valorEmprestimo = valorEmprestimo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public BigDecimal getValorDescontos() {
        return valorDescontos;
    }

    public void setValorDescontos(BigDecimal valorDescontos) {
        this.valorDescontos = valorDescontos;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public BigDecimal getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(BigDecimal valorCredito) {
        this.valorCredito = valorCredito;
    }

    public BigDecimal getValorDebito() {
        return valorDebito;
    }

    public void setValorDebito(BigDecimal valorDebito) {
        this.valorDebito = valorDebito;
    }

    public long getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(long valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

}
