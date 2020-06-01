package com.challenge;

import java.util.function.Consumer;

public class LambdaInference {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        //primeira parte, indentificar a Functional Interface (FI)
        Consumer<String> c1 = msg -> System.out.println(msg.length());

        //segunda parte, identificar os tipo de parâmetros

        //ok, but inferred parameter type is Object (o compilador não acha o tipo do parâmetro de define ele como object)
        // e não tem o método Length no tipo Object
        Consumer<?> c2 = msg -> System.out.println(msg);

        // Compile-time error: inference is not based on body of lambda (ele não busca no corpo da lambda para saber o tipo de
        //parâmetro e o método length não pertence ao tipo Object
        //Consumer<?> c3 = msg -> System.out.println(msg.length());

        //ok, added manifest type to parameter.
        Consumer<?> c4 = (String msg) -> System.out.println(msg.length());







    }


}
