/*Write a program to demonstrate all constructors and 15 methods of HashTable.*/

package assignment3;

import java.util.*;

public class Prob4 {

    public static void main(String[] args) {

       
        Hashtable<Integer,String> h1 = new Hashtable<>();                    
        Hashtable<Integer,String> h2 = new Hashtable<>(10);                 
        Hashtable<Integer,String> h3 = new Hashtable<>(10, 0.75f);          

        Map<Integer,String> temp = Map.of(1,"One",2,"Two");
        Hashtable<Integer,String> h4 = new Hashtable<>(temp);              

        System.out.println("Constructor Demo:");
        System.out.println("h1 = " + h1);
        System.out.println("h2 = " + h2);
        System.out.println("h3 = " + h3);
        System.out.println("h4 (from map) = " + h4);

        System.out.println("\n===== METHODS DEMO =====");

        Hashtable<Integer,String> table = new Hashtable<>();

        table.put(101, "Alice");
        table.put(102, "Bob");
        table.put(103, "Carol");


        table.putIfAbsent(104, "David");
        table.putIfAbsent(101, "X");


        System.out.println("Get 102 = " + table.get(102));


        System.out.println("Get 200 (default) = " + table.getOrDefault(200, "Not Found"));


        System.out.println("Contains key 103? " + table.containsKey(103));

        
        System.out.println("Contains value Bob? " + table.containsValue("Bob"));


        table.replace(102, "Bobby");


        table.remove(103);


        table.remove(104, "David");

       
        System.out.println("Keys = " + table.keySet());


        System.out.println("Values = " + table.values());


        System.out.println("Entries = " + table.entrySet());


        Hashtable<Integer,String> t2 = new Hashtable<>();
        t2.put(201, "Eve");
        t2.put(202, "Frank");
        table.putAll(t2);


        System.out.println("Size = " + table.size());


        System.out.println("Is Empty? " + table.isEmpty());


        System.out.println("\nFinal Hashtable = " + table);
    }
}
