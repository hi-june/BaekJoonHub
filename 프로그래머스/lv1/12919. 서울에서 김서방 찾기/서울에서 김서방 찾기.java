import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] seoul) {
        List<String> seoulList = Arrays.asList(seoul);
        
        int idx = seoulList.indexOf("Kim");
        
        return String.format("김서방은 %d에 있다", idx);
    }
}