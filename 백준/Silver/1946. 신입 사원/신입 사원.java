import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 갯수
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 지원자 수
            int[][] apply = new int[N][2];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int score1 = Integer.parseInt(st.nextToken());
                int score2 = Integer.parseInt(st.nextToken());

                apply[j][0] = score1;
                apply[j][1] = score2;
            }
            Arrays.sort(apply, Comparator.comparingInt(a -> a[0]));

            int count = 1;
            int minScore = apply[0][1];

            for (int j=1; j<N; j++) {
                if (apply[j][1] < minScore) {
                    count ++;
                    minScore = apply[j][1];
                }
            }
            System.out.println(count);
        }
        br.close();
    }
}
