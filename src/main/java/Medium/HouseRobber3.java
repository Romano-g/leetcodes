package Medium;

public class HouseRobber3 {
    public int rob(TreeNode root) {
        var result = calculate(root);

        return Math.max(result[0], result[1]);
    }

    private int[] calculate (TreeNode root) {
        if (root == null) {
            return new int[]{0,0};
        }

        int[] left = calculate(root.left);
        int[] right = calculate(root.right);

        int robThis = root.val + left[1] + right[1];
        int skipThis = Math.max(left[0], left[1]) +
                Math.max(right[0], right[1]);

        return new int[] {robThis, skipThis};
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
}

class TestHouseRobber3 {
    static void main(String[] args) {
        HouseRobber3 test = new HouseRobber3();

        TreeNode[] cases = {
            new TreeNode(3,
                    new TreeNode(2, null, new TreeNode(3)),
                    new TreeNode(3, null, new TreeNode(1))
            ),

            new TreeNode(3,
                    new TreeNode(4, new TreeNode(1), new TreeNode(3)),
                    new TreeNode(5, null, new TreeNode(1))
            )
        };

        for (var c : cases) {
            var result = test.rob(c);
            System.out.println(result);
        }
    }
}