import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversalIteratively {
    public static void main(String[] args) {

    }

    /**
     * 遍历是在遍历所有子树的根，叶子节点也是子树 所以取值的顺序就是看子树的顺序 前序：根，左，右 ====
     * 根，左子树的根，右子树的根，所以拿到上面的根的时候就取值 中序：左，根，右 ==== 左子树的根，根，右子树的根，所以拿到最下面的左子树根的时候取值
     */
    // 模板一
    // 先序遍历
    public List<Integer> preorder1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }

    // 中序遍历
    public List<Integer> inorder1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    // 后序遍历
    public List<Integer> postorder1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        Collections.reverse(res);
        return res;
    }

    // 模板2
    // 先序遍历
    public List<Integer> preorder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                list.add(root.val);
                if (root.right != null)
                    stack.push(root.right);
                root = root.left;
            } else {
                root = stack.pop();
            }
        }
        return list;
    }

    // 中序遍历
    public List<Integer> inorder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

    // 后序遍历
    public List<Integer> postorder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                // 头插法
                list.add(0, root.val);
                if (root.left != null)
                    stack.push(root.left);
                // 优先访问右子树
                root = root.right;
            } else {
                root = stack.pop();
            }
        }
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode() {
        }
    }

    // 模板3
    class Node {
        TreeNode node;
        boolean flag;

        Node(TreeNode node, boolean flag) {
            this.node = node;
            this.flag = flag;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        Node cur;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                cur = new Node(root, false);
                stack.push(cur);
                root = root.left;
            }
            cur = stack.pop();
            root = cur.node;
            if (cur.flag) {
                res.add(root.val);
                root = null;
            } else {
                cur.flag = true;
                root = root.right;
                stack.push(cur);
            }
        }
        return res;
    }
}
