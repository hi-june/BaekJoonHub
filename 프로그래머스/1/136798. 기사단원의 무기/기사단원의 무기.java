import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        // number: 기사 단원의 수
        // limit: 공격력 제한 수치
        // power: 초과 시 사용할 공격력 수치
        
        // return: 무기점의 주인이 무기를 모두 만들기 위해 필요한 철의 무게
        
        // 약수의 갯수를 구하는 법 == 1 부터 n까지 각 숫자마다 가능한 배수를 증가시키는 방법
        int[] count = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            for (int j = 1; i * j <= number; j++) {
                count[i * j]++;
            }
        }
        
        int total = 0;
        for (int i = 1; i < count.length; i++) {
            int c = count[i];
            
            if (c > limit) {
                total += power;
            } else {
                total += c;
            }
        }
        
        return total;
    }
}