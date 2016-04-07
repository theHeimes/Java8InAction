package lambdasinaction.chap3;

import java.util.function.Function;

public class FunctionComposition {
  public static void main(String[] args) {
    Function<Integer, Integer> f = x -> x + 1;
    Function<Integer, Integer> g = x -> x * 2;
    Function<Integer, Integer> h = f.andThen(g);
    Function<Integer, Integer> i = f.compose(g);
    
    System.out.println( "Combine f and g on 1: " + h.apply(1));
    System.out.println( "Compose f and g on 1: " + i.apply(1));
    
    Function<String, String> addHeader = Letter::addHeader;
    Function<String, String> transformationPipeline = 
        addHeader
          .andThen(Letter::checkSpelling)
          .andThen(Letter::addFooter);
    
    String text = "labda in action";
    System.out.println( transformationPipeline.apply(text));
  }
}
