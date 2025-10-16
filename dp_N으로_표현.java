import java.util.*;
class Solution {
    public int solution(int N, int number) {
        if(N == number)
            return 1;
        
        // 숫자 조합은 Set
        List<Set<Integer>> dp = new ArrayList<>();
        // 8까지
        for(int i = 0; i < 8; i++) {
            dp.add(new HashSet<>());
        }
        
        // 똑같이 시작
        for(int i = 0; i < 8; i++) {
            // 반복 (repeated는 N을 이어붙인 숫자 (5, 55, 555 등)를 의미)
            int repeated = 0;
            // j부터 i포함 까지
            for(int j = 0; j <= i; j++) {
                repeated = repeated * 10 + N;
                // add랑 contaions는 건 무조건 i야
                dp.get(i).add(repeated);
            }
            // 이전 조합이므로 i 포함 x
            for(int j = 0; j < i; j++) {
                for(int a : dp.get(j)) {
                    for(int b : dp.get(i - j - 1)) {
                        dp.get(i).add(a+b);
                        dp.get(i).add(a-b);
                        dp.get(i).add(a*b);
                        if(b != 0)
                            dp.get(i).add(a/b);
                        
                    }
                }
            }
            if(dp.get(i).contains(number))
                return i + 1;
                  
    }
        return -1;
 }
}
