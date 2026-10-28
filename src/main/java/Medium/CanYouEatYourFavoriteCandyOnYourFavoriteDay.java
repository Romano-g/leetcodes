package Medium;

import java.util.Arrays;

public class CanYouEatYourFavoriteCandyOnYourFavoriteDay {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] result = new boolean[queries.length];
        long[] pfxSum = new long[candiesCount.length];
        pfxSum[0] = candiesCount[0];

        for (int i = 1; i < candiesCount.length; i++) {
            pfxSum[i] = pfxSum[i - 1] + candiesCount[i];
        }

        for (int j = 0; j < queries.length; j++) {
            int favoriteType = queries[j][0];
            long favoriteDay = queries[j][1];
            long dailyCap = queries[j][2];
            long candiesBefore = favoriteType == 0 ? 0 : pfxSum[favoriteType - 1];
            long minCandies = favoriteDay + 1;

            long totalCap = Math.min((favoriteDay + 1) * dailyCap, pfxSum[pfxSum.length - 1]);

            if (totalCap > candiesBefore && minCandies <= pfxSum[favoriteType]) {
                result[j] = true;
                continue;
            }

            result[j] = false;
        }

        return result;
    }
}

class TestCanYouEatYourFavoriteCandyOnYourFavoriteDay {
    static void main(String[] args) {
        CanYouEatYourFavoriteCandyOnYourFavoriteDay test = new CanYouEatYourFavoriteCandyOnYourFavoriteDay();

        Object[][] cases = {
                {new int[]{7,4,5,3,8}, new int[][]{{0,2,2}, {4,2,4}, {2,13,1000000000}}},
                {new int[]{5,2,6,4,1}, new int[][]{{3,1,2}, {4,10,3}, {3,10,100}, {4,100,30}, {1,3,1}}}
        };

        for (var c : cases) {
            var  result = test.canEat((int[]) c[0], (int[][]) c[1]);
            System.out.println(Arrays.toString(result));
        }
    }
}