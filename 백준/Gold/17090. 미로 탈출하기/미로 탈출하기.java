import java.io.*;
import java.util.*;


class Main {
    static char[][] arr;
    static boolean[][] v; 
    static int n; static int m;
    static Boolean[][] memo; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        v = new boolean[n][m];
        memo = new Boolean[n][m];

        for (int i=0; i<n; i++) {
            String inpt = br.readLine();
            for (int j=0; j<m; j++) {
                arr[i][j] = inpt.charAt(j);
            }
        }
        
        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (dfs(i, j)) cnt++;
            }
        }
        System.out.println(cnt);

        br.close();
    }

    public static boolean dfs(int y, int x){ 
        boolean result = false;
        if (x < 0 || y < 0 || x >= m || y >= n) return true;

        if (memo[y][x] != null) return memo[y][x]; // 이미 계산한 값 재사용

        if (v[y][x]) return false;

        v[y][x] = true;

        if (arr[y][x] == 'U') result = dfs(y-1, x);
        else if (arr[y][x] == 'R') result = dfs(y, x+1);
        else if (arr[y][x] == 'L') result = dfs(y, x-1);
        else if (arr[y][x] == 'D') result = dfs(y+1, x);

        memo[y][x] = result; 
        v[y][x] = false;
        
        return result;
    }
}