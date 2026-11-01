package Hard;

public class CouplesHoldingHands {
    public int minSwapsCouples(int[] row) {
        int[] position = new int[row.length];
        var result = 0;

        for (int i = 0; i < row.length; i++) {
            position[row[i]] = i;
        }

        for (int i = 1; i < row.length; i+= 2) {
            int first = row[i-1];
            int second = row[i];
            int partner = first^1;

            if (second != partner) {
                int partnerIndex = position[partner];

                row[i] = partner;
                row[partnerIndex] = second;

                position[partner] = i;
                position[second] = partnerIndex;

                result++;
            }
        }

        return result;
    }
}

class TestCouplesHoldingHands {
    static void main(String[] args) {
        CouplesHoldingHands test = new CouplesHoldingHands();

        int[][] cases = {
                {0,2,1,3}, {3,2,0,1}
        };

        for (var c : cases) {
            var result = test.minSwapsCouples(c);
            System.out.println(result);
        }
    }
}