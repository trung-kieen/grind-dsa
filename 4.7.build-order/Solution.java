import java.util.Arrays; 
import java.util.List; 
import java.util.ArrayList; 
import java.util.Map; 
import java.util.HashMap; 
class Solution { 
    static class Graph { 
        public List<Node> nodes; 
        public Map<String, Node> map; 
        public Graph(String [] nodes){ 
            this.nodes = new ArrayList<>(); 
            this.map = new HashMap<>(); 
            for (String name : nodes){ 
                this.getOrCreateNode(name); 
            }
        }
        
        public Node getOrCreateNode(String name){ 
            Node n; 
            if(!map.containsKey(name)){ 
                n = new Node(name);
                this.nodes.add(n); 
                this.map.put(name, n); 
                return n; 
            }else { 
                return map.get(name); 
            }
        }

        public void addEdge(String parent, String child){ 
            // Assume constructor need to add all node here 
            Node parentNode = getOrCreateNode(parent); 
            Node childNode = getOrCreateNode(child); 
            parentNode.addChild(childNode); 
        }
        /**
         * Return build order 
         */
        public Node [] order() {
            Node[] build = new Node[nodes.size()]; 
            // To append new node to build list 
            int newNodeIdx = 0; 
            newNodeIdx = this.addBuild(build, this.nodes, newNodeIdx); 
            int processIdx = 0; 
            while (processIdx < build.length){ 
                // Resolve child node 
                Node current = build[processIdx]; 
                for (Node child : current.children){ 
                    child.resolve(); 
                }
                newNodeIdx = this.addBuild(build, current.children, newNodeIdx); 
                processIdx ++; 
            }
            
            return build; 

        }
        private int addBuild(Node[] buildList, List<Node> children, int newNodeIdx){ 
            for (Node child: children){ 
                if (child.isResolved()){ 
                    // Overflow case 
                    if (newNodeIdx >= buildList.length){ 
                        return newNodeIdx; 
                    }
                    // Add to build list 
                    buildList[newNodeIdx] = child; 
                    newNodeIdx++; 
                }

            }
            return newNodeIdx; 

        }


    }
    static class Node { 
        public String name; 
        public List<Node> children; 


        // Number depended node 
        public int in; 
        // Number of sartified depended node 
        public int out; 
        public Node(String name){ 
            children = new ArrayList<>(); 
            this.name = name; 
        }
        public void addChild(Node n){ 
            this.children.add(n); 
            n.in++; 
        }
        /*
         * Resolve dependencies 
         * Use when a parrent of this not is satified 
         * no more depended for this parrent needed 
         */
        public void resolve(){ 
            this.out++;
        }
        public boolean isResolved(){ 
            return this.in == this.out; 
        }
        @Override 
        public String toString(){ 
            return this.name; 
        }
    }
    public static Node[] buildOrder(String [] projects, String[][] dependencies){ 
    // Make graph 
    // Define node 
    // Add node to graph 
        var graph = new Graph(projects); 
    // Add edge to graph 
        for (String [] dep: dependencies){ 
            graph.addEdge(dep[0], dep[1]); 
        }

        return graph.order(); 
    }
    



    // Find the root node of graph 
    
    // Iterate over pending node and add to build order 

    // Return error if exist 
    public static void main(String[] args){ 
        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {
            {"a", "d"},
            {"f", "b"},
            {"b", "d"},
            {"f", "a"},
            {"d", "c"}
        };

        // This use the kahn algorithms to solve the topology sort
        Node[] order = buildOrder(projects, dependencies);
        System.out.println(Arrays.toString(order));


        System.out.println("AC"); 
    }


}
