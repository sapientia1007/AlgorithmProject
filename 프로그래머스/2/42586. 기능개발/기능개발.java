import java.io.*;
import java.util.*;
class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer = {};

            ArrayList<Integer> answerLst = new ArrayList<>();
            ArrayDeque<Integer> q = new ArrayDeque<>();

            // 남은 일수 계산 - 속도로 몇일나오는지 계산
            for (int i=0; i<progresses.length; i++) {
                int day = 0;
                if ((100-progresses[i])%speeds[i] == 0) {
                    day = (100-progresses[i])/speeds[i];
                }
                else {
                    day = (100-progresses[i])/speeds[i] + 1;
                }
                q.offer(day);
            }

            int cnt = 1;
            int num = q.pollFirst(); // 일단 첫번째 값 기준 정하기 위해 q에서 빼기

            // 앞에 있는 기능보다 뒤에 있는 기능이 먼저 개발되더라도, 뒤에 있는 기능은 앞에 있는 기능이 배포될때 함께 => 비교
            while (true) {
                if (q.isEmpty()) break;
                if (num>=q.peekFirst()) {
                    q.pollFirst();
                    cnt +=1 ;
                } else if (q.peekFirst()>num){
                    answerLst.add(cnt);
                    num = q.pollFirst();
                    cnt=1;
                }
            }
            answerLst.add(cnt);

            answer = new int[answerLst.size()];
            for (int i=0; i<answerLst.size(); i++) {
                answer[i] = answerLst.get(i);
            }
            return answer;
        }
    }