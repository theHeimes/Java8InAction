package lambdasinaction.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PredicateUsage {
  
  @FunctionalInterface
  public interface Predicate<T> {
    boolean test(T t);
  }

  public static void main(String[] args) {
    List<String> listOfString = Arrays.asList("hello", "flexible", "", "lambda", "", "world" ); 

    Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();

    List<String> nonEmpty = filter(listOfString, nonEmptyStringPredicate);
    
    for(String s : nonEmpty) {
      System.out.println(s);
    }

  }
  public static <T> List<T> filter(List<T> list, Predicate<T> p) {
    List<T> result = new ArrayList<>();
    for (T s : list) {
      if(p.test(s)){
        result.add(s);
      }
    }
    return result;
  }
}
