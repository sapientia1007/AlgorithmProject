import java.io.*;
import java.util.*;

/*
* 입력 : 1. n=계단의 개수
*       2. 둘째줄 ~ : 계단 점수 (윗줄일수록 아래 계단)
*
* 과정 : 한 번에 한 계단씩 or 두 계단씩
*       연속된 세 개의 계단 모두 밟기 불가
*       arr[n-1] = 도착지점 = 꼭 방문해야함
*
* 출력 : 계단 최대 점수
*/

public class Main {
    public static void main(String[] args) throws Exception {
        int[] arr ;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); arr = new int[n+1];

        // 계단 점수 입력
        for (int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n+1]; // 각 계단까지의 최대 점수를 저장할 배열
        dp[0] = arr[0]; dp[1] = arr[1]; // 초기화 (첫번째 계단의 최대 점수 = 첫번째 점수)

        if (n>=2) dp[2] = arr[1] + arr[2]; // 두번째 계단의 최대 점수 = 첫 번째 계단 점수 + 두 번째 계단 점수

        for (int i=3; i<=n; i++){
            dp[i] = Math.max(dp[i-3] + arr[i-1], dp[i-2]) + arr[i]; // 세 계단 전의 최대 점수 + 전 계단 점수 + 현재 계단 점수 or 두 계단 전의 점수 + 현재 계단 점수 
        }

        System.out.println(dp[n]);
        br.close();
    }
}
