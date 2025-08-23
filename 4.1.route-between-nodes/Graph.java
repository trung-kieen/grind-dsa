import java.util.function.Consumer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;
class Graph <T> {
    public static class Node<T> {
        public T data;
        public boolean marked;
        public Node<T>[] adjacent;

        public Node(T data){
            this.data = data;
        }
        public void setAdjacent(Node<T> ... nodes ){
            this.adjacent = nodes;
        }
    }
    public Node<T> root;
    public Graph(){
        this.root = null;
    }
    public boolean path(Node<T> start, Node<T> end){
        // Init the queue with start node

        Set<Node<T>> visited = new HashSet<Node<T>>();
        Queue<Node<T>> q = new LinkedList<Node<T>>();
        visited.add(start); 
        q.add(start);
        while(!q.isEmpty()){
            var node = q.poll();
            if (node == end || node.data == end.data){
                return true;
            }
            visited.add(node);
            for (var c: node.adjacent){
                if (!visited.contains(c)){
                    q.add(c);
                }
            }


        }
        // If not found return false
        return false;
    }

    public void bfs(Consumer<Node<T>> visit){
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        this.root.marked = true; // mark as visted
        queue.add(this.root);
        while (!queue.isEmpty()){
            // Get child node
            Node<T> r = queue.poll();
            visit.accept(r);


            // neighbor is not visited will be push to frontier
            for(Node<T> c: r.adjacent) {
                if (!c.marked){
                    queue.add(c);
                    c.marked = true;
                }
            }
        }
    }
    public void dfs(Consumer<Node<?>> visit){
        dfs(visit, this.root);
    }
    public void dfs(Consumer<Node<?>> visit, Node<T> node){
        if (node == null){
            return;
        }
        visit.accept(node);
        node.marked = true;
        for(var child: node.adjacent){
            if (child.marked == false){
                dfs(visit, child);
            }
        }
    }
        public static void main(String[] args) {
        Node<String> A = new Node<>("A");
        Node<String> B = new Node<>("B");
        Node<String> C = new Node<>("C");
        Node<String> D = new Node<>("D");
        Node<String> E = new Node<>("E");
        Node<String> F = new Node<>("F");

        A.setAdjacent(B, C);
        B.setAdjacent(D, E);
        C.setAdjacent(F);
        D.setAdjacent(); // D không có nút kề
        E.setAdjacent(F);
        F.setAdjacent(); // F không có nút kề

        Graph<String> graph = new Graph<>();
        graph.root = A;

        System.out.println("--- BFS Traversal ---");
        //
        graph.bfs(node -> System.out.print(node.data + " ")); 
        System.out.println("\n");

        System.out.println("--- DFS Traversal ---");
        //
        graph.dfs(node -> System.out.print(node.data + " ")); 
        System.out.println("\n");
        // A not direct connect with D but we have other node between to create this path 
        System.out.println(graph.path(A, D));
    }
}
