import java.util.*;
import java.io.*;

public class Main{
    static long X, Y;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        X = Integer.parseInt(st.nextToken()); Y = Integer.parseInt(st.nextToken());
        br.close();
        long wr = (Y*100)/X;
        if (wr >= 99 || X==Y) {
            System.out.println(-1);
            System.exit(0);
        }

        long left = 0;
        long right = X;
        long turn = 0;

        while (left <= right) {
            long mid = (left+right)/2;
            long newWr = ((Y+mid)*100)/(X+mid);

            if (newWr > wr) {
                turn = mid;
                right = mid-1;
            } else{
                left = mid+1;
            }
        }
        System.out.println(turn);
    }
}
