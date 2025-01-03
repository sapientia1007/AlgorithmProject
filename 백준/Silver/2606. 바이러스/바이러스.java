import java.io.*;
import java.util.*;

public class Main {
    static boolean[] v;
    static ArrayList<Integer>[] network;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수

        network = new ArrayList[N + 1];
        v = new boolean [N+1];

        int M = Integer.parseInt(br.readLine()); // 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수

        for (int i=1; i<=N; i++){
            network[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fisrt = Integer.parseInt(st.nextToken()); int second = Integer.parseInt(st.nextToken());
            network[fisrt].add(second); network[second].add(fisrt);
        }

        int cnt = dfs(1);
        System.out.println(cnt);
        br.close();
    }

    public static int dfs(int index) {
        ArrayDeque<Integer> s = new ArrayDeque<>();
        s.add(index);
        v[index] = true;
        int count = 0;

        while (!s.isEmpty()){
            int currnet = s.poll();

            for (int neighbor: network[currnet]) {
                if (!v[neighbor]) {
                    v[neighbor] = true;
                    s.add(neighbor);
                    count++;
                }
            }
        }
        return count;
    }
}
