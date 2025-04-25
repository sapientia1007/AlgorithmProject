import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001]; 
        int start = 0; int end = 0;
        int maxLength = 0;

        while (end < N) {
            if (count[arr[end]] < K) {
                count[arr[end]]++;
                end++;
                maxLength = Math.max(maxLength, end-start);
            } else {
                count[arr[start]]--;
                start++;
            }
        }
        
        System.out.println(maxLength);

        br.close();
    }
}