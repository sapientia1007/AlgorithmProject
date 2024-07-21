import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[][] arr ;
    static int[][] res;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[N][M]; // 입력 배열
        res = new int[N][M]; // 결과 배열
        int cnt = 0 ; // 결과값(횟수)
        for (int i=0; i<N; i++){
            String[] nums = br.readLine().split("");
            for (int j=0; j<M;j++){
                arr[i][j] = Integer.parseInt(nums[j]);
            }
        }
        for (int i=0; i<N; i++){
            String[] nums = br.readLine().split("");
            for (int j=0; j<M;j++){
                res[i][j] = Integer.parseInt(nums[j]);
            }
        }

        // 처리 : 3x3 부분 행렬 원소 뒤집기
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                // 둘의 값이 같지 않을때 3x3 행렬 크기로 뒤집어보기
                if (arr[i][j] != res[i][j] && i+2<N && j+2<M){
                    for (int r=i; r<i+3; r++){
                        for (int c=j; c<j+3; c++){
                            arr[r][c] = arr[r][c] ==0 ? 1: 0;
                        }
                    }
                    cnt ++;
                }
            }
        }

        // 같아지지 않으면 -1 출력
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (arr[i][j] != res[i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(cnt);
    }
}
