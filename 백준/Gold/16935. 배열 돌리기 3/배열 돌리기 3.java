
import java.io.*;
import java.util.*;

public class Main {
    // 수정 필요
    static int N, M, R, C;
    static int[][] arr ;
    static int[][] newArr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 배열의 크기
        M = Integer.parseInt(st.nextToken()); // 배열의 크기
        R = Integer.parseInt(st.nextToken()); // 수행해야하는 연산의 수

        arr = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()); // 배열 저장
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int j=0; j<R; j++) {
            C = Integer.parseInt(st.nextToken());
            switch (C) {
                case 1:
                    one();
                    break;
                case 2:
                    two();
                    break;
                case 3:
                    three();
                    break;
                case 4:
                    four();
                    break;
                case 5:
                    five();
                    break;
                case 6:
                    six();
                    break;
            }
        }
        // 결과 출력
        for (int k=0; k<N; k++) {
            for (int m=0; m<M; m++) {
                System.out.print(arr[k][m]+" ");
            }
            System.out.println();
        }


    }
    public static void one() {
        newArr = new int[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                newArr[N-i-1][j] = arr[i][j];
            }
        }
        arr = newArr;
    }

    public static void two() {
        newArr = new int[N][M];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                newArr[i][M-j-1] = arr[i][j];
            }
        }
        arr = newArr;
    }

    public static void three() {
        newArr = new int[M][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                newArr[j][N-i-1] = arr[i][j];
            }
        }
        int tmp = N; N = M; M = tmp;
        arr = newArr;
    }

    public static void four() {
        newArr = new int[M][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                newArr[M-j-1][i] = arr[i][j];
            }
        }
        int tmp = M; M = N; N = tmp;
        arr = newArr;
    }

    public static void five() {
        newArr = new int[N][M];
        // 작은 배열 생성
        for (int i=0; i<N/2; i++) {
            for (int j=0; j<M/2; j++) {
                newArr[i][M/2+j] = arr[i][j];
            }
        }
        for (int i=0; i<N/2; i++) {
            for (int j=M/2; j<M; j++) {
                newArr[N/2+i][j] = arr[i][j];
            }
        }
        for (int i=N/2; i<N; i++) {
            for (int j=M/2; j<M; j++) {
                newArr[i][j-M/2] = arr[i][j];
            }
        }
        for (int i=N/2; i<N; i++) {
            for (int j=0; j<M/2; j++) {
                newArr[i-N/2][j] = arr[i][j];
            }
        }
        arr = newArr;
    }

    public static void six() {
        newArr = new int[N][M];
        // 작은 배열 생성
        for (int i=0; i<N/2; i++) {
            for (int j=0; j<M/2; j++) {
                newArr[i+N/2][j] = arr[i][j];
            }
        }
        for (int i=N/2; i<N; i++) {
            for (int j=M/2; j<M; j++) {
                newArr[i-N/2][j] = arr[i][j];
            }
        }
        for (int i=N/2; i<N; i++) {
            for (int j=0; j<M/2; j++) {
                newArr[i][M/2+j] = arr[i][j];
            }
        }
        for (int i=0; i<N/2; i++) {
            for (int j=M/2; j<M; j++) {
                newArr[i][j-M/2] = arr[i][j];
            }
        }
        arr = newArr;
    }
}
