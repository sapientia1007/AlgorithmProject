import java.io.*;
import java.util.*;

class Main {
    static int N, M; 
    static ArrayList<Integer>[] arr ;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) { 
            arr[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b); arr[b].add(a);
        }

        int minUser = -1, minKevinBacon = Integer.MAX_VALUE;

        for (int i=1; i<=N; i++) {
            int kevinBacon = bfs(i);
            if (kevinBacon < minKevinBacon) {
                minKevinBacon = kevinBacon;
                minUser = i;
            }
        }

        System.out.println(minUser);

        br.close();
    }

    public static int bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] distance = new int[N+1];
        boolean[] visited = new boolean[N+1];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int value = queue.poll();

            for (int val : arr[value]) {
                if (!visited[val]) {
                    visited[val] = true;
                    distance[val] = distance[value] + 1;
                    queue.offer(val);
                }
            }
        }
        
        int sum = 0;
        for (int i=1; i<=N; i++) {
            sum += distance[i];
        }
        return sum;
    }
}