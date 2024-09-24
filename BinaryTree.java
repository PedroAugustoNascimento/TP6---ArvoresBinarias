public class BinaryTree {
    Node root;

    //construtor
    public BinaryTree(){
        root = null;
    }

    //inserir no começo 
    //se o elemento for igual, não insere
    private Node insert(Node newNode, Node current){
        if (current == null)
            return newNode;
        if (current.getValue()> newNode.getValue())
            current.setLeft(insert(newNode, current.getLeft()));
        if (current.getValue()< newNode.getValue())
            current.setRight(insert(newNode, current.getRight())); 
        
        return current;
    }

    //metodo publico para o main
    public void insertAtBegining(Node newNode){
        root = insert(newNode, root);
    }

    //impressao pre ordem
    private void preorder(Node node){
        if (node != null){
            System.out.println("Element: " + node.getValue());
            preorder(node.getLeft()); //E
            preorder(node.getRight()); //D
        }
    }

    //metodo publico
    public void preOrder(){
        preorder(root);
    }

    //impressao pos ordem
    private void posorder(Node node){
        if (node != null){
            posorder(node.getLeft()); //E
            posorder(node.getRight()); //D
            System.out.println("Element: "+ node.getValue()); //R
        }
    }

    //metodo publico
    public void posOrder(){
        posorder(root);
    }

    //impressao em ordem
    private void onorder(Node node){
        if(node != null){
            onorder(node.getLeft()); //E
            System.out.println(node.getValue()); //R
            onorder(node.getRight()); //D
        }
    }

    //metodo publico
    public void onOrder(){
        onorder(root);
    }

    //encontrar elemento
    private Node findNode(Node current, int value){
        if (current == null)
            return null;

        if (current.getValue() < value){
            if (current.getRight()!= null){
                if (current.getRight().getValue() == value)
                    return current;
            } 
        }
        else {
            if (current.getValue()> value){
                if (current.getLeft() == null){
                    if (current.getLeft().getValue() == value)
                        return current;
                }    
            }    
        }

        if (current.getValue()> value)
            return findNode(current.getRight(), value);
        if (current.getValue()< value)
            return findNode(current.getLeft(), value);

        return null;
    }

    // remover
    private boolean remove(int value){
        if (root == null)
            return false;
        else {
            Node dad;
            Node son;

            if (root.getValue() == value){
                dad = root;
                son = root;
            }
            else {
                dad = findNode(root, value);
            }
            
            if(dad.getValue() < value)
                son = dad.getRight();
            else {
                son = dad.getLeft();
            }

            if (son.getLeft() == null && son.getRight() == null){ //Primeiro caso -> remover folhas
                if (dad.getValue() > value)
                    dad.setRight(null);
                if (dad.getValue()< value)
                    dad.setLeft(null);
                son = null;
                return true;
            }
            else if (son.getLeft() != null & son.getRight() != null){ //Terceiro caso -> possui dois filhos
            Node fatherRightLeft = farLeftPossible(son, son.getRight()); //encontrou o pai do mais a esquerda possivel
            Node substitute = fatherRightLeft.getLeft(); // pegou o nó mais a esquerda possivel
            fatherRightLeft.setLeft(null); // setou a esquerda do pai como null
            substitute.setRight(son.getRight()); //o substituto recebeu a direita do nó filho
            son.setLeft(null); // removeu a esquerda
            son.setRight(null); // removeu a direita
            son = null;
            if (dad.getValue() < value)
                dad.setRight(substitute);
            else if (dad.getValue() > value){
                dad.setLeft(substitute);
            } else {
                root = substitute;
            }
            return true;
            }

            else { // Segundo caso -> somente um filho
                if (son.getRight() == null){ // se a direita é nula, removo a esquerda
                    if (dad.getValue() < value)
                        dad.setRight(son.getLeft()); 
                    else {
                        dad.setLeft(son.getLeft());
                        son.setLeft(null);
                    }
                }
                if (son.getLeft()== null){ // se a esquerda é nula, removo a direita
                    if (dad.getValue() > value)
                        dad.setRight(son.getRight());
                    else {
                        dad.setLeft(son.getRight());
                        son.setRight(null);
                    }
                son = null;
                }
            return true;
            } 
        
        }
    }

    public void removeNum(int value){
        remove(value);
    }

    //encontrar o no substituto 
    private Node farLeftPossible(Node dad, Node son){
        if (son.getLeft() == null)
            return dad;
        return farLeftPossible(son, son.getLeft());
    }


}
