class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int minLength = Integer.MAX_VALUE;
        int[] answer = new int [2];
        
        while(right < sequence.length) {
            if(sum == k) {
                // 길이는 오른쪽 - 왼쪽 + 1
                int length = right - left + 1;
                if(length < minLength) {
                    minLength = length;
                    answer[0] = left;
                    answer[1] = right;
                } 
                // sum - 시퀀스
                sum -= sequence[left];
                left++;
            } else if( sum < k) {
                // 반대로
                right++;
                // 라이트 시퀀스보다 작다 한 번 더 나옴
                if(right < sequence.length)
                     sum += sequence[right];
            } else {
                sum -= sequence[left];
                left++;
            }
        }
        return answer;
    }
}
