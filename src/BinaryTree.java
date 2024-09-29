package src;
public class BinaryTree {
    Node root;
    int count = 0;

    // construtor
    public BinaryTree() {
        root = null;
    }

    // inserir no começo
    // se o elemento for igual, não insere
    private Node insert(Node newNode, Node current) {
        if (current == null)
            return newNode;
        if (current.getValue() > newNode.getValue())
            current.setLeft(insert(newNode, current.getLeft()));
        if (current.getValue() < newNode.getValue())
            current.setRight(insert(newNode, current.getRight()));

        return current;
    }

    // metodo publico para o main
    public void insertAtBegining(Node newNode) {
        root = insert(newNode, root);
    }

    // impressao pre ordem
    private void preorder(Node node) {
        if (node != null) {
            System.out.println("Element: " + node.getValue());
            preorder(node.getLeft()); // E
            preorder(node.getRight()); // D
        }
    }

    // metodo publico
    public void preOrder() {
        preorder(root);
    }

    // impressao pos ordem
    private void posorder(Node node) {
        if (node != null) {
            posorder(node.getLeft()); // E
            posorder(node.getRight()); // D
            System.out.println("Element: " + node.getValue()); // R
        }
    }

    // metodo publico
    public void posOrder() {
        posorder(root);
    }

    // impressao em ordem
    private void onorder(Node node) {
        if (node != null) {
            onorder(node.getLeft()); // E
            System.out.println(node.getValue()); // R
            onorder(node.getRight()); // D
        }
    }

    // metodo publico
    public void onOrder() {
        onorder(root);
    }

    // encontrar pai do elemento
    private Node findNode(Node current, int value) {
        if (current == null)
            return null;

        if (value > current.getValue()) {
            if (current.getRight() != null) {
                if (current.getRight().getValue() == value)
                    return current;
            }
        } else {
            if (current.getLeft() != null) {
                if (current.getLeft().getValue() == value)
                    return current;
            }
        }

        if (current.getValue() > value)
            return findNode(current.getRight(), value);
        if (current.getValue() < value)
            return findNode(current.getLeft(), value);
        
        return null;
    }

    // remover
    public boolean remove(int value) {
        if (root == null) {
            return false; 
        }
    
        // Caso em que a raiz é o nó a ser removido
        if (root.getValue() == value) {
            // Se a raiz não tem filhos, simplesmente a remove
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
            } else if (root.getLeft() == null) { // Se não tem filho esquerdo
                root = root.getRight();
            } else if (root.getRight() == null) { // Se não tem filho direito
                root = root.getLeft();
            } else { // Caso com dois filhos
                Node fatherRightLeft = farLeftPossible(root, root.getRight());
                Node substitute = fatherRightLeft.getRight();
                substitute.setLeft(root.getLeft());
                fatherRightLeft.setLeft(null);
                root = substitute; // Substitui a raiz pela substituta
            }
            return true; // A raiz foi removida
        }
    
        // Para outros casos, procure o pai do nó a ser removido
        Node dad = findNode(root, value);
        if (dad == null) {
            return false; // O valor não foi encontrado
        }
    
        Node son = (dad.getValue() < value) ? dad.getRight() : dad.getLeft();
    
        // Primeiro caso -> remover folhas
        if (son.getRight() == null && son.getLeft() == null) {
            if (dad.getValue() < value) {
                dad.setRight(null);
            } else {
                dad.setLeft(null);
            }
            return true;
        }
    
        //Segundo caso -> somente um filho
        if (son.getRight() == null) {
            if (dad.getValue() < value) {
                dad.setRight(son.getLeft());
            } else {
                dad.setLeft(son.getLeft());
            }
        } else if (son.getLeft() == null) {
            if (dad.getValue() < value) {
                dad.setRight(son.getRight());
            } else {
                dad.setLeft(son.getRight());
            }
        }
    
        // Terceiro caso -> possui dois filhos
        if (son.getRight() != null && son.getLeft() != null) {
            Node fatherRightLeft = farLeftPossible(son, son.getRight());//encontrou o pai do mais a esquerda possivel
            Node substitute = fatherRightLeft.getLeft();// pegou o nó mais a esquerda possivel
            fatherRightLeft.setLeft(substitute.getRight()); 
            substitute.setRight(son.getRight());// o substituto recebeu a direita do nó filho
            substitute.setLeft(son.getLeft());// o substituto recebeu a esquerda do nó filho
            son.setRight(null); // removeu a esquerda
            son.setLeft(null); // removeu a direita
            if (dad.getValue() < value) {
                dad.setRight(substitute);
            } else {
                dad.setLeft(substitute);
            }
        }
    
        return true;
    }

    public void removeNum(int value) {
        remove(value);
    }

    // encontrar o no substituto
    private Node farLeftPossible(Node dad, Node son) {
        if (son.getLeft() == null)
            return dad;
        return farLeftPossible(son, son.getLeft());
    }

    //questão 01) Método que conta o número de nós de uma árvore binária
    private int privCountNodes(Node current){
        if(current == null)
            return count;
        else {
            count++;
            privCountNodes(current.getLeft());  
            privCountNodes(current.getRight());
            return count;
        }
    }
    
    public void countNodes(){
        int nodes = privCountNodes(root);
        System.out.println("Amount nodes : "+ nodes);
    }

    //questão 02) Método que conta o número de nós não-folha de uma árvore binária
    private int privNotTerminalNodes(Node current){
        if (current == null) 
            return 0;
        int count = 0;
        if (current.getLeft() != null || current.getRight() != null) {
            count = 1; 
        }
        count += privNotTerminalNodes(current.getLeft());
        count += privNotTerminalNodes(current.getRight());
        return count;
    }

    public void countNotTerminalNodes(){
        int nodes = privNotTerminalNodes(root);
        System.out.println("Amount non-Terminal nodes : "+ nodes);
    }

    //questão 03)Método que conta o número de nós folhas de uma árvore binária
    private int privTerminalNodes(Node current){
        if(current == null)
            return 0;
        int count = 0;
        if (current.getLeft() == null && current.getRight()== null)
            count=1;
            
        count += privTerminalNodes(current.getLeft());
        count += privTerminalNodes(current.getRight());
        return count;
    }

    public void countTerminalNodes(){
        int nodes = privTerminalNodes(root);
        System.out.println("Amount terminal nodes: "+nodes);
    }

    //questão 04) Método que calcula a altura de uma árvore binária
    private int privHeightTree(Node current){
        if (current == null)
            return 0;
        int leftcount =0;
        int rightcount = 0;
        if (current.getLeft() != null){
            leftcount=1;
            leftcount += privHeightTree(current.getLeft());
        }
        if(current.getRight() != null){
            rightcount = 1;
            rightcount += privHeightTree(current.getRight());
        }
        if(rightcount > leftcount)
            return rightcount;
        else {
            return leftcount;
        }
    }

    public void heightTree(){
        int height = privHeightTree(root);
        System.out.println("Height tree: " + height);
    }

    //questão 05) Método que remove todos elementos pares
    private boolean privRemoveEvenNumbers(Node current){
        if(current == null)
            return false;
        else {
            privRemoveEvenNumbers(current.getLeft());
            privRemoveEvenNumbers(current.getRight());
            if (current.getValue() %2==0){
                remove(current.getValue());
                return true;
            }
            return false;
        }
    }

    public void removeEvenNumbers(){
        privRemoveEvenNumbers(root);
        System.out.println("Removed");
    }

    //questão 06) Método que faz um espelhamento da árvore
    private void privMirroringTree(Node current){
        if(current == null){
            return;
        } else {
            Node right = current.getRight();
            Node left = current.getLeft();
            current.setRight(left);
            current.setLeft(right);
            privMirroringTree(current.getLeft());
            privMirroringTree(current.getRight());
        }
    }

    public void mirroringTree(){
        privMirroringTree(root);
        preOrder();
    }

    //questão 07) Método não-recursivo para encaminhamento da árvore
}
