import java.util.*; 
class Solution { 
    public static void main (String [] args ){ 
        System.out.println("AC"); 
    }
    /**
     * Receive the tree and recurvie create the tree node 
     */
    public static class TreeNode<T extends Comparable<T>>{ 
        public T val; 
        public TreeNode<T> left; 
        public TreeNode<T> right; 
        public TreeNode(T val){ 
            this.val = val; 
        }
        public TreeNode(T val, TreeNode<T> left, TreeNode<T> right){ 
            this.val = val; 
            this.left = left; 
            this.right = right; 
        }



        public static <T extends Comparable<T>> TreeNode<T> buildTree(List<T> elements){ 
            if (elements == null){ 
                return null; 
            }
            return buildTree(elements, 0, elements.size() - 1);
        }

        public static <T extends Comparable<T>> TreeNode<T> buildTree(List<T> elements, int start, int end){ 
            if (elements == null){ 
                return null; 
            }
            if (start > end){ 
                return null; 
            }
            // Create the midddle node 

            int mid = (start + end) / 2; 
            TreeNode<T> n  = new TreeNode<>(elements.get(mid)); 
            var l = buildTree(elements, start, mid - 1); 
            var r = buildTree(elements, mid + 1, end); 
            n.left = l; 
            n.right = r; 
            return n; 
        }
    }
}
