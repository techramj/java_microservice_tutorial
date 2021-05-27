package pkg1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class Test1 {

    public static void main(String[] args) {
        System.out.println("Integer");
        rule3();
    }


    public static void rule1(){
        //function cannot throw checked exception
        Function<BufferedReader, String> f=(BufferedReader b)->{
            try {
                return b.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }


    public static void rule2(){
        //local variable cannot be re-assinged
        int a=10;
        Runnable r=()->{
            System.out.println(a);
        };

       // a=20;  //cannot reassing the value

    }

    /*

    a closure is an instance of a function that can
    reference nonlocal variables of that function with no restrictions. For example, a
    closure could be passed as argument to another function. It could also access and
    modify variables defined outside its scope
     */

    //Method reference
    public static void rule3(){
        ToIntFunction<String> stringToInt =(String s)->Integer.parseInt(s);
        int i = stringToInt.applyAsInt("10");
        System.out.println(i);

        ToIntFunction<String> stringToInt1=Integer::parseInt;
        i=stringToInt1.applyAsInt("20");
        System.out.println(i);

        Function<String,Integer> fun1=Integer::parseInt;
        Integer iob=fun1.apply("100");
        System.out.println(iob);







    }




}
