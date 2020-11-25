public class BinaryTreeTraversal{
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val){
			this.val = val;
		}
	}
	public static void main(String[] args) {
		//TODO: build a tree
		levelOrder(root, )
	}
	public void levelOrder(TreeNode root){
		if(root == null) return;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()){
			TreeNode top = q.poll();
			System.out.println(top.val);
			if (top.left != null) {
				q.offer(top.left);
			}
			if (top.right != null) {
				q.offer(top.right);
			}
		}
		return;
	}
}