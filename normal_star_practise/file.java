public class File {
  class A {
    public void showA() {
      System.out.println("A");
    }
  }
  class B {
    public void showB() {
      System.out.println("B");
    }
  }
  public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.showA();
        b.showB();
    }
}
