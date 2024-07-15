import java.util.*;
import java.io.*;

class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 큐
            
            // 값이 큰 기준으로 우선순위 큐 생성
            for (int p : priorities){
                pq.offer(p);
            }

            while (!pq.isEmpty()) {
                for (int i=0; i< priorities.length; i++) {
                    if (pq.peek() == priorities[i]){
                        pq.poll();
                        answer ++;

                        if (location == i) return answer;
                    }
                }
            }
            return  answer;
        }
    }