class Solution {
    public long solution(int price, int money, int count) {        
        long first = price;
        long last = (long)price * count;
        
        
        long need = ((first + last) * count) / 2;
        
        
        return Math.max(need - (long)money, 0);
    }
}