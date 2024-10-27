import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine()); // 약수 개수

        int[] numbers = Arrays.stream(Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer :: parseInt)
                .toArray()).sorted().toArray();

        if (N%2 == 0) {
            answer = numbers[0] * numbers[numbers.length-1];
        } else {
            answer = numbers[numbers.length/2] * numbers[numbers.length/2];
        }

        System.out.println(answer);
        br.close();
    }
}
