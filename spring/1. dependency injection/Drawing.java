public class Drawing {
    public static void main(String[] args) {
        Draw d = new Draw();
        rect r = new rect();
        d.setShape(r);
        d.drawShape();
    }
}

class Draw {
    S s;

    public void setShape(S s) {
        this.s = s;
    }

    public void drawShape() {
        this.s.shape();
    }

}
