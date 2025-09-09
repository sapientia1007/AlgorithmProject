import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 비교 횟수

        // 진입 차수 배열 (앞에 서야 하는 학생 수)
        int[] indegree = new int[N + 1];
        // 인접 리스트 
        List<List<Integer>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        // 비교 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            indegree[B]++; // B 앞에 서야 하는 학생 수 증가
        }

        // 위상 정렬 
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new ArrayDeque<>();

        // 앞에 설 필요 없는 학생들 먼저 큐에 추가
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            // 현재 학생 뒤에 서야 하는 학생들 확인
            for (int next : graph.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) q.add(next);
            }
        }

        // 결과 출력
        System.out.print(sb);
    }
}
