package com.challenge;



import java.util.ArrayList;
import java.util.List;

public class TesteJavaBackend {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(2);
        arr.add(1);
        Integer n = 2;
        System.out.println("O número de ocorrencias do 2 na array é (trad) : " + retornaNumeroOcorrencias(arr,n)) ;
        System.out.println("O número de ocorrencias do 2 na array é STREAM : " + retornaNumeroOcorrencias2(arr,n)) ;
    }

    public static Integer retornaNumeroOcorrencias(List<Integer> arr, Integer n){
        Integer numeroOcorrencias = 0;

        for (int i=0;i<arr.size();i++) {
            if (arr.get(i) == n) {
                numeroOcorrencias +=1;
            }
        }

        return numeroOcorrencias;
    }

    public static Integer retornaNumeroOcorrencias2(List<Integer> arr, Integer n){
        return Math.toIntExact(arr.stream().filter(e -> e.equals(n)).count());

    }
}
