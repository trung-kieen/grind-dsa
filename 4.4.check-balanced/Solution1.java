/*
 * Use the idea of search in array to return singal if inbalance child (not found will return -1 if array search)
 * We allow to archive the height calculate by recursive call each node only once time 
 * => Runtime O(n)
 */
class Solution1 {
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
            // Check if the recursive is not inbalance => tree is balance 
            return height(node) != -1;
        }
        public static <T> int height(TreeNode<T> node){
            // Base case
            if (node == null){
                return 0;
            }
            int left = height(node.left); 
            int right = height(node.right); 


            // Return signal if not valid balance tree 
            boolean balance = Math.abs(left - right) <= 1; 
            if (!balance){ 
                return -1;
            }

            int h = Math.max(left, right);
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
