package lambdasinaction.chap3;

public class Orange implements Fruit {
    private Integer weight = 0;
    private String color = "";

    public Orange() {
      this(1, "orange");
    }
    
    public Orange(Integer weight) {
      this(weight, "orange");
    }
    
    public Orange(String color) {
      this(1, color);
    }
    
    public Orange(Integer weight, String color){
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
        return "Orange{" +
               "color='" + color + '\'' +
               ", weight=" + weight +
               '}';
    }
}
