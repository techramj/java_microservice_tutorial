import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.*;

public class Test {

    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("apple",10);
        map.put("banana",8);
        map.put("mango",4);
        map.put("pineapple",25);

        LinkedHashMap<String, Integer> collect = map.entrySet().stream().sorted(comparingByValue()).collect(Collectors.
                toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

        System.out.println(map);
        System.out.println(collect);

        List<Map.Entry<String, Integer>> list = map.entrySet().stream().collect(Collectors.toList());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });
        Map<String, Integer> map2 = list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                //(e1, e2) -> e2,
                (o1, o2) -> o2,
                LinkedHashMap::new));

        System.out.println(map2);
        System.out.println(map2.getClass());



    }

    public static void demo1(){
        List<Integer> iList=new ArrayList<>();
        iList.add(1);
        iList.add(2);
        iList.add(3);
        iList.add(3);
        iList.add(1);
        System.out.println(iList);
        // iList=new ArrayList<>(new HashSet<>(iList));
        iList=iList.stream().distinct().collect(Collectors.toList());
        System.out.println(iList);
    }



    public  void reverse(String str,StringBuilder sb){
        if(str.length()==1){
            char ch=str.charAt(str.length()-1);
            sb.append(ch);
            return;
        }
        char ch=str.charAt(str.length()-1);
        sb.append(ch);

        reverse(str.substring(0,str.length()-1),sb);
    }

    /*



     */






}
