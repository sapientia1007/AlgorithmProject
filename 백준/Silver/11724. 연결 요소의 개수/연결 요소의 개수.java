import java.io.*;
import java.util.*;

public class Main {
    static int N ; static int M;
    static ArrayList<Integer>[] graph;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        v = new boolean[N+1];

        for (int i=0; i<N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()); int v = Integer.parseInt(st.nextToken());

            graph[u].add(v); graph[v].add(u);
        }

        int cnt = 0;
        for (int i=1; i<=N; i++) {
            if (!v[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
        br.close();

    }

    static void dfs(int index){
        ArrayDeque<Integer> s = new ArrayDeque<>();
        s.add(index);
        v[index]=true;

        while (!s.isEmpty()) {
            int current = s.poll();

            for (int neighbor : graph[current]) {
                if (!v[neighbor]){
                    s.add(neighbor);
                    v[neighbor]=true;
                }
            }
        }
    }
}
