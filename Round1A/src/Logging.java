/**
 * Created by LaiQX on 04/17/15.
 *
 * Input

 2
 5
 0 0
 10 0
 10 10
 0 10
 5 5
 */

import java.util.*;
import java.io.*;

public class Logging {

    class point{
        int x;
        int y;
        point(int X, int Y) {
            x = X;
            y = Y;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        PrintWriter wr = new PrintWriter("output2");
        int N = Integer.parseInt(sc.nextLine());
        for (int i = 0; i< N ; i++) {

            StringBuilder ans = new StringBuilder();
            ans.append("Case #"+(i+1)+": ");



            int T = Integer.parseInt(sc.nextLine());
            int[] X = new int[T];
            int[] Y = new int[T];
            for (int j = 0; j < T; j++) {
                String[] tmp = sc.nextLine().split(" ");
                X[j] = Integer.parseInt(tmp[0]);
                Y[j] = Integer.parseInt(tmp[1]);
            }

            for (int j = 0; j< T ; j++) {
                int min_count = Integer.MAX_VALUE;
                for (int k = 0; k < T ; k++) {
                    if (j==k) continue;
                    for (int l = 0; l<T; l++) {
                        if (l==j || l==k) continue;
                        int count = 0;
                        for (int t=0; t<T; t++) {
                            if (t==j || t==k || t==l) continue;

                        }
                    }
                }
            }

            wr.println(ans);

        }
        wr.close();
    }

}
