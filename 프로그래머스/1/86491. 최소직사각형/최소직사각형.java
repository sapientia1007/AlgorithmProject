class Solution {
        public int solution(int[][] sizes) {
            int answer = 0;

            int[][] resSizes = new int[sizes.length][2];

            // 배열 정렬
            for (int i=0 ; i<sizes.length; i++) {
                if (sizes[i][0] >= sizes[i][1]) {
                    resSizes[i][0] = sizes[i][0];
                    resSizes[i][1] = sizes[i][1];
                } else {
                    resSizes[i][0] = sizes[i][1];
                    resSizes[i][1] = sizes[i][0];
                }
            }
            
            int max = Integer.MIN_VALUE; int max2 = Integer.MIN_VALUE;
            for (int i=0 ; i<resSizes.length; i++) {
                if (max < resSizes[i][0]) {
                    max = resSizes[i][0];
                }
                if (max2 < resSizes[i][1]) {
                    max2 = resSizes[i][1];
                }
            }

            answer = max*max2;
            return answer;
        }
    }