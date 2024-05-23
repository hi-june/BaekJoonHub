class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        
        for (String ss : s.split("")) {
            if (ss.equals(" ")) {
                flag = true;
                sb.append(ss);
            } else {
                if (flag) {
                    sb.append(ss.toUpperCase());
                    flag = false;
                } else {
                    sb.append(ss.toLowerCase());
                }
            }
        }
        
        return sb.toString();
    }
}