import java.util.*;

// 조합 응용
class Solution {
    private int[] discount = {40, 30, 20, 10};
    private int[] picked;
    private int[] acc;
    private int signUp, amount;

    public int[] solution(int[][] users, int[] emoticons) {
        acc = new int[users.length];
        picked = new int[emoticons.length];

        dfs(users, emoticons, 0);

        return new int[]{signUp, amount};
    }

    private void dfs(int[][] users, int[] emoticons, int depth) {
        if (depth == picked.length) {
            for (int i = 0; i < emoticons.length; i++) {
                int price = emoticons[i] - ((emoticons[i] * picked[i]) / 100);

                for (int j = 0; j < users.length; j++) {
                    if (users[j][0] <= picked[i]) {
                        acc[j] += price;
                    }
                }
            }

            int signTmp = 0;
            int amountTmp = 0;
            for (int i = 0; i < acc.length; i++) {
                if (users[i][1] <= acc[i]) {
                    signTmp++;
                } else {
                    amountTmp += acc[i];
                }
            }

            if (signTmp > signUp) {
                signUp = signTmp;
                amount = amountTmp;
            } else if (signTmp == signUp) {
                amount = Math.max(amount, amountTmp);
            }

            acc = new int[users.length];
            return;
        }

        for (int i = 0; i < discount.length; i++) {
            picked[depth] = discount[i];
            dfs(users, emoticons, depth + 1);
        }
    }
}