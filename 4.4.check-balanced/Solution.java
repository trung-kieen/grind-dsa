/*
 * This solution perform base on the definition of BST 
 * But this inefficient when recaculate the height recursive => O(n log n)
 */
class Solution {
    public static class TreeNode<T> {
        public T val;
        public TreeNode<T> left;
        public TreeNode<T> right;

        public TreeNode(T val) {
            this.val = val;
        }
        public TreeNode(T val, TreeNode<T> left, TreeNode<T> right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static <T>  boolean isBalance(TreeNode<T> node) {
            if (node == null){
                return true;
            }

            boolean currentIsBlance = Math.abs(height(node.left) - height(node.right)) <= 1;
            // Check if children is balance too
            return currentIsBlance && isBalance(node.left) && isBalance(node.right);
        }
        public static <T> int height(TreeNode<T> node){
            // Base case
            if (node == null){
                return 0;
            }
            int h = Math.max(height(node.left), height(node.right));
            return h + 1;
        }


    }
    public static void main (String[] args){
        TreeNode<Integer> tree1 = new TreeNode<>(1, 
                new TreeNode<>(2, new TreeNode<>(3), new TreeNode<>(4)), 
                new TreeNode<>(3)
        );


        TreeNode<Integer> tree2 = new TreeNode<>(1, 
                new TreeNode<>(2, new TreeNode<>(3, 
                        new TreeNode<>(5), null
                        ), new TreeNode<>(4)), 
                new TreeNode<>(3)
        );

        assert TreeNode.isBalance(tree1) : "Error: case 1 should be equal";
        assert !TreeNode.isBalance(tree2) : "Error: case 2 should not be equal";
        System.out.println("AC");
    }


}
