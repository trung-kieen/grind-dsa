import java.util.LinkedList; 
class Solution{ 
    public static void main(String[] args){
        var as = new AnimalShelter(); 
        as.enqueue(new Cat("A")); 
        as.enqueue(new Dog("B")); 
        as.enqueue(new Cat("C")); 
        as.enqueue(new Dog("D")); 
        as.enqueue(new Cat("E")); 
        as.enqueue(new Cat("F")); 
        as.enqueue(new Dog("G")); 
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue(new Cat("C1")); // order 1
        shelter.enqueue(new Dog("D1")); // order 2
        assert shelter.dequeueAny().getName().equals("C1"); // C1 vào trước

        System.out.println("AC"); 
    }

    
    public static class AnimalShelter { 
        public static int counter = 0; 
        private LinkedList<Dog> dogs; 
        private LinkedList<Cat> cats; 
        public AnimalShelter(){ 
            dogs = new LinkedList<>(); 
            cats = new LinkedList<>(); 
        }
        
        // Push animal to shelter  enqueue 

        public void enqueue(Animal x){ 
            counter ++; 
            x.setOrder(counter); 
            if (x instanceof Dog) { 
                dogs.addLast((Dog) x);
            }
            if (x instanceof Cat){ 
                cats.addLast((Cat) x); 
            }
        }


        // Dequeue Cat 

        public Cat dequeueCat(){ 
            return cats.pop();        
        }
        public Dog dequeueDog(){ 
            return dogs.pop(); 
        }


        // Dequeue Dog 


        // Dequeue Any 

        public Animal dequeueAny(){ 
            if (dogs.size() == 0 && cats.size() == 0){ 
                throw new RuntimeException("Except limit of dog and cat"); 
            }
            if (dogs.size() == 0){ 
                return dequeueCat();
            }
            if (cats.size() == 0){ 
                return dequeueDog();
            }
            var lastDog = dogs.peek(); 
            var lastCat = cats.peek(); 
            if (lastDog.isOlder(lastCat)){ 
                return dequeueCat(); 
            }
            else{ 
                return dequeueDog(); 
            }
        }



    }

}
