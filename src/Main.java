package src;
public class Main {
    
    public static void main (String []args){
        BinaryTree tree = new BinaryTree();
        Hash hash = new Hash();


        Node c1 = new Node(40);
        Node c2 = new Node(20);
        Node c3 = new Node(90);
        Node c4 = new Node(75);
        Node c5 = new Node(250);
        Node c6 = new Node(33);
        Node c7 = new Node(19);
        Node c8 = new Node(30);

        tree.insertAtBegining(c1);
        tree.insertAtBegining(c2);
        tree.insertAtBegining(c3);
        tree.insertAtBegining(c4);
        tree.insertAtBegining(c5);
        tree.insertAtBegining(c6);
        tree.insertAtBegining(c7);
        tree.insertAtBegining(c8);

        System.out.println("================================");
        tree.preOrder();
        System.out.println("================================");
        tree.countNodes();
        System.out.println("================================");
        tree.countNotTerminalNodes();
        System.out.println("================================");
        tree.countTerminalNodes();
        System.out.println("================================");
        tree.heightTree();
        System.out.println("================================");
        System.out.println("");
        tree.preOrder();
        System.out.println("================================");
        tree.removePairNumbers();
        System.out.println("================================");
        tree.preOrder();
        System.out.println("================================");
        System.out.println("Inverted tree: ");
        tree.mirroringTree();
        System.out.println("================================");
        System.out.println("HashMap: ");
        hash.getMapValue();
        System.out.println("================================");
        System.out.println("HashSet: ");
        hash.getSetValue();
        System.out.println("================================");
        System.out.println("LinkedHashMap: ");
        hash.getLinkedValue();
        System.out.println("================================");
        System.out.println("Hashtable: ");
        hash.getTableValue();
        System.out.println("================================");
        tree.posOrderStack();
        System.out.println("================================");
        tree.preOrderStack();
        System.out.println("================================");
        tree.onOrderStack();

        

    }
}
