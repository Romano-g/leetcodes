package Medium;

public class SmallestAllOnesMultiple {
    public int minAllOneMultiple(int k) {
        var result = 1;
        var base = 1 % k;

        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }

        for (int i = 1; i < k; i++) {
            if (base == 0) {
                break;
            }

            base = (base * 10 + 1) % k;
            result++;
        }

        return result;
    }
}

class TestSmallestAllOnesMultiple {
    static void main(String[] args) {
        SmallestAllOnesMultiple test = new SmallestAllOnesMultiple();

        int[] cases = {
                3, 7, 2, 6
        };

        for (var c : cases) {
            var result = test.minAllOneMultiple(c);
            System.out.println(result);
        }
    }
}