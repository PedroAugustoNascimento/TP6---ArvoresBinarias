public class Main {
    
    public static void main (String []args){
        BinaryTree tree = new BinaryTree();

        Node c1 = new Node(40);
        Node c2 = new Node(20);
        Node c3 = new Node(90);
        Node c4 = new Node(70);
        Node c5 = new Node(250);
        Node c6 = new Node(33);

        tree.insertAtBegining(c1);
        tree.insertAtBegining(c2);
        tree.insertAtBegining(c3);
        tree.insertAtBegining(c4);
        tree.insertAtBegining(c5);
        tree.insertAtBegining(c6);

        System.out.println("================================");
        tree.preOrder();
        System.out.println("================================");
        tree.countNodes();
        System.out.println("================================");
        tree.countNotTerminalNodes();



    }
}
