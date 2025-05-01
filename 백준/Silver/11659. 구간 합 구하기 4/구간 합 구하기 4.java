import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 합을 구해야는 횟수

        int[] arr = new int[N];
        int[] sumArr = new int[N+1];
        String[] inpt = br.readLine().split(" ");
        for (int i=0; i<N; i++) arr[i] = Integer.parseInt(inpt[i]);
        sumArr[0] = arr[0];
        for (int i=1; i<=N; i++) sumArr[i] = sumArr[i-1] + arr[i-1];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(sumArr[end] - sumArr[start - 1]);
        }
        br.close();
    }
}