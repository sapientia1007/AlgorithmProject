import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 전체 사람 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine()); // 관계 개수
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph[parent].add(child);
            graph[child].add(parent); // 양방향 연결
        }

        int result = bfs(from, to, n);
        System.out.println(result);
    }

    static int bfs(int start, int target, int n) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        
        queue.offer(new int[] {start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int person = cur[0], depth = cur[1];

            if (person == target) return depth; // 목표 도달 시 촌수 반환

            for (int next : graph[person]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[] {next, depth + 1});
                }
            }
        }
        return -1; // 관계 없음
    }
}
