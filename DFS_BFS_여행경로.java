import java.util.*;
class Solution {
    String[][] tickets;
    boolean[] isVisited;
    String[] answer;
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        isVisited = new boolean [tickets.length];
        List<String> path = new ArrayList<>();
        
        Arrays.sort(tickets, Comparator.comparing(i -> i[1]));
        
        path.add("ICN");
        dfs("ICN", path);
        return answer;
    }
    public void dfs(String node, List<String> path) {
        // answer이 null이면 그냥 return
        if(answer != null)
            return;
        
        
        if(path.size() == tickets.length + 1) {
            answer = path.toArray(String[]::new);
            return;
        }
        
        // for int i = 0; 티켓 렝뜨
        for(int i = 0; i < tickets.length; i++) {
            
            if(isVisited[i] || !tickets[i][0].equals(node) )
                continue;
            
            path.add(tickets[i][1]);
            isVisited[i] = true;
            
            dfs(tickets[i][1], path);
            
            path.remove(path.size() - 1);
            isVisited[i] = false;
            
            
        }
    }
}
