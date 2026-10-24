import java.util.Arrays;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] frequency = new int[1001];
        int[] result = new int[arr1.length];
        int index = 0;

        for (int num : arr1) {
            frequency[num] += 1;
        }

        for (int num : arr2) {
            while (frequency[num] > 0) {
                result[index] = num;
                index++;
                frequency[num]--;
            }
        }

        for (int i = 0; i < 1001; i++) {
            while (frequency[i] > 0) {
                result[index] = i;
                index++;
                frequency[i]--;
            }
        }
        return result;
    }
}

class TestCase {
    int[] arr1;
    int[] arr2;

    public TestCase(int[] arr1, int[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
    }
}

class TestRelativeSortArray {
    static void main(String[] args) {
        RelativeSortArray test = new RelativeSortArray();

        TestCase[] cases = {
                new TestCase(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6}),
                new TestCase(new int[]{28,6,22,8,44,17}, new int[]{22,28,8,6})
        };

        for (var c : cases) {
            var result = test.relativeSortArray(c.arr1, c.arr2);
            System.out.println(Arrays.toString(result));
        }
    }
}