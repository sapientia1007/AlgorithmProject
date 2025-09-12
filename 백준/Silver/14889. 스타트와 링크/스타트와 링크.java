import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); 
        arr = new int[N][N]; visited = new boolean[N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0] = true;
        divideTeam(1, 1);
        System.out.println(minDifference);
    }

    static void divideTeam(int person, int count) {
        if (count == N/2) {
            calculateDifference();
            return;
        }

        for (int i=person; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                divideTeam(i+1, count+1);
                visited[i] = false;
            }
        }
    }

    static void calculateDifference() {
        int startTeamScore = 0; int linkTeamScore = 0;

        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                if (visited[i] && visited[j]){
                    startTeamScore += arr[i][j] + arr[j][i];
                }
                else if (!visited[i] && !visited[j]) {
                    linkTeamScore += arr[i][j] + arr[j][i];
                }
            }
        }

        int difference = Math.abs(startTeamScore - linkTeamScore);
        if (difference == 0) { 
            System.out.println(0);
            System.exit(0);
        }
        minDifference = Math.min(difference, minDifference);
    }
}