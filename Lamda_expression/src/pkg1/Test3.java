package pkg1;

import pkg1.bean.Dish;
import pkg1.bean.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Test3 {

    public static void main(String[] args) {
        List<Dish> menu=  new ArrayList<>(Util.getMenu());
        List<Dish> threeHighCalorieNames=menu.stream().filter(a->a.getCalories()>300).limit(3).collect(Collectors.toList());
        threeHighCalorieNames.forEach(System.out::println);



        commaSeperatedExample();
        display(menu);
        boolean b = menu.removeIf(m -> m.getCalories() < 600);
        System.out.println("-------------------------------------------");
        display(menu);





    }

    public static void commaSeperatedExample(){
        String[] arr={"a","b","c","d"};
        System.out.println(String.join(",",arr));
        String collect = Arrays.stream(arr).collect(Collectors.joining(","));
        System.out.println(collect);


    }

    public static void display(List<?> list){
        list.forEach(System.out::println);

    }

}
