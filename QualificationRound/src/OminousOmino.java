import java.util.*;
import java.io.*;
/**
 * Created by LaiQX on 04/11/15.
 */
public class OminousOmino {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(System.in);
    PrintWriter wr = new PrintWriter("output4");
    int n = sc.nextInt();
    for (int i = 0; i < n ; i++) {
      int X = sc.nextInt();
      int R = sc.nextInt();
      int C = sc.nextInt();
      StringBuilder ans = new StringBuilder();
      ans.append("Case #"+(i+1)+": ");
      if ((R*C)%X!=0) {
        ans.append("RICHARD");
        wr.println(ans);
        continue;
      }
      if (X==1 || X == 2) {
        ans.append("GABRIEL");
        wr.println(ans);
        continue;
      }
      if ((R*C==3 && X==3)||(R*C==4 && X==4)||(R*C==8 && X==4)){
        ans.append("RICHARD");
        wr.println(ans);
        continue;
      }
      ans.append("GABRIEL");
      wr.println(ans);
    }
    wr.close();
  }
}
