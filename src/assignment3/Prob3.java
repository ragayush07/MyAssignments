/*Write a program to demonstrate all constructors and 15 methods of HashMap.
*/

package assignment3;

import java.util.*;

public class Prob3 {

    public static void main(String[] args) {

       
        HashMap<Integer,String> m1 = new HashMap<>();                   
        HashMap<Integer,String> m2 = new HashMap<>(20);                   
        HashMap<Integer,String> m3 = new HashMap<>(20, 0.75f);             

        Map<Integer,String> temp = Map.of(1,"One",2,"Two");
        HashMap<Integer,String> m4 = new HashMap<>(temp);             

        System.out.println("Constructor Demo:");
        System.out.println("m1 = " + m1);
        System.out.println("m2 = " + m2);
        System.out.println("m3 = " + m3);
        System.out.println("m4 (from map) = " + m4);

        System.out.println("\n===== METHODS DEMO =====");

        HashMap<Integer,String> map = new HashMap<>();


        map.put(101, "Alice");
        map.put(102, "Bob");
        map.put(103, "Carol");


        map.putIfAbsent(104, "David");
        map.putIfAbsent(101, "X");


        System.out.println("Get 102 = " + map.get(102));


        System.out.println("Get 200 (default) = " + map.getOrDefault(200, "Not Found"));


        System.out.println("Contains key 103? " + map.containsKey(103));


        System.out.println("Contains value Bob? " + map.containsValue("Bob"));


        map.replace(102, "Bobby");


        map.remove(103);


        map.remove(104, "David");

 
        System.out.println("Keys = " + map.keySet());


        System.out.println("Values = " + map.values());


        System.out.println("Entries = " + map.entrySet());


        HashMap<Integer,String> map2 = new HashMap<>();
        map2.put(201, "Eve");
        map2.put(202, "Frank");
        map.putAll(map2);


        System.out.println("Size = " + map.size());

        
        System.out.println("Is empty? " + map.isEmpty());

      
        System.out.println("\nFinal HashMap = " + map);
    }
}
