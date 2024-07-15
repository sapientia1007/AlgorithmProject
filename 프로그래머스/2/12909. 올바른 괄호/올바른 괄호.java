import java.io.*;
import java.util.*;

class Solution {
	    boolean solution(String s) throws IOException {
	        boolean answer = true;

	        ArrayDeque<Character> q = new ArrayDeque<>();
	        
	        for (int i=0; i<s.length(); i++) {
	        	char inpt = s.charAt(i);
	        	
	        	if (q.isEmpty()) {
	        		q.offer(inpt);
	        	} else if (inpt == ')' && q.peekLast() == '(') {
	        		q.pollLast();
	        	} else if (inpt == ')' && q.isEmpty()) {
	        		answer = false;
	        		break;
	        	} else if (inpt == '('){
	        		q.offer(inpt);
	        	}
	        }
	        if (q.size() != 0) answer = false;
	        return answer;
	    }
	}