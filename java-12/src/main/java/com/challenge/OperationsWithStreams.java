package com.challenge;

import com.challenge.entity.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperationsWithStreams {

    public static void main(String[] args) {
        //Select 10 random positive distinct integers
        final Random rand = new Random();
        Stream<Integer> randoms = Stream.generate(rand::nextInt);

        randoms.filter(n -> n > 0)
               .distinct()
               .limit(10)
               .forEach(System.out::println);

        //you have a sequence os enployees, sorted by icreasing salary
        //you want the employees with salary at most 2000
        //Employee employee = new Employee("Andrea",20000);
        //employee.getEmployees();

        List<Employee> employees = new ArrayList<>();
        List<Employee> employeeMost200 = null;

        //Jogando em uma lista nova (usando filter)
        employeeMost200 = employees.stream().filter(e -> e.getSalary() <= 2000).collect(Collectors.toList());

        //Imprimindo no console (usando filter)
         employees.stream().filter(e -> e.getSalary() <= 2000).forEach(System.out::println);


         // O método takeWhile é mais eficiente porque ele varre a stream (que nesse caso é ordenada)
        // até que a condição seja atingida
        //Jogando em uma lista nova (usando takeWhile) (Somente no java 9)
        //employeeMost200 = employees.stream().takeWhile(e -> e.getSalary() <= 2000).collect(Collectors.toList());

        //Objective: Print names os the 10 employees with the highest salary
        employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .limit(10)
                .map(Employee::getName)
                .forEachOrdered(System.out::println);

        //Objective: Efficiently count the number of distinct integers in a list
        List<Integer> list = employees.stream().map(Employee::getSalary).collect(Collectors.toList());

        long n = list.parallelStream()  // this stream is naturally ordered (from list)
                .unordered()   // Relaxing the order gives significant speedup
                .distinct()
                .count();


        //according

    }



}
