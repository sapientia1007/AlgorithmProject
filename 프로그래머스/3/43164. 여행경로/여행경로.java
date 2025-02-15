import java.util.*;

class Solution {
    private boolean[] visited;
    private ArrayList<String> routes;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        routes = new ArrayList<>();

        // DFS 탐색 시작 : ICN 출발
        dfs("ICN", "ICN", tickets, 0);

        // 가능한 경로를 사전순으로 정렬
        Collections.sort(routes);

        // 사전순으로 가장 앞서는 경로를 선택하여 반환
        return routes.get(0).split(" ");
    }

    private void dfs(String current, String path, String[][] tickets, int count) {
        // 모든 항공권을 사용한 경우 경로를 저장하고 종료
        if (count == tickets.length) {
            routes.add(path);
            return;
        }

        // 모든 항공권을 순회하며 다음 경로 탐색
        for (int i = 0; i < tickets.length; i++) {
            // 현재 공항에서 출발하는 항공권이고, 아직 사용하지 않은 경우
            if (current.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true; 
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, count + 1); 
                visited[i] = false;
            }
        }
    }
}
