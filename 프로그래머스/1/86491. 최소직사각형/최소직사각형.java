class Solution {
        public int solution(int[][] sizes) {
            int answer = 0;

            int MaxWidth = 0; int MaxHeight = 0;

            for (int[] size : sizes){
                int maxVal = Math.max(size[0],size[1]); // 큰값끼리 비교하기 위함
                int minVal = Math.min(size[0], size[1]); // 작은값끼리 비교하기 위함
                MaxWidth = Math.max(maxVal, MaxWidth);
                MaxHeight = Math.max(minVal, MaxHeight);
            }

            answer = MaxWidth*MaxHeight;
            return answer;
        }
    }