import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  // Create the dsa
  // Linked list node
  public static class LNode<T> {
    public T data;
    public LNode<T> next;

    public LNode(T data) {
      this.data = data;
    }

    @Override
    public String toString() {
      var n = this;
      var sb = new StringBuilder();
      while (n != null) {
        sb.append(n.data);
        n = n.next;
      }
      return sb.toString();
    }
  }

  public static <T> LNode<T> push(LNode<T> head, LNode<T> n) {
    // Push child to node
    n.next = head;
    head = n;
    return head;
  }

  // Tree node
  public static class TNode<T> {
    public T data;
    public TNode<T> left;
    public TNode<T> right;

    public TNode(T data) {
      this.data = data;
    }
  }

  public static <T> void addNodeToLinkedList(TNode<T> root, List<LinkedList<TNode<T>>> lists, int level) {
    // Base case avoid left node
    if (root == null){
      return;
    }
    // Create new LinkedList for each level of tree if not exists
    if (lists.get(level) == null){
      lists.add(new LinkedList<>());
    }
    var currentList = lists.get(level);

    // Add node to linkedlist level
    currentList.add(root);

    // Recurive call next node child to add new linkedlist level
    addNodeToLinkedList(root.left, lists, level + 1);
    addNodeToLinkedList(root.right, lists, level + 1);
  }

  /*
   * Create the List of LinkedList to storage
   * Recursive call from root the next child with level passing increase
   * Each function will know which level (which linkedlist to be modified)
   */
  public static <T> List<LinkedList<TNode<T>>> approach1(TNode<T> root) {
    // Create result array of linked list
    List<LinkedList<TNode<T>>> lists = new ArrayList<>();
    // Add node to each level start with root node
    addNodeToLinkedList(root, lists, 0);
    return lists;
  }


  public static <T> List<LinkedList<TNode<T>>> appoarch2(TNode<T> root){

      List<LinkedList<TNode<T>>> result = new ArrayList<>();
      // Create queue add the current root to to list
      if (root  == null){
        return result;
      }

      // Create the first linkedlist is root if root is not null
      LinkedList<TNode<T>> current = new LinkedList<>();
      current.add(root);
        while (!current.isEmpty()){
            result.add(current);
            LinkedList<TNode<T>> parents = current;
            current = new LinkedList<>();
            for (var c : parents){
                if (c.left != null){
                    current.add(c.left);
                }
                if (c.right != null){
                    current.add(c.right);
                }
            }
        }
      return result;

      // Recurcsive create for other layer from previous node => expand result to interate
      // and then create new list to store the next layer childrent (avoid null)

  }
  public static void main(String[] args) {
    System.out.println("AC");
    var x = new LNode(10);
    var y = new LNode(20);
    System.out.println(x);
  }
}
