import java.util.*;
import java.io.*;

public class Main {
    static long findRes(long A, long B, long C) {
        if (B == 0) return 1;
        if (B == 1) return A % C;
        if (B % 2 == 1) { // B가 홀수라면
            return (A * findRes(A, B-1, C)) % C;
        }
        long res = findRes(A, B/2, C) % C;
        return (res * res) %C;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long A =  Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(findRes(A,B,C));

        br.close();
    }
}
