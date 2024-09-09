import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inpt = br.readLine(); // 입력 식
        ArrayList<Integer> numbers = new ArrayList<>(); // 숫자 리스트
        ArrayList<Character> giho = new ArrayList<>(); // 기호 리스트

        StringBuilder n = new StringBuilder() ;
        for (int i=0; i<=inpt.length(); i++) {
            if (i == inpt.length() || inpt.charAt(i) == '+' || inpt.charAt(i) == '-' ) {
                numbers.add(Integer.parseInt(n.toString()));
                if (i < inpt.length()) giho.add(inpt.charAt(i));
                n = new StringBuilder();
            } else {
                n.append(inpt.charAt(i));
            }
        }
        
        int res = numbers.get(0);
        int idx = 1;

        // 기호의 idx -> 숫자 idx, idx+1
        for (int i = 0; i < giho.size(); i++) {
            if (giho.get(i) == '-') { // '-' 기호를 만나면 그 이후로는 모두 빼기
                for (int j = idx; j < numbers.size(); j++) {
                    res -= numbers.get(j);
                }
                break;
            } else { // '+' 기호일 경우 덧셈
                res += numbers.get(idx);
                idx++;
            }
        }

        System.out.println(res);

        br.close();
    }
}
