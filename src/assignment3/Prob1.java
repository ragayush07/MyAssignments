/*Write a program to demonstrate all constructors and 15 methods of ArrayList.
*/

package assignment3;

import java.util.*;

public class Prob1 {

    public static void main(String[] args) {


        ArrayList<String> list1 = new ArrayList<>();                  
        ArrayList<String> list2 = new ArrayList<>(20);                
        ArrayList<String> list3 = new ArrayList<>(List.of("A","B"));  

        System.out.println("Constructor Demo:");
        System.out.println("list1 = " + list1);
        System.out.println("list2 (capacity 20) = " + list2);
        System.out.println("list3 (from collection) = " + list3);

        System.out.println("\n===== METHODS DEMO =====");

        ArrayList<String> arr = new ArrayList<>();

        arr.add("Apple");
        arr.add("Banana");
        arr.add("Cherry");


        arr.add(1, "Mango");

        System.out.println("Element at index 2 = " + arr.get(2));


        arr.set(2, "Orange");


        arr.remove(3);


        arr.remove("Apple");


        System.out.println("Size = " + arr.size());


        System.out.println("Contains Mango? " + arr.contains("Mango"));


        System.out.println("Index of Mango = " + arr.indexOf("Mango"));


        arr.add("Mango");
        System.out.println("Last index of Mango = " + arr.lastIndexOf("Mango"));


        System.out.println("Is empty? " + arr.isEmpty());


        arr.ensureCapacity(20);


        arr.trimToSize();


        List<String> sub = arr.subList(0, 2);
        System.out.println("Sublist(0,2) = " + sub);


        Object[] a = arr.toArray();
        System.out.println("Array form = " + Arrays.toString(a));


        System.out.println("\nFinal ArrayList = " + arr);
    }
}
