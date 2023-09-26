def solution(price, money, count):
    need = ((price + (price * count)) * count) / 2

    if money - need > 0:
        return 0

    return need - money
    
    


# class Solution {
#     public long solution(int price, int money, int count) {        
#         long need = ((price + (price * count)) * count) / 2;
        
#         if (money - need > 0) {
#             return 0;
#         }
        
#         return need - money;
#     }
# }