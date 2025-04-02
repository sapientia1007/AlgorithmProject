import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); 
        
        int[] tree = new int[N]; int answer = 0; 

        st = new StringTokenizer(br.readLine());

        int maxHeight = 0; 
        int minHeight = 0;

        for (int i=0; i<N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, tree[i]);
        }

        while (minHeight <= maxHeight) {
            int midHeight = minHeight + (maxHeight - minHeight) / 2;
            long res = 0;
            for (int i : tree) {
                if (i > midHeight) res += (i-midHeight);
            }

            if (res >= M) {
                answer = midHeight;
                minHeight = midHeight + 1;
            } else {
                maxHeight = midHeight - 1;
            }
        }

        System.out.println(answer);
        br.close();
    }
}