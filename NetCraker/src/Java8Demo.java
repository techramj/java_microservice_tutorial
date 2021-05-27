import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Demo {

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("Babu");
        list.add("Ram");
        list.add("Kiran");
        list.add("Sakuntala");
        list.add("Rajiv");
        list.add("Abhi");
        list.add("Laxu");

        List<String> newList=new ArrayList<>();
        for(String s:list){
            if(s.contains("r") || s.contains("R")){
                newList.add(s);
            }
        }

        Collections.sort(newList);
        System.out.println(newList);

        List<String> collect = list.stream().filter(a -> {
            return a.contains("r") || a.contains("R");
        }).sorted().collect(Collectors.toList());



        System.out.println(collect);


    }




}
