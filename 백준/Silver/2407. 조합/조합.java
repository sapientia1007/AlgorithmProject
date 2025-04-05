import java.io.*;
import java.util.*;
import java.math.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println(comb(n, m));
        br.close();
    }

    public static BigInteger comb(int n, int m){ 
        if (m > n-m)  {
            m = n-m;
        }

        BigInteger num = BigInteger.ONE;

        for (int i=1; i<=m; i++){
            num = num.multiply(BigInteger.valueOf(n - i + 1));
            num = num.divide(BigInteger.valueOf(i));        
        }

        return num;
    }
}