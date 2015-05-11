/**
 * Created by LaiQX on 05/02/15.
 */
import java.util.*;
public class test {
    public static void main(String[] args) {
        int a = 10;
        StringBuilder tmp = new StringBuilder(""+a);
        int b = Integer.parseInt(tmp.reverse().toString());
        System.out.println(b);
    }
}
