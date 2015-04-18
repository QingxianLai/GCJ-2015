import java.util.*;
import java.io.*;
/**
 * Created by LaiQX on 04/10/15.
 */
public class ReverseWords {
  public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
    Scanner sc = new Scanner(System.in);

    PrintWriter writer = new PrintWriter("output", "UTF-8");

    int n = Integer.parseInt(sc.nextLine());
    for (int i = 0; i<n; i++ ) {
      String[] a = sc.nextLine().split(" ");
      StringBuilder res = new StringBuilder();
      res.append("Case #"+(i+1)+": ");
      for(int j = a.length-1; j>0; j--) {
        res.append(a[j]+" ");
      }
      res.append(a[0]);
      writer.println(res);
    }
    writer.close();
  }
}
