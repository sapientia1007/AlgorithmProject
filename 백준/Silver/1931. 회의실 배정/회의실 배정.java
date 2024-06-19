import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int[][] room = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			room[i][0] = Integer.parseInt(st.nextToken());
			room[i][1] = Integer.parseInt(st.nextToken());
		}
        Arrays.sort(room, (a1, a2) -> a1[1] == a2[1] ? a1[0] - a2[0] : a1[1] - a2[1]);
        
       
        int end = -1;

        for(int i = 0; i < N; i++) {
            if(room[i][0] >= end) {
                end = room[i][1];
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }
}
