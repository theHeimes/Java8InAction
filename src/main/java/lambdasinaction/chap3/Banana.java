package lambdasinaction.chap3;

public class Banana implements Fruit {
    private Integer weight = 0;
    private String color = "";

    public Banana() {
      this(1, "yellow");
    }
    
    public Banana(Integer weight) {
      this(weight, "yellow");
    }
    
    public Banana(String color) {
      this(1, color);
    }
    
    public Banana(Integer weight, String color){
        this.weight = weight;
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Banana{" +
               "color='" + color + '\'' +
               ", weight=" + weight +
               '}';
    }
}
