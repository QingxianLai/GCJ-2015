import java.util.*;
import java.io.*;


public class Dijkstra {
  class Res{
    char c;
    int sign;

    Res() {}

    Res(char C) {
      c = C;
      sign = 1;
    }

    Res(char C,int Num) {
      c = C;
      sign = Num;
    }
  }

  public static void main(String[] args) throws FileNotFoundException{
    Dijkstra m = new Dijkstra();

    Scanner sc = new Scanner(System.in);
//    Scanner sc = new Scanner(raw_input);
    PrintWriter wr = new PrintWriter("output3");
    int n = Integer.parseInt(sc.nextLine());

    for (int i = 0; i<n; i++) {
      String[] raw = sc.nextLine().split(" ");

      int L = Integer.parseInt(raw[0]);
      int X = Integer.parseInt(raw[1]);

      StringBuilder ans = new StringBuilder();
      ans.append("Case #"+(i+1)+": ");

      String StringL = sc.nextLine();

      char tmp = StringL.charAt(0);
      int tmp_sign = 1;
      for (int j=1; j<L; j++) {
        Res tt = m.multiply(tmp,StringL.charAt(j));
        tmp = tt.c;
        tmp_sign = tmp_sign*tt.sign;
      }

      char total = tmp;
      int total_sign = tmp_sign;
      for (int j = 1; j<X; j++) {
        Res temp = m.multiply(total,tmp);
        total = temp.c;
        total_sign = total_sign*temp.sign*tmp_sign;
      }

      if (total!='1' || total_sign!=-1 ) {
        ans.append("NO");
        wr.println(ans);
        continue;
      }

      char sec_i = StringL.charAt(0);
      int sign_i = 1;

      char sec_k = StringL.charAt(L-1);
      int sign_k = 1 ;


      int head = 1;
      int tail = X*L-2;
      while (head<=tail && (sec_i!='i' || sign_i!=1)) {
        Res temp2 = m. multiply(sec_i,StringL.charAt(head%L));
        sec_i = temp2.c;
        sign_i = sign_i*temp2.sign;
        head++;
      }

      while (tail>=head && (sec_k!='k' || sign_k!=1)) {
        Res temp3 = m.multiply(StringL.charAt(tail%L),sec_k);
        sec_k = temp3.c;
        sign_k = sign_i*temp3.sign;
        tail--;
      }

      if (head<=tail) {
        ans.append("YES");
      } else {
        ans.append("NO");
      }
      wr.println(ans);

    }

    wr.close();
  }


  private Res multiply(char a, char b) {
    if (a == '1') {
      return new Res(b);
    }
    if (b == '1') {
      return new Res(a);
    }
    if (a==b) {
      return new Res('1',-1);
    }
    if (a=='i' && b=='j') {
      return new Res('k');
    }
    if (a=='j' && b=='k') {
      return new Res('i');
    }
    if (a=='k' && b=='i') {
      return new Res('j');
    }
    if (a=='i' && b=='k') {
      return new Res('j',-1);
    }
    if (a=='j' && b=='i') {
      return new Res('k',-1);
    }
    if (a=='k' && b=='j') {
      return new Res('i',-1);
    }
    return new Res();
  }

//  private Res div(Res a, char b) {
//    if (a.c=='1' && a.sign==1) {
//      return new Res(b,-1);
//    }
//    if (a.c=='1' && a.sign==-1) {
//      return new Res(b,1);
//    }
//
//    if (a.c=='i') {
//      if (b=='i') {
//        return new Res('1',a.sign);
//      } else if (b=='j') {
//        return new Res('k',a.sign);
//      } else {
//        return new Res('j',-a.sign);
//      }
//    }
//
//    if (a.c=='j') {
//      if (b=='i') {
//        return new Res('k',-a.sign);
//      } else if (b=='j') {
//        return new Res('1',a.sign);
//      } else {
//        return new Res('i',a.sign);
//      }
//    }
//
//    if (a.c=='k') {
//      if (b=='i') {
//        return new Res('j',a.sign);
//      } else if (b=='j') {
//        return new Res('i',-a.sign);
//      } else {
//        return new Res('1',a.sign);
//      }
//    }
//
//    return new Res();
//  }
}
