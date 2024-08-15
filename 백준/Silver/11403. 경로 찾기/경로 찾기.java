import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        // 입력
        for (int i=0; i<n; i++){
            String[] inpt = br.readLine().split(" ");
            for (int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(inpt[j]);
            }
        }
        
        // 모든 경로 계산
        for (int k=0; k<n; k++){
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    if (arr[i][k] == 1 && arr[k][j] == 1){
                        arr[i][j]=1;
                    }
                }
            }
        }

        // 출력
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }

        br.close();
    }
}
