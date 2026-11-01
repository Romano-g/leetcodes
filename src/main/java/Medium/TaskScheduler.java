package Medium;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        var maxFreq = 0;
        var maxCount = 0;

        for (char c : tasks) {
            freq[c - 'A']++;

            if (freq[c - 'A'] > maxFreq) {
                maxFreq = freq[c - 'A'];
            }
        }

        for (int f : freq) {
            if (f == maxFreq) {
                maxCount++;
            }
        }

        return Math.max((maxFreq - 1) * (n + 1) + maxCount, tasks.length);
    }
}

class TestTaskScheduler {
    static void main(String[] args) {
        TaskScheduler test = new TaskScheduler();

        char[][][] cases = {
                {{'A','A','A','B','B','B'}, new char[]{'2'}},
                {{'A','C','A','B','D','B'}, new char[]{'1'}},
                {{'A','A','A', 'B','B','B'}, new char[]{'3'}}
        };

        for (var c : cases) {
            var result = test.leastInterval(c[0], c[1][0] - '0');
            System.out.println(result);
        }
    }
}