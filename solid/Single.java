public class Single {

  public static void main(String[] args) {

    Shape s = new Shape();

    Shape.Circle c = new Shape.Circle();
    // Circle c = new Circle();

    System.out.println(s.SquareArea(7));

    System.out.println(c.CircleArea(7));
  }
}