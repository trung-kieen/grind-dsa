import java.util.Deque; 
import java.util.ArrayDeque; 
class Solution { 
    /*
     * This data structure is not aim for the solution 
     * The solution require to implement the algorithms on a stack to make stack sorted. 
     */
    static class SortStack{ 
        private Deque<Integer> elements; 
        public SortStack(){ 
            elements = new ArrayDeque<>(); 
        }
        
        // add element will store smaller element to other stack temporary 
        public void push(int value){ 
            Deque<Integer>  tempStack = new ArrayDeque<>(); 
            // while element in the main stack is smaller than the value or the stack is not empty 

            while (!elements.isEmpty() && elements.peek()  < value){ 
                // transfer element to another stack 
                tempStack.push(elements.pop()); 
            }

            // push new value to the main stack 
            elements.push(value); 

            // transfer back temporary stack to main stack 
            while (!tempStack.isEmpty()){ 
                elements.push(tempStack.pop()); 
            }
        }



        // pop will remove element on top (the smallest)
        public Integer pop(){ 
            if (elements.isEmpty()){ 
                return null; 
            }
            return elements.pop(); 
        }

        // peek just return the element on the top 
        public Integer peek(){ 
            if (elements.isEmpty()){ 
                return null; 
            }
            return elements.peek(); 
        }


        // is empty 
        public boolean isEmpty(){ 
            return elements.isEmpty(); 
        }
        @Override 
        public String toString(){
            return elements.toString(); 

        }
    }

    public static void main(String... args){ 

        // For sort stack data structure 
        var s = new SortStack(); 
        s.push(2); 
        s.push(4); 
        s.push(-3); 
        s.push(-1); 
        s.push(0); 
        System.out.println(s);
    }



}
