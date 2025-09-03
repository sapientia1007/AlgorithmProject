import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] g;
    static boolean[] v;
    static int N, M, V;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        V = Integer.parseInt(st.nextToken()); // 탐색 시작 정점 번호

        g = new List[N+1]; v = new boolean[N+1];

        for (int i=0; i<N+1; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            g[from].add(to);
            g[to].add(from);
        }

        for (int i=1; i<N+1; i++) {
            g[i].sort((g1, g2) -> g1-g2);
        }

        dfs(V);
        System.out.println();
        v = new boolean[N+1];
        bfs(V);

    }

    static void dfs(int start) {
        ArrayDeque<Integer> s = new ArrayDeque<>();
        s.push(start);

        while (!s.isEmpty()) {
            int cur = s.pop();

            if (v[cur]) continue;  
            v[cur] = true;
            System.out.print(cur + " ");

            List<Integer> neighbors = g[cur];
            for (int i = neighbors.size()-1; i >= 0; i--) {
                int next = neighbors.get(i);
                if (!v[next]) {
                    s.push(next);
                }
            }
        }
    }

    static void bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        v[start] = true;
        q.offer(start);

        while(!q.isEmpty()) {
            start = q.poll() ;
            System.out.print(start + " ");

            for (int j : g[start]) {
                if (!v[j]) {
                    v[j] = true;
                    q.offer(j);
                }
            }
        }
    }
}