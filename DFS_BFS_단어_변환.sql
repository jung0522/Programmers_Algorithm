import java.util.*;
class Solution {
    String[] words;
    boolean[] isVisited;
    public int solution(String begin, String target, String[] words) {
        isVisited = new boolean[words.length];
        int answer = bfs(begin, target, words);
        return answer;
    }
    public int bfs(String begin, String target, String[] words) {
        Queue<String[]> q = new LinkedList<>();
        q.offer(new String[]{ begin, "0"});
        // 여기 isVisited true 안 함
        
        while(!q.isEmpty()) {
            String []current = q.poll();
            String curNode = current[0];
            int curLevel = Integer.parseInt(current[1]);
            
            if(curNode.equals(target))
                return curLevel;
            
            for(int i = 0; i < words.length; i++) {
                if(!isVisited[i] && hasChanged(words[i], curNode) ) {
                    isVisited[i] = true;
                    q.offer(new String[]{words[i], String.valueOf(curLevel + 1)});
                }
            }
        }
        return 0;
    }
    public boolean hasChanged(String a, String b) {
        int diff = 0;
        for(int i = 0; i < b.length(); i++) {
            if(a.charAt(i) != b.charAt(i))
                diff++;
            
            if(diff > 1)
                return false;

        }
        return true;
    }
}
