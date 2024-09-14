import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inpt = br.readLine().split(" ");
        int N = Integer.parseInt(inpt[0]); int L = Integer.parseInt(inpt[1]);
        int W = Integer.parseInt(inpt[2]); int H = Integer.parseInt(inpt[3]);
        // A x A x A 크기의 N개의 박스를 L x W x H 크기의 박스에 넣기
        double left = 1; double right = Math.min(L, Math.min(W, H));
        double answer = 0;

        for (int i=0; i<100; i++){
            double mid = (left + right) / 2;
            // 이 mid가 fullBox 안에 N개가 들어가나 확인
            long cnt = (long)(L/mid) * (long)(W/mid) * (long)(H/mid);
            if (cnt >= N) {
                // 가능
                answer = mid;
                left = mid + 1; // 더 큰 값 확인
            }
            else {
                // 불가능하므로 더 작은값 확인
                right = mid -1;
            }
        }
        System.out.println(answer);

        br.close();
    }
}
