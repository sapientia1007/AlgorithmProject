import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n][n];

        for (int i=0; i<n; i++) {
            String inpt = br.readLine();
            for (int j=0; j<n; j++) {
                arr[i][j] = inpt.charAt(j);
            }
        }

        int max = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {

                // 양옆
                if (j+1 < n) {
                    swap(arr, i, j, i, j+1);
                    max = Math.max(max, check(arr));
                    swap(arr, i, j, i, j+1); // 복구
                }

                // 아래
                if (i+1 < n) {
                    swap(arr, i, j, i+1, j);
                    max = Math.max(max, check(arr));
                    swap(arr, i, j, i+1, j);
                }
            }
        }

        System.out.println(max);
        br.close();

    }

    public static void swap(char[][] arr, int x1, int y1, int x2, int y2) {
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    public static int check(char[][] arr) {
        int n = arr.length;
        int max = 1;

        for (int i=0; i<n; i++) {
            int rowCnt = 1;
            int colCnt = 1;

            for (int j=1; j<n; j++) {
                //  가로
                if (arr[i][j] == arr[i][j-1]) rowCnt++;
                else rowCnt = 1;
                max = Math.max(max, rowCnt);

                // 세로
                if (arr[j][i] == arr[j-1][i]) colCnt++;
                else colCnt = 1;
                max = Math.max(max, colCnt);
            }
        }
        return max;
    }
}