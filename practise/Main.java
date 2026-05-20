import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add(5);
        c.add(434343);
        for (Object n : c) {
            System.out.println((Integer) n);
        }


    }
}