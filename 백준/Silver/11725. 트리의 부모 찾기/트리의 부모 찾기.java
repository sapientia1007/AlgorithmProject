import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] parent; // 부모배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st ; 

        graph = new ArrayList[N+1];
        visited = new boolean[N+1]; 
        parent = new int[N+1];

        for (int i=1; i<=N; i++) graph[i] = new ArrayList<>();

        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        bfs(1); // 루트 1부터 탐색 시작
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) { // 2번 노드부터
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    static void bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = cur;
                    q.offer(next);
                }
            }
        }
    }
}