import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> phoneSet = new HashSet<>();
        
        for (int i = 0; i < phone_book.length; i++) {
            phoneSet.add(phone_book[i]);
        }
        
        for (String phoneNum : phone_book) {
            for (int j = 0; j < phoneNum.length(); j++) {
                if (phoneSet.contains(phoneNum.substring(0, j))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}