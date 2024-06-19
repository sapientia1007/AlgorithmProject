import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine()); // 스위치 수
		int[] sc = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray(); // 스위치 배열
		int T = Integer.parseInt(br.readLine()); // 학생 수


		for (int i = 0; i <T ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int get = Integer.parseInt(st.nextToken());
			if (gender == 1) {
				for (int j=N; j>=get; j--) {
					if (j%get==0) {
						sc[j-1] = sc[j-1] == 0? 1: 0;
					}
				}
			} else {
				sc[get-1] = sc[get-1] ==0?1:0;
				for (int j=1; j<N/2; j++) {
					if (get-j-1 <0 || get+j-1 >= N) break;
					if (sc[get-j-1] == sc[get+j-1]) {sc[get-j-1] = sc[get-j-1]==0?1:0;  sc[get+j-1]= sc[get+j-1]==0?1:0;}
					else break;
					}
			}	
		}
		for (int k=0;k<N;k++) {
			System.out.print(sc[k]+ " ");
			if (((k+1)%20) == 0) System.out.println();
		}
	}
}