import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sqrt = (int) Math.sqrt(N);
        if (sqrt * sqrt == N) {
            System.out.println(1);
            return;
        }

        for (int i = 1; i * i <= N; i++) {
            int remain = N - i * i;
            int s = (int) Math.sqrt(remain);
            if (s * s == remain) {
                System.out.println(2);
                return;
            }
        }

        for (int i = 1; i * i <= N; i++) {
            for (int j = 1; j * j + i * i <= N; j++) {
                int remain = N - i * i - j * j;
                int s = (int) Math.sqrt(remain);
                if (s * s == remain) {
                    System.out.println(3);
                    return;
                }
            }
        }

        System.out.println(4);
    }
}