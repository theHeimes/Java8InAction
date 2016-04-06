package lambdasinaction.chap3;

import java.util.Arrays;
import java.util.List;

public class StringSorting {

  public static void main(String[] args) {
    List<String> str1 = Arrays.asList("a", "b", "A", "B");
    System.out.println("The basic array");
    for(String s : str1) {
      System.out.print(s + " ");
    }
    System.out.println();
    System.out.println("\nAfter sorting with lambda");
    str1.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
    for(String s : str1) {
      System.out.print(s + " ");
    }
    System.out.println();
    
    System.out.println("\n\nRestoring the array");
    str1 = Arrays.asList("a", "b", "A", "B");
    for(String s : str1) {
      System.out.print(s + " ");
    }
    System.out.println();
    System.out.println("\nAfter sorting with method-reference");
    str1.sort(String::compareToIgnoreCase);
    for(String s : str1) {
      System.out.print(s + " ");
    }
    System.out.println();
  }

}
