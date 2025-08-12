class Solution{ 
    // Create sub class for stack 

    private static class StackNode<T>{ 
        public T data; 
        public StackNode<T> next; 
        public StackNode(T data) {
            this.data = data; 
        }
        @Override 
        public String toString(){ 
            return this.data.toString(); 
        }
    }


    /*
     *      A -> B -> C -> D -> E 
     *      ^
     *    head 
     */

    // Create a linked list to store the node 
    private static class Stack<T>{ 
        private StackNode<T> head; 

        public Stack(){ 
            this.head = null; 
        }



        // push: add value to head 
        public void push(T data){ 
               // Make new node is head 
               StackNode<T> node = new StackNode<T>(data); 
               node.next = this.head; 
               this.head = node; 
        }

        @Override 
        public String toString(){ 
            if (this.head == null){ 
                return "<EMPTY>"; 
            }
            boolean isFirstElement = true; 
            StringBuilder sb = new StringBuilder(); 
            StackNode<T> n = this.head; 
            while (n != null){ 
                if (isFirstElement){ 
                    isFirstElement = false; 
                }else{ 
                    sb.append("->"); 
                }
                sb.append(n); 
                n = n.next; 
            }
            return sb.toString(); 
        }

        // pop: remove node and return value 
        public T pop(){ 
            T value = this.head.data; 
            this.head = this.head.next; 
            return value; 
        }
        // isEmpty: check head is not point to something 
        public boolean isEmpty(){ 
            return this.head == null; 
        }

        // peek: return head ? 
        public T peek(){ 
            return this.head.data; 
        }
    }

    private static class Queue<T>{ 

        private StackNode<T> head; 
        private StackNode<T> tail; 

        public Queue() { 
            this.head = null; 
            this.tail = null; 
        }



        /*
         *  Remove 
         *    V
         *    A -> B -> C -> D 
         *    ^ 
         *   head 
         *  
         *                  add 
         *                   V
         *    A -> B -> C -> D 
         *    ^              ^
         *   head          tail 
         */
        public void push(T data){ 
            // If empty => make this is head and tail
            StackNode<T> node = new StackNode(data); 
            if (this.tail == null){ 
                this.head = node; 
                this.tail = node; 
            }else { 
            // Else add at tail
                this.tail.next = node; 
                this.tail = node; 
            }


        }

        @Override 
        public String toString(){ 
            if (this.head == null){ 
                return "<EMPTY>"; 
            }
            boolean isFirstElement = true; 
            StringBuilder sb = new StringBuilder(); 
            StackNode<T> n = this.head; 
            while (n != null){ 
                if (isFirstElement){ 
                    isFirstElement = false; 
                }else{ 
                    sb.append("->"); 
                }
                sb.append(n); 
                n = n.next; 
            }
            return sb.toString(); 
        }

        // pop: remove node and return value 
        public T pop(){ 
            // Return null if stack is empty 
            if (this.head == null){ 
                return null;
            }
            T value = this.head.data; 
            this.head = this.head.next; 
            // If we only have single value in stack, after pop head and tail is null 
            if (this.head == null){ 
                this.tail = null; 
            }
            return value; 
        }
        // isEmpty: check head is not point to something 
        public boolean isEmpty(){ 
            return this.head == null; 
        }

        // peek: return head ? 
        public T peek(){ 
            if (this.head == null){ 
                return null; 
            }
            return this.head.data; 
        }
    }
    public static void main(String [] args){ 
        System.out.println("Hello"); 
        var s = new StackNode<>("Kien"); 
        var stack = new Stack<String>(); 
        stack.push("Kai"); 
        stack.push("Demon"); 
        stack.push("KK"); 

        System.out.println(stack); 
        var value = stack.pop(); 
        System.out.println("remove the element "+ value); 
        System.out.println(stack); 
    }
}
 
