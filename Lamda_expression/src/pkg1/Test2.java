package pkg1;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(3);

        Integer i=3;
        list.remove(3);

    }
}
