import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.math.BigInteger;

/**
 * Created by LaiQX on 04/18/15.
 * 擦，还是不行
 */
public class HairCut_BigInteger {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("src/B-large.in");
        Scanner sc = new Scanner(input);
        PrintWriter wr = new PrintWriter("output2");
        int T = Integer.parseInt(sc.nextLine());
        for (int i = 0; i< T ; i++) {

            StringBuilder ans = new StringBuilder();
            ans.append("Case #"+(i+1)+": ");

            String [] tmp = sc.nextLine().split(" ");
            int B = Integer.parseInt(tmp[0]);
//            long N = Long.parseLong(tmp[1]);
            BigInteger N = new BigInteger(tmp[1]);
            String[] ms = sc.nextLine().split(" ");

            BigInteger [] count = new BigInteger[B];
            for (int j = 0; j<B; j++) {
                count[j] = BigInteger.ZERO;
            }

            BigInteger [] barbers = new BigInteger[B];


            for (int j = 0; j< B; j++){
                barbers[j]  = new BigInteger(ms[j]);
            }

            BigInteger barber_lcm = BigInteger.ONE;

            barber_lcm = lcm(barbers);

            BigInteger total_client= new BigInteger("0");

            for (int j = 0; j< B; j++) {
                BigInteger tmp2 = barber_lcm.divide(barbers[j]);
                total_client = total_client.add(tmp2);
            }

            System.out.println(barber_lcm);
//            N = N%total_client;
            N = N.mod(total_client);
            if (N.equals(BigInteger.ZERO)) {
                N=total_client;
            }

            long longN = N.longValue();

            int min_index=0;
            for (long j = 0; j< longN ; j++) {
                BigInteger min = count[0];
                min_index = 0;
                for (int k = 0; k<B; k++) {
                    if (count[k].compareTo(min)<0) {
                        min = count[k];
                        min_index = k;
                    }
                }
                count[min_index] = count[min_index].add(barbers[min_index]);
            }
            ans.append((min_index+1));
            wr.println(ans);
            System.out.println("case # "+(i+1)+" done!");

        }
        wr.close();
    }



    private static BigInteger lcm(BigInteger a, BigInteger b)
    {
        return a.multiply(b.divide(a.gcd(b)));
    }

    private static BigInteger lcm(BigInteger[] input)
    {
        BigInteger result = input[0];
        for(int i = 1; i < input.length; i++)
            result = lcm(result, input[i]);
        return result;
    }

}
