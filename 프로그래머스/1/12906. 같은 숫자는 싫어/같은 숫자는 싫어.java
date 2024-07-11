import java.util.*;
import java.io.*;

public class Solution {
	    public int[] solution(int[] arr) {
	      
	        // 큐 생성
	        ArrayDeque<Integer> q = new ArrayDeque<>();
	        
	        q.add(arr[0]); // 일단 하나 저장
	        
	        // arr 배열 내 숫자 중 q의 가장 최근에 들어간 숫자와 같지 않다면 추가
	        for (int a : arr) {
	        	if (q.peekLast() != a) {
					q.offer(a);
				}
	        }

	       	int[] answer = new int[q.size()]; 
	       
			int idx = 0;
	       // 배열 저장
			while(!q.isEmpty()){
				answer[idx++] = q.poll();
			}
	        return answer;
	    }
	}
	