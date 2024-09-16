import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int[] arr, pick;
    static boolean[] v;
    static Set<String> res = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inpt = br.readLine().split(" ");
        N = Integer.parseInt(inpt[0]); M = Integer.parseInt(inpt[1]);

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // N개의 자연수 중에서 M개를 고른 수열
        pick = new int[M]; // 선택 배열
        v = new boolean[N]; // 사용 유무 배열

        Arrays.sort(arr); // 순서를 유지하기 위한 정렬
        makeNumber(0,0);

        br.close();
    }

    static void makeNumber(int depth, int start) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<M; i++) {
                sb.append(pick[i]).append(" ");
            }
            if (!res.contains(sb.toString())) {
                System.out.println(sb.toString());
                res.add(sb.toString());
            }
            return;
        }
        for (int i =0; i<N; i++) {
            if (!v[i]) {
                v[i] = true;
                pick[depth] = arr[i];
                makeNumber(depth+1, i+1);
                v[i] = false;
            }
        }
    }
}
