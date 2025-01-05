import java.io.*;
import java.util.*;

public class Main {
    static boolean[] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = new boolean[100_001];

        int N = Integer.parseInt(st.nextToken()); int K = Integer.parseInt(st.nextToken());

        int result = bfs(N, K);
        System.out.println(result);
        br.close();
    }

    public static int bfs(int start, int target) {
        ArrayDeque<int[]> q = new ArrayDeque<>(); // [위치, 경과 시간]
        q.add(new int[]{start, 0});
        v[start] = true;

        while (!q.isEmpty()){
            int[] current = q.poll();
            int position = current[0];
            int time = current[1];

            if (position == target) return time;

            if (position-1 >= 0 && !v[position-1]) {
                q.add(new int[] {position-1, time+1});
                v[position-1] = true;
            }
            if (position+1 <= 100_000&& !v[position+1]) {
                q.add(new int[] {position+1, time+1});
                v[position+1] = true;
            }
            if (position*2 >= 0 &&  position*2 <= 100_000 && !v[position*2]) {
                q.add(new int[] {position*2, time+1});
                v[position*2] = true;
            }
        }
        return -1;
    }
}
