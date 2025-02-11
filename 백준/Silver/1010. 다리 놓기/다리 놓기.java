import java.util.*;
import java.io.*;

public class Main {
    static int C = 0; static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            C = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            System.out.println(comb(M, N));
        }
    }

    static int comb(int n, int r) {
        if(r > n-r) r = n-r;

        long res = 1;
        for (int i=0; i<r; i++) {
            res *= (n-i);
            res /= (i+1);
        }
        return (int) res;
    }
}
