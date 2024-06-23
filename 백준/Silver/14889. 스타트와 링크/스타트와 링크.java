import java.util.*;
import java.io.*;

public class Main {
    static int n; static int start; static int link;
    static int MIN = Integer.MAX_VALUE;
    static int[][] arr; static boolean[] check;

    static void comb(int cnt, int start){
        if (cnt == n/2) {
            MIN = Math.min(MIN, getRes());
            return;
        }
        for (int i=start; i<n; i++){
            check[i] = true;
            comb(cnt+1, i+1);
            check[i] =false;
        }
    }

    static int getRes() {
        int start = 0; int link = 0;

        for(int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (i==j) continue;

                if (check[i] && check[j]) start += arr[i][j];
                if (!check[i] && !check[j]) link+=arr[i][j];
            }
        }
        return  Math.abs(start-link);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        comb(0,0);
        System.out.println(MIN);
        br.close();
        }
    }
