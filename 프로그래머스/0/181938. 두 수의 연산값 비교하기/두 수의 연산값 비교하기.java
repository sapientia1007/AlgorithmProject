class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String first = String.valueOf(a);
        first += b;
        
        int second = 2 * a * b;
        
        if (Integer.parseInt(first) > second) {
            answer = Integer.parseInt(first);
        } else {
            answer = second;
        }
        return answer;
    }
}