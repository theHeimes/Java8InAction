package lambdasinaction.chap3;

import java.util.function.DoubleFunction;

public class FunctionMathematics {

  
  public static double integrate( DoubleFunction<Double> f, double a, double b) {
    return (f.apply(a) + f.apply(b)) * (b - a) / 2.0; 
  }
  
  public static void main(String[] args) {
    System.out.println( integrate((double x) -> x + 10, 3, 7));
  }
}
