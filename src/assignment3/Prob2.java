/*Write a program to demonstrate 15 methods of Vector, including all constructors.
*/

package assignment3;

import java.util.*;

public class Prob2 {

    public static void main(String[] args) {


        Vector<String> v1 = new Vector<>();                         
        Vector<String> v2 = new Vector<>(5);                         
        Vector<String> v3 = new Vector<>(5, 2);                     
        Vector<String> v4 = new Vector<>(List.of("A", "B", "C"));    

        System.out.println("Constructor Demo:");
        System.out.println("v1 = " + v1);
        System.out.println("v2 (capacity 5) = " + v2);
        System.out.println("v3 (capacity 5, increment 2) = " + v3);
        System.out.println("v4 (from collection) = " + v4);

        System.out.println("\n===== METHODS DEMO =====");

        Vector<String> vec = new Vector<>();


        vec.add("Apple");
        vec.add("Banana");
        vec.add("Cherry");


        vec.add(1, "Mango");


        System.out.println("Element at index 2 = " + vec.get(2));

    
        vec.set(2, "Orange");


        vec.remove(3);


        vec.remove("Apple");


        System.out.println("Size = " + vec.size());


        System.out.println("Capacity = " + vec.capacity());


        System.out.println("Contains Mango? " + vec.contains("Mango"));


        System.out.println("Index of Mango = " + vec.indexOf("Mango"));


        vec.addElement("Grapes");


        System.out.println("First element = " + vec.firstElement());


        System.out.println("Last element = " + vec.lastElement());


        vec.insertElementAt("Papaya", 1);


        vec.removeElementAt(2);


        System.out.println("\nFinal Vector = " + vec);
    }
}
