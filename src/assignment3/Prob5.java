/*Write a program to demonstrate all constructors and 15 methods of TreeMap.
*/

package assignment3;

import java.util.*;

public class Prob5 {

    public static void main(String[] args) {

        
        TreeMap<Integer,String> t1 = new TreeMap<>();                        
        TreeMap<Integer,String> t2 = new TreeMap<>(Comparator.reverseOrder()); 
        TreeMap<Integer,String> t3 = new TreeMap<>(Map.of(1,"One",2,"Two")); 
        TreeMap<Integer,String> t4 = new TreeMap<>(t3);                      

        System.out.println("Constructor Demo:");
        System.out.println("t1 = " + t1);
        System.out.println("t2 (reverse order) = " + t2);
        System.out.println("t3 (from map) = " + t3);
        System.out.println("t4 (copy) = " + t4);

        System.out.println("\n===== METHODS DEMO =====");

        TreeMap<Integer,String> map = new TreeMap<>();

        
        map.put(101, "Alice");
        map.put(102, "Bob");
        map.put(103, "Carol");

       
        map.putIfAbsent(104, "David");
        map.putIfAbsent(101, "X");

        
        System.out.println("Get 102 = " + map.get(102));

        
        System.out.println("Get 200 (default) = " + map.getOrDefault(200, "Not Found"));


        System.out.println("First Key = " + map.firstKey());


        System.out.println("Last Key = " + map.lastKey());

     
        System.out.println("Higher Key than 102 = " + map.higherKey(102));

    
        System.out.println("Lower Key than 102 = " + map.lowerKey(102));

 
        System.out.println("Ceiling Entry (102) = " + map.ceilingEntry(102));


        System.out.println("Floor Entry (102) = " + map.floorEntry(102));

        
        System.out.println("Contains key 103? " + map.containsKey(103));


        System.out.println("Contains value Bob? " + map.containsValue("Bob"));

    
        map.remove(103);

   
        map.replace(102, "Bobby");

    
        System.out.println("Entries = " + map.entrySet());

        System.out.println("\nFinal TreeMap = " + map);
    }
}
