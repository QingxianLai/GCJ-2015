import java.util.*;
import java.io.*;
/**
 * Created by LaiQX on 04/11/15.
 */
public class Pancakes {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(System.in);
    PrintWriter wr = new PrintWriter("output2");
    int n = Integer.parseInt(sc.nextLine());
    HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
    int [] val = {1,2,3,2,3,3,4,4,5};
    int [] key = {1,2,3,4,5,6,7,8,9};
    for (int i = 0; i<9; i++) {
      map.put(key[i],val[i]);
    }

    for (int i = 0; i<n; i++) {
      int D = Integer.parseInt(sc.nextLine());
      String[] nums = sc.nextLine().split(" ");

      StringBuilder ans = new StringBuilder();
      ans.append("Case #"+(i+1)+": ");

      int [] digits = new int[D];
      for (int j = 0; j< D; j++) {
        digits[j] = Integer.parseInt(nums[j]);
      }
      Arrays.sort(digits);
      int max = digits[D-1];
      int thrsh = map.get(max);
      int less = 0;
      while (less<D && digits[less]<=thrsh)
        less++;


      int min = (D-less)+thrsh;
      while (less<D && digits[less]<max) {
        thrsh = digits[less];
        while (less< D && digits[less]==thrsh)
          less++;
        min = Math.min(min,(D-less)+thrsh);
      }

      min = Math.min(min,max);

      ans.append(min);
      wr.println(ans);
    }

    wr.close();
  }
}
