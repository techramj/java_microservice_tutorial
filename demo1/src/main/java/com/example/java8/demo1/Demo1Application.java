package com.example.java8.demo1;

import com.example.java8.demo1.dto.Trader;
import com.example.java8.demo1.dto.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
      List<Transaction> transactions=transactions();

      //1. Find all transactions in the year 2011 and sort them by value (small to high)
        List<Transaction> trans1 = transactions.stream().filter(a -> a.getYear() == 2011).
                sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());

        List<Transaction> trans12 = transactions.stream().filter(a -> a.getYear() == 2011).
                sorted((o1, o2) -> o1.getValue()-o2.getValue()).collect(Collectors.toList());

        trans1.forEach(System.out::println);


      //2. What are all the unique cities where the traders work?
        System.out.println("What are all the unique cities where the traders work?");
        transactions.stream().map(a->a.getTrader().getCity()).distinct().collect(Collectors.toList()).forEach(System.out::println);

      //3.Find all traders from Cambridge and sort them by name
        System.out.println("Find all traders from Cambridge and sort them by name");
        transactions.stream().filter(a->a.getTrader().getCity().equals("Cambridge")).
                sorted(Comparator.comparing(a->a.getTrader().getName())).collect(Collectors.toList()).forEach(System.out::println);

      //4.Return a string of all traders’ names sorted alphabetically



    }




    public static List<Transaction> transactions(){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        return transactions;

    }



    /*
    2. Given two lists of numbers, how would you return all pairs of numbers? For example, given a
    list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For
    simplicity, you can represent a pair as an array
     */
    public static void pairing(){
        List<Integer> num1=Arrays.asList(1,2,3);
        List<Integer> num2=Arrays.asList(3,4);

        List<int[]> collect = num1.stream().flatMap(i -> num2.stream().map(j -> new int[]{i, j})).
                collect(Collectors.toList());
        System.out.println(collect);
        collect.forEach(a-> System.out.println(a[0]+"  "+a[1]));

        Stream<Stream<int[]>> streamStream = num1.stream().map(i -> num2.stream().map(j -> new int[]{i, j}));



    }

    public static void squareNumber(){
        List<Integer> list=Arrays.asList(1,2,3,4,5);
        List<Integer> collect = list.stream().map(a -> a * a).collect(Collectors.toList());
        System.out.println(collect);

    }

    public static void flatteringString(){
        String[] words={"apple","ball"};

        List<String[]> collect = Arrays.stream(words).map(a -> a.split("")).distinct().collect(Collectors.toList());
        //collect.forEach(System.out::println);
       // System.out.println(collect);

    }

    public static void flatteringString1(){
        String[] words={"apple","ball"};

        List<Stream<String>> collect = Arrays.stream(words).map(a -> a.split("")).map(Arrays::stream).
                distinct().collect(Collectors.toList());
        System.out.println(collect);

    }


    public static void flatteringString2(){
        String[] words={"apple","ball"};

        List<String> collect = Arrays.stream(words).map(a -> a.split("")).flatMap(Arrays::stream).
                //distinct().
                collect(Collectors.toList());
        System.out.println(collect);

    }

}
