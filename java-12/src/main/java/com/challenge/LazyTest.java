package com.challenge;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class LazyTest {

    public static void main(String[] args) {
        final Random random  = new Random();

        Supplier<Integer> supp = () -> {
            Integer result = random.nextInt();
            System.out.println("(supplying " + result + ")");
            return result;
        };

        System.out.println("n/ Teste 1");

        Stream<Integer> randoms = Stream.generate(supp);

        System.out.println("First Stream Built");

        randoms.filter(n -> n>=0).limit(3).forEach(System.out::println);

        System.out.println("");
        System.out.println("n/ Teste 2");

        Stream<Integer> randoms2 = Stream.generate(supp);

        randoms2.limit(3).filter(n -> n>=0).forEach(System.out::println);


    }

}
