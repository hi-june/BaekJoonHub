import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> tmp = new ArrayList<>();
        
        for (String r : record) {
            String[] line = r.split(" ");
            String cmd = line[0];
            
            switch (cmd) {
                case "Enter": {
                    String uid = line[1];
                    String nickName = line[2];
                    
                    map.put(uid, nickName);
                    tmp.add(String.format("*%s 님이 들어왔습니다.", uid));
                    break;
                }
                case "Leave": {  
                    String uid = line[1];
                    
                    tmp.add(String.format("*%s 님이 나갔습니다.", uid));
                    break;
                }
                case "Change": {
                    String uid = line[1];
                    String nickName = line[2];
                    
                    map.put(uid, nickName);
                    break;
                }
            }
        }
        
        String[] answer = new String[tmp.size()];
        for (int i = 0; i < answer.length; i++) {
            String origin = tmp.get(i);
            String uid = origin.split(" ")[0];
            
            String replace = origin.replace(uid + " ", map.get(uid.substring(1)));
            answer[i] = replace;
        }
        
        return answer;
    }
}