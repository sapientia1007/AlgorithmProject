import java.util.*;
import java.io.*;

public class Solution {
        public int[] solution(int[] arr) {

            // 스택 생성
            ArrayDeque<Integer> s = new ArrayDeque<>();

            s.add(arr[0]); // 일단 하나 저장

            // arr 배열 내 숫자 중 s의 가장 최근에 들어간 숫자와 같지 않다면 추가
            for (int a : arr) {
                if (s.peekLast() != a) {
                    s.add(a);
                }
            }

            int[] answer = new int[s.size()];

            int idx = 0;
            // 배열 저장
            while(!s.isEmpty()){
                answer[idx++] = s.pop();
            }
            return answer;
        }
    }