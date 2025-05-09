import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken()); long B = Long.parseLong(st.nextToken());

        ArrayDeque<long[]> q = new ArrayDeque<>();
        q.add(new long[] {A, 1});

        while (!q.isEmpty()) {
            long[] current = q.poll();
            long num = current[0];
            long cnt = current[1];

            if (num == B) {
                System.out.println(cnt);
                return;
            }

            if (num * 2 <= B){
                q.add(new long[] {num*2, cnt+1});
            }

            if (num * 10 + 1 <= B) {
                q.add(new long[] {num*10+1, cnt+1});
            }
        }
        System.out.println(-1);
    }
}