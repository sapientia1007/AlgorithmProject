import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 사람의 수

        ArrayList<Integer> line = new ArrayList<>();

        // 배열 저장
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 키가 큰 사람부터 해당 index에 추가
        for (int i=N-1; i>=0; i--) {
            line.add(arr[i], i+1);
        }

        for (int l : line) System.out.print(l+ " ");

        br.close();
    }
}
