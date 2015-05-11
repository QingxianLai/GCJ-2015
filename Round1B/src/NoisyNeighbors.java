/**
 * Created by LaiQX on 05/02/15.
 */
import java.util.*;
import java.io.*;

public class NoisyNeighbors {
    public static void main(String[] args) throws FileNotFoundException {
//        File input = new File("src/A-small-attempt1.in");
        File input = new File("src/input2");
        Scanner sc = new Scanner(input);
        PrintWriter wr = new PrintWriter("output3");
        int T = Integer.parseInt(sc.nextLine());
        for (int i = 0; i< T ; i++) {

            StringBuilder ans = new StringBuilder();
            ans.append("Case #"+(i+1)+": ");

            String[] tmp = sc.nextLine().split(" ");
            int R = Integer.parseInt(tmp[0]);
            int C = Integer.parseInt(tmp[1]);
            int N = Integer.parseInt(tmp[2]);

            int[][] apart = new int[R][C];

            if (R*C==1) {
                ans.append("0");
            }

            if (R*C==2) {
                if (N==1)
                    ans.append(0);
                else
                    ans.append(1);
            }

            if (R*C==3) {
                if (N==1|| N==2)
                    ans.append(0);
                else
                    ans.append(1);
            }

            if (R*C==4) {
                if (R==1||C==1) {
                    if (N==1||N==2) {
                        ans.append(0);
                    } else {
                        ans.append(N-1);
                    }
                } else {
                    if (N<3){
                        ans.append(0);
                    } else if (N==3) {
                        ans.append(2);
                    } else {
                        ans.append(4);
                    }
                }
            }


            if (R*C==6) {
                if (N<=3) {
                    ans.append(0);
                } else if (N==4) {
                    ans.append(2);
                } else if (N==5) {
                    ans.append(4);
                } else {
                    ans.append(7);
                }
            }


            if (R*C==8) {
                if (N<=4) {
                    ans.append(0);
                } else if (N==5) {
                    ans.append(3);
                } else if (N==6) {
                    ans.append(4);
                } else if (N==7){
                    ans.append(7);
                } else {
                    ans.append(10);
                }
            }

            int unhappy = R*(C-1)+C*(R-1);

            if (R==3||C==3) {
                if (N<=R*C/2) {
                    ans.append(0);
                }
            }


            wr.println(ans);
            System.out.println("case # "+(i+1)+" done!");

        }
        wr.close();
    }
}
