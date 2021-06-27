package basics.p5_type_system;

import java.util.List;

public class Printer {

    public static void print(List<Integer> ls){
        for (Integer i : ls){
            System.out.println(i);
        }
    }

    public static void add1(List<Integer> ls){
        ls.add(1);
    }


    public static void printArray(Integer[] ls){
        for (int i : ls){
            System.out.println(i);
        }

    }



}
