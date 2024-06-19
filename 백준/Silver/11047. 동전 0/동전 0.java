import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int[] arr = new int[N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=N-1; i>=0; i--){
            if (arr[i] <=K) cnt+=(K/arr[i]);
            K = K%arr[i];
        }
        System.out.println(cnt);
    }
}