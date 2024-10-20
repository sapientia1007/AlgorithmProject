import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 마법사 수

        int[] diff = new int[N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
            diff[i] = a-b;
        }
        
        Arrays.sort(diff);

        // 중간값
        int midLow = diff[(N-1)/2];
        int midHigh = diff[N/2];

        // 가능한 개수
        int res = midHigh-midLow+1;
        System.out.println(res);

        br.close();
    }
}
