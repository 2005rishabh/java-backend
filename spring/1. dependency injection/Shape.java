public class Shape {
    public static void main(String[] args) {
        S s = new circle();
        s.shape();

        S s1 = new rect();
        s1.shape();

        drawMethod(s);
    }

    static void drawMethod(S s) {
        s.shape();
    }
}


interface S {
    public void shape();
}

class rect implements S{
    @Override
    public void shape() {
        System.out.println("its a rect");
    }
}


class circle implements S{

    @Override
    public void shape() {
        System.out.println("its a circle");
    }
}