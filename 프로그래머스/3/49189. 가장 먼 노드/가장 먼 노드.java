import java.util.*;

class Solution {
        static List<Integer>[] g ;
        public int solution(int n, int[][] edge) {
            int answer = 0;

            // 0번 정점은 없는걸로 생각 -> 인덱스 그대로 사용하기 위해 n+1배열
            g = new List[n+1];
            for (int i=0; i<=n; i++) g[i] = new ArrayList<>();
            for (int i=0; i<edge.length; i++) {
                int from = edge[i][0];
                int to = edge[i][1];
                // 양방향 배열 저장
                g[from].add(to); g[to].add(from);
            }

            // 각 정점에 대한 거리
            int[] distance = new int[n+1];
            Arrays.fill(distance,-1);
            Queue<Integer> q = new LinkedList<>();
            q.offer(1); distance[1] = 0; // 1번 노드 출발

            while (!q.isEmpty()){
                int current = q.poll();
                for (int next : g[current] ) {
                    if (distance[next] == -1) { // 방문한적없는 노드라면
                        distance[next] = distance[current] + 1;
                        q.offer(next);
                    }
                }
            }
            
            int maxDistance = Arrays.stream(distance).max().getAsInt();
            // 이 거리를 가진 경로 찾기
            for (int d: distance) {
                if (d == maxDistance) answer += 1;
            }

            return answer;
        }
    }
