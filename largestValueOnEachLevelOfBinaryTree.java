import java.util.*;

class TreeNodee {
    int val;
    TreeNodee left;
    TreeNodee right;

    TreeNodee(int x) {
        val = x;
    }
};

public class largestValueOnEachLevelOfBinaryTree {
    public List<Double> findLevelAveragess(TreeNodee root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNodee> queue = new LinkedList<>();
        queue.offer(root);
        double maxValue = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNodee currentNode = queue.remove();
                maxValue = Math.max(maxValue, currentNode.val);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add((double) maxValue);
        }
        return result;
    }

    public static void main(String[] args) {
        largestValueOnEachLevelOfBinaryTree obj = new largestValueOnEachLevelOfBinaryTree();
        TreeNodee root = new TreeNodee(12);
        root.left = new TreeNodee(7);
        root.right = new TreeNodee(1);
        root.left.left = new TreeNodee(9);
        root.left.right = new TreeNodee(2);
        root.right.left = new TreeNodee(10);
        root.right.right = new TreeNodee(5);
        List<Double> result = obj.findLevelAveragess(root);
        System.out.print("Level averages are: " + result);
    }
}

