class Solution {
    public int[] solution(long n) {
        String strNum = String.valueOf(n);
        int[] answer = new int[strNum.length()];        
        int idx = 0;
        for (int i = strNum.length()-1; i>=0 ; i--){
            answer[idx++] = (int) (strNum.charAt(i)-'0');
        }
        return answer;
    }
}


