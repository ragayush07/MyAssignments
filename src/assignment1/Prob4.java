/*Differentiate String, StringBuffer and StringBuilder. Write a program to perform String
related operations using length(), isEmpty(), chatAt(), toString(), equals(), compareTo(),
contains(), indexOf(), lastIndexOf(), startsWith(), endsWith(), matches(), substring(),
toLowerCase(), trim(), replace(), split(), join(), and valueOf(). */

package assignment1;

public class Prob4 {

	public static void main(String[] args) {
		String s1 = "  Hello Java World  ";
        String s2 = "Hello Java World";
        String s3 = "Java";

     
        System.out.println("Length: " + s1.length());


        System.out.println("Is Empty: " + s1.isEmpty());

       
        System.out.println("Character at index 1: " + s2.charAt(1));


        StringBuffer sb = new StringBuffer("Hello");
        System.out.println("toString(): " + sb.toString());


        System.out.println("Equals: " + s2.equals(s1.trim()));


        System.out.println("CompareTo: " + s2.compareTo(s3));


        System.out.println("Contains 'Java': " + s2.contains("Java"));

    
        System.out.println("IndexOf 'Java': " + s2.indexOf("Java"));

      
        System.out.println("LastIndexOf 'o': " + s2.lastIndexOf('o'));


        System.out.println("StartsWith 'Hello': " + s2.startsWith("Hello"));

       
        System.out.println("EndsWith 'World': " + s2.endsWith("World"));


        System.out.println("Matches regex: " + s2.matches(".*Java.*"));


        System.out.println("Substring: " + s2.substring(6, 10));


        System.out.println("Lowercase: " + s2.toLowerCase());


        System.out.println("Trimmed: '" + s1.trim() + "'");


        System.out.println("Replace: " + s2.replace("Java", "Python"));


        String[] words = s2.split(" ");
        System.out.println("Split:");
        for (String w : words) {
            System.out.println(w);
        }


        String joined = String.join("-", words);
        System.out.println("Joined: " + joined);


        int num = 100;
        String numStr = String.valueOf(num);
        System.out.println("ValueOf: " + numStr);

	}

}
