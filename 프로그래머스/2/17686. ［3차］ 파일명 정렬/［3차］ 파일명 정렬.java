import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (f1, f2) -> {
            // 문자열 중간에 연속되는 숫자 인덱스 범위 찾기
            int f1IdxS = 0;
            int f2IdxS = 0;
            while (f1IdxS < f1.length() && !Character.isDigit(f1.charAt(f1IdxS))) f1IdxS++;
            while (f2IdxS < f2.length() && !Character.isDigit(f2.charAt(f2IdxS))) f2IdxS++;
            
            int f1IdxE = f1IdxS;
            int f2IdxE = f2IdxS;
            while (f1IdxE < f1.length() && Character.isDigit(f1.charAt(f1IdxE))) f1IdxE++;
            while (f2IdxE < f2.length() && Character.isDigit(f2.charAt(f2IdxE))) f2IdxE++;
            
            // 정렬을 위한 비교
            String f1Head = f1.substring(0, f1IdxS).toLowerCase();
            int f1Number = Integer.parseInt(f1.substring(f1IdxS, f1IdxE));
            
            String f2Head = f2.substring(0, f2IdxS).toLowerCase();
            int f2Number = Integer.parseInt(f2.substring(f2IdxS, f2IdxE));
            
            if (f1Head.compareTo(f2Head) == 0) {
                return f1Number - f2Number;
            }
            
            return f1Head.compareTo(f2Head);
        });
        
        return files;
    }
}