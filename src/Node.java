package src;
public class Node{
    
    private int value;
    private Node right;
    private Node left;
    private Node next;


    public Node(int value){
        setValue(value);
        setLeft(null);
        setRight(null);
        setNext(null);
    }

    public Node getRight(){
        return right;
    }

    public void setRight(Node right){
        this.right = right;
    }

    public Node getLeft(){
        return left;
    }

    public void setLeft(Node left){
        this.left = left;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node node){
        this.next = next;
    }


}
