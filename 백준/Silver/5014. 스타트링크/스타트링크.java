import java.util.*;
import java.io.*;

public class Main {
    static boolean[] v;
    static int[] di;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken()); int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken()); int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        v = new boolean[F+1];
        di = new int[] {U, -D};

        bfs(S,F,G,U,D);
        br.close();
    }

    public static void bfs(int current, int top, int target, int up, int down) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[current] = true;
        q.offer(new int[] {current, 0}); // [현재 층, 버튼 누른 횟수]

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int idx = cur[0]; int step = cur[1];

            if (idx == target) {
                System.out.println(step);
                return;
            }

            for (int i=0; i<2; i++) {
                int ii = idx + di[i];
                if (1<=ii && ii<=top && !v[ii]) {
                    v[ii] = true;
                    q.offer(new int[] {ii, step+1});
                }
            }
        }
        System.out.println("use the stairs");
    }
}
