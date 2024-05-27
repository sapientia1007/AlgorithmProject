class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pcnt = 0 ; int ycnt = 0;

        String[] array = s.toLowerCase().split("");
        
        for (int i = 0 ; i < array.length ; i++) {
            if ("p".equals(array[i])){
                pcnt++;
            } else if ("y".equals(array[i])) {
                ycnt++;
            }
        }
        if (pcnt != ycnt) {
            answer =  false;
        }
        
        return answer;
    }
}