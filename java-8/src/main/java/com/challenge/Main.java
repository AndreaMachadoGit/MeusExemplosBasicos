package com.challenge;

import com.challenge.desafio.CalculadorDeClasses;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        CalculadorDeClasses caculador = new CalculadorDeClasses();
        ClasseTeste teste = new ClasseTeste("Nome", new BigDecimal(1000),new BigDecimal(200),15L,new BigDecimal(500),new BigDecimal(200),12L);
        ClasseTeste teste2 = new ClasseTeste("Nome2", new BigDecimal(1500),new BigDecimal(150),12L,new BigDecimal(300),new BigDecimal(0),10L);
        ClasseTeste teste3 = new ClasseTeste("Nome3", new BigDecimal(800),new BigDecimal(100),12L,new BigDecimal(500),new BigDecimal(250),5L);
        List<ClasseTeste> lstPessoas = new ArrayList<>();
        lstPessoas.add(teste);
        lstPessoas.add(teste2);
        lstPessoas.add(teste3);
        System.out.println("Total dos atributos somar: " +  String.valueOf(caculador.somar(teste)));
        System.out.println("Total dos atributos diminuir: " +  String.valueOf(caculador.subtrair(teste)));
        System.out.println("Total dos atributos totalizar: " +  String.valueOf(caculador.totalizar(teste)));
    }


}
