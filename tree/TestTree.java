import java.util.LinkedList;
import java.util.Queue;

public class TestTree {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode p = stringToTreeNode("[10,5,11,2,7,6,12]");
        BinarySearchTree bst = new BinarySearchTree(p);
        System.out.println(bst.traversal(p));
        TreeNode res = bst.find(p, 2);
        System.out.println("find: " + res);
        TreeNode a1 = bst.add(p, 10);
        TreeNode a2 = bst.add(p, 12);
        TreeNode a3 = bst.add(p, 8);
        System.out.println(bst.traversal(p));
    }
}