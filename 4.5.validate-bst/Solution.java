class Solution { 
    public static class TreeNode<T extends Comparable<T>> { 
        public T val; 
        public TreeNode<T> left; 
        public TreeNode<T> right; 

        public TreeNode(T data){ 
            this.val = data; 
        }
        public TreeNode(T data, TreeNode<T> left, TreeNode<T> right){ 
            this.val = data; 
            this.left = left; 
            this.right = right; 
        }

        public boolean validBST(){ 
            return Solution.validBST(this); 
        }
    }
    public static <T extends Comparable<T>> boolean validBST(TreeNode<T> root){ 
        return validBST(root, null, null); 
    }
    public static <T extends Comparable<T>> boolean validBST(TreeNode<T> root, T min, T max){ 
        if (root == null){ 
            return true;
        }
        if (root.left != null && root.left.val.compareTo(root.val) > 0 ) { 
            return false; 
        }

        if (max != null && max.compareTo(root.val) > 0) { 
            return false; 
        }

        if (root.right != null && root.right.val.compareTo(root.val) <= 0) { 
            return false; 
        }
        if (min != null && min.compareTo(root.val) <= 0 ) { 
            return false; 
        }

        return validBST(root.left, root.val, max) && validBST(root.right, min, root.val); 
    }
    public static void main(String [] args){
        TreeNode<Integer> bst = new TreeNode<>(5,
                new TreeNode<>(3,
                    new TreeNode<>(2), new TreeNode<>(4)
                ),
                new TreeNode<>(7,
                    new TreeNode<>(6), new TreeNode<>(8)
                )
        );
        System.out.println("Valid BST? " + bst.validBST()); // true

        // Case 2: Invalid BST
        TreeNode<Integer> notBst = new TreeNode<>(5,
                new TreeNode<>(3,
                    new TreeNode<>(2), new TreeNode<>(6) // ❌ 6 ở nhánh trái nhưng > 5
                ),
                new TreeNode<>(7)
        );
        System.out.println("Valid BST? " + notBst.validBST()); // false
    }

}
