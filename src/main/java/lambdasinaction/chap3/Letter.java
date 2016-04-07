package lambdasinaction.chap3;

public class Letter {
  public static String addHeader(String text) {
    return "From Raoul, Mario and Allen: " + text;
  }

  public static String addFooter(String text) {
    return text + " Kind regards";
  }
  
  public static String checkSpelling(String text) {
    return text.replaceAll("labda", "lambda");
  }
}
