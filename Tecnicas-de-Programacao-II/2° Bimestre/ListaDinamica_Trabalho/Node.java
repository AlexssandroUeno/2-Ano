 


/**
 * Write a description of class Node here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Node
{
    // instance variables - replace the example below with your own
    private Object x;
    private Node proximo;

    /**
     * Constructor for objects of class Node
     */
    public Node()
    {

    }
    
    public Node(String args)
    {
        this.x = args;
    }
    
    public void setX(Object _x){
        this.x = _x;
    }
    
    public Object getX(){
        return this.x;
    }
    
    public void setProximo(Node _proximo){
        this.proximo = _proximo;
    }
    
    public Node getProximo(){
        return this.proximo;
    }
}
