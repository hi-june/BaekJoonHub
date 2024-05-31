import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (f1, f2) -> {
            int f1IdxS = 0;
            for (int i = 0; i < f1.length(); i++) {
                if (Character.isDigit(f1.charAt(i))) {
                    f1IdxS = i;
                    break;
                }
            }
            int f1IdxE = f1.length();
            for (int i = f1IdxS + 1; i < f1.length(); i++) {
                if (!Character.isDigit(f1.charAt(i))) {
                    f1IdxE = i;
                    break;
                }
                
                if (i == f1IdxS + 5) {
                    f1IdxE = i;
                    break;
                }
            }
            
            int f2IdxS = 0;
            for (int i = 0; i < f2.length(); i++) {
                if (Character.isDigit(f2.charAt(i))) {
                    f2IdxS = i;
                    break;
                }
            }
            int f2IdxE = f2.length();
            for (int i = f2IdxS + 1; i < f2.length(); i++) {
                if (!Character.isDigit(f2.charAt(i))) {
                    f2IdxE = i;
                    break;
                }
                
                if (i == f2IdxS + 5) {
                    f2IdxE = i;
                    break;
                }
            }
            
            String f1Head = f1.substring(0, f1IdxS).toLowerCase();
            int f1Number = Integer.parseInt(f1.substring(f1IdxS, f1IdxE));
            // String f1Tail = f1.substring(f1IdxE);
            
            String f2Head = f2.substring(0, f2IdxS).toLowerCase();
            int f2Number = Integer.parseInt(f2.substring(f2IdxS, f2IdxE));
            // String f2Tail = f2.substring(f2IdxE);
            
            if (f1Head.compareTo(f2Head) == 0) {
                return f1Number - f2Number;
            }
            
            return f1Head.compareTo(f2Head);
        });
        
        return files;
    }
}