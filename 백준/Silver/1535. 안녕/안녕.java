import java.io.*;
import java.util.*;
/*
 * 입력 :
 * 		사람의 수 N
 * 		각 사람으로 인해 잃는 체력
 * 		각 사람으로 인해 얻는 기쁨
 * 	처리 :
 * 		i번에게 인사 -> L[i]만큼 체력 감소/ J[i]만큼 기쁨 증가
 * 		최대 1번 인사가능
 * 출력 : 주어진 체력내에서 최대한의 기쁨 (체력 기본100, 기쁨 0)
 */
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 사람의 수
		int[] Lost = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 체력 소진
		int[] Get = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 기쁨 증가
		
		int[] dp = new int[101];

		for (int i=0; i<N; i++) {
			for (int j=100; j>Lost[i]; j--){
				dp[j] = Math.max(dp[j], dp[j-Lost[i]]+Get[i]);
			}
		}
		System.out.println(dp[100]);
		br.close();
	}
}