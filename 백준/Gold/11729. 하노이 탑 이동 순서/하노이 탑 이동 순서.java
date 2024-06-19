import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int cnt = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Hanoi(num, 1, 2, 3);
        System.out.println(cnt);
        System.out.println(sb);
    }

    public static void Hanoi(int n, int start, int mid, int end) {
        if (n == 0) {
            return;
        } else {
            cnt++;
            Hanoi(n - 1, start, end, mid);
            sb.append(start + " " + end + "\n");
            Hanoi(n - 1, mid, start, end);
        }
    }
}