package com.challenge;

import com.challenge.entity.Employee;

import java.util.Comparator;
import java.util.function.Consumer;
//import java.util.function.

public class Lambda1 {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        Comparator<Employee> byName = new Comparator<Employee>() {
            @Override
            public int compare(Employee a, Employee b) {
                return a.getName().compareTo(b.getName());
            }
        };

        //Com lambda expression
        Comparator<Employee> byNameLambda1 = (Employee a, Employee b) -> {
            return a.getName().compareTo(b.getName());
        };

        // Removendo os tipos dos parâmetros
        Comparator<Employee> byNameLambda2 = (a, b) -> { return  a.getName().compareTo(b.getName());};

        // Removendo os colchetes (braces) e o return
        Comparator<Employee> byNameLambda3 = (a, b) -> a.getName().compareTo(b.getName());

        //Using Method Reference
        Comparator<Employee> byName2 = Comparator.comparing(Employee::getName);

        //Como era o compare
        Comparator<String> byLength = (String a, String b) -> {
            return Integer.compare(a.length(), b.length());
        };

        //Expressão sem parametros
        Runnable r= () -> {
            System.out.println("Um executável compacto!");
        };
        Thread t1 = new Thread(r);

        // Não precisa nem mencionar a Runnable interface
        Thread t2 = new Thread(() -> {System.out.println("Um executável implícito."); });

        //Não precisa nem colchetes (braces)
        Thread t3 = new Thread(() -> System.out.println("Um executável implícito."));


        //Expressão com um parâmetro
        Consumer<String> lengthPrinter = s -> System.out.println(s.length());

    }


}
