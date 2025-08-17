abstract class Animal{ 
    private int order; 
    private String name; 
    public Animal(String name){ 
        this.name = name; 
    }

    /*
     * the older animal will not be pop in the FIFO 
     * we choose the animal have smaller order 
     * A: 1 
     *      B: 2 
     *
     * => Choose A becase it come first 
     */ 
    boolean isOlder(Animal other){ 
        return this.order > other.order; 
    }
    void setOrder(int order){ 
        this.order = order; 
    }
    int getOrder(){ 
        return  this.order; 
    }
    @Override 
    public String toString(){ 
        return this.name;
    }
    public String getName(){ 
        return this.name;
    }
}
