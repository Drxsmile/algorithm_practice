import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
	TreeNode root;

	public BinarySearchTree(TreeNode root) {
		this.root = root;
	}

	public TreeNode find(TreeNode root, int val) {
		if (root == null)
			return null;
		// if(root.val == val) return root;
		// else if(root.val > val){
		// return find(root.left, val);
		// }else{
		// return find(root.right, val);
		// }
		TreeNode cur = root;
		while (cur != null) {
			if (cur.val == val)
				return cur;
			else if (cur.val > val)
				cur = cur.left;
			else
				cur = cur.right;
		}
		return null;
	}

	public TreeNode add(TreeNode root, int val) {
		if (root == null) {
			root = new TreeNode(val);
			return root;
		}
		TreeNode cur = root;
		while (cur != null) {
			if (cur.val == val) {
				System.out.println("exist!");
				return cur;
			} else if (cur.val > val) {
				if (cur.left == null) {
					cur.left = new TreeNode(val);
					return cur.left;
				}
				cur = cur.left;
			} else {
				if (cur.right == null) {
					cur.right = new TreeNode(val);
					return cur.right;
				}
				cur = cur.right;
			}
		}
		return null;
	}

	public boolean remove(TreeNode root, int val) {
		if (root == null)
			return false;
		if (root.val == val) {
			root = removeNode(root);
			return true;
		}
		TreeNode node = root;
		while (node != null) {
			if (node.val > val) {
				if (node.left == null) {
					System.out.println("node[" + val + "] doesn't exist");
					return false;
				} else {
					if (node.left.val == val) {
						node.left = removeNode(node.left);
						return true;
					} else
						node = node.left;
				}
			} else {
				if (node.right == null) {
					System.out.println("node[" + val + "] doesn't exist");
					return false;
				} else {
					if (node.right.val == val) {
						node.right = removeNode(node.right);
						return true;
					} else
						node = node.right;
				}
			}
		}
		return false;
	}

	private TreeNode removeNode(TreeNode node) {
		if (node == null)
			return null;
		if (node.left == null && node.right == null) {
			return null;
		} else if (node.left == null) {
			return node.right;
		} else if (node.right == null) {
			return node.left;
		} else {
			TreeNode cur = node;
			TreeNode res = cur.left;
			if (res.right == null) {
				node.val = res.val;
				cur.left = res.left;
				return node;
			}
			while (res.right != null) {
				cur = res;
				res = res.right;
			}
			node.val = res.val;
			cur.right = res.left;
			return node;
		}
	}

	public List<List<Integer>> traversal(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(root, res, 0);
		return res;
	}

	public void dfs(TreeNode root, List<List<Integer>> res, int depth) {
		if (root == null)
			return;
		if (depth > res.size() - 1)
			res.add(new ArrayList());
		res.get(depth).add(root.val);
		dfs(root.left, res, depth + 1);
		dfs(root.right, res, depth + 1);
	}

}