package uk.ac.reigate.RM13030.linear;

/**
 * @author Robbie
 * @since 16-09-2015
 */

public interface LinearQueue {
    
    public int getSize();
    
    public int getRearPos();
    
    public int getFrontPos();
    
    public Object peek();
    
    public boolean isEmpty();
    
    public boolean isFull();
    
    public void add(Object obj, boolean print);
    
    public void add(Object obj, int idx, boolean print);
    
    public void remove(boolean print);
    
    public void remove(int idx, boolean print);
    
    public void remove(Object obj, boolean print);
    
    public void printContents(boolean breakLine);
    
    public void printContents();

}
