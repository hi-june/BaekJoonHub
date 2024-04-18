import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        // number: 기사 단원의 수
        // limit: 공격력 제한 수치
        // power: 초과 시 사용할 공격력 수치
        
        // return: 무기점의 주인이 무기를 모두 만들기 위해 필요한 철의 무게
        
        List<Integer> count = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            count.add(getYackSoo(i));
        }
        
        int total = 0;
        for (int c : count) {
            if (c > limit) {
                total += power;
            } else {
                total += c;
            }
        }
        
        return total;
    }
    
    private static int getYackSoo(int n) {
        if (n == 1) return 1;
        
        int count = 0;
        int sqrt = (int)Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        
        if (n != sqrt * sqrt) {
            return count * 2;
        }
        
        return (count * 2) - 1; // 제곱수인 경우
    }
}