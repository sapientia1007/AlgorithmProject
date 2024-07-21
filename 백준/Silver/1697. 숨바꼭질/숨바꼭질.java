
import java.io.*;
import java.util.*;

public class Main {
    static int A, B;
    static boolean[] v;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken()); // 수빈
        B = Integer.parseInt(st.nextToken()); // 동생
        v = new boolean[100001];
        ArrayDeque<int[]> q = new ArrayDeque<>(); // [현재위치, 이동횟수]

        // 수빈이가 갈 수 있는 장소는 +1/-1/*2
        q.offer(new int[]{A, 0});

        while(!q.isEmpty()){
            int[] current = q.poll();
            int currentPosition = current[0]; int currentStep = current[1];

            if (currentPosition == B) {
                System.out.println(currentStep);
                break;
            }


            // +1로 이동
            int nextPositionPlus = currentPosition+1;
            if (nextPositionPlus <= 100000 && !v[nextPositionPlus]){
                v[nextPositionPlus] = true;
                q.offer(new int[] {nextPositionPlus, currentStep+1});
            }

            // -1로 이동
            int nextPositionMinus = currentPosition-1;
            if (0<=nextPositionMinus && !v[nextPositionMinus]){
                v[nextPositionMinus] = true;
                q.offer(new int[] {nextPositionMinus, currentStep+1});
            }

            // 2배 장소로 이동
            int nextPositionTwice = currentPosition*2;
            if (nextPositionTwice<=100000 && !v[nextPositionTwice]){
                v[nextPositionTwice] = true;
                q.offer(new int[] {nextPositionTwice, currentStep+1});
            }
        }
    }
}
