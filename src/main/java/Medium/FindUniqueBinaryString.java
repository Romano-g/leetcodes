package Medium;

public class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        var sb = new StringBuilder();

        for (int i = 0; i< nums.length; i++) {
            sb.append(nums[i].charAt(i) == '1' ? '0' : '1');
        }

        return sb.toString();
    }
}

class TestFindUniqueBinaryString {
    static void main(String[] args) {
        FindUniqueBinaryString test = new FindUniqueBinaryString();

        String[][] cases = {
                {"01","10"}, {"00","01"}, {"111","011","001"}
        };

        for (var c : cases) {
            var result = test.findDifferentBinaryString(c);
            System.out.println(result);
        }
    }
}